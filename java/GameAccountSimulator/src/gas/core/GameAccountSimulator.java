package gas.core;

import gas.common.Land;
import gas.common.SimulationEventHandler;
import gas.common.SimulationEndEventParams;
import gas.common.PurchaseEventParams;
import java.util.ArrayList;

public class GameAccountSimulator {

    public GameAccountSimulator() {
        lands = new LandCollection();
        accountBalance = 0;
        endingConditions = new ArrayList<EndingConditionType>();
        targetIncome = 0;
        totalTimeElapsed = 0;
        tickDuration = 50;
        targetCyclesCount = Integer.MAX_VALUE;
    }

    public void createCommonLandList() {
        lands.createCommonLandCollection();
    }

    public void createCustomizedLandList(int[] counts) {
        lands.createCustomizedLandCollection(counts);
    }

    public void addEndingConditionType(EndingConditionType ect) {
        this.endingConditions.add(ect);
    }

    public void removeEndingConditionType(EndingConditionType ect) {
        this.endingConditions.remove(ect);
    }

    public void setTargetIncome(double balance) {
        this.targetIncome = balance;
    }

    public void setStartingAmount(double amount) {
        this.accountBalance = amount;
    }

    public void setTickDuration(int tickDuration) {
        this.tickDuration = tickDuration;
    }

    public int getTargetCyclesCount() {
        return targetCyclesCount;
    }

    public void setTargetCyclesCount(int targetCyclesCount) {
        this.targetCyclesCount = targetCyclesCount;
    }

    public void setSimulationEventHandler(SimulationEventHandler seh) {
        this.seh = seh;
    }

    public void updateAccount() {
        seh.handleBeginCycle();

        // buy new land(s)
        boolean buyMore = true;

        while (buyMore) {
            buyMore = false;

            if (lands.getTotalIncome() > 0) {
                Land land = lands.getBestLand();
                double balance = lands.buyLand(land, accountBalance);

                if (balance > 0) {
                    seh.handlePurchase(new PurchaseEventParams(land));
                    accountBalance = balance;
                    buyMore = true;
                }
            }
            else {
                Land land = lands.getEffortableLand(accountBalance);
                if (land != null) {
                    accountBalance = lands.buyLand(land, accountBalance);
                    seh.handlePurchase(new PurchaseEventParams(land));
                }
                else {
                    // ouch! we haven't enough money to buy first land!
                    endingConditions.add(EndingConditionType.FORCED);
                }
            }
        }

        totalTimeElapsed += tickDuration;
        accountBalance += lands.getTotalIncome();
        seh.handleEndCycle();
    }

    public void run() {
        seh.handleStartSimulation();
        while (!passedEndingCondition()) {
            updateAccount();
        }
        seh.handleEndSimulation(new SimulationEndEventParams(totalTimeElapsed));
    }

    private boolean passedEndingCondition() {
        boolean passed = false;
        for (EndingConditionType ect : endingConditions) {
            switch (ect) {
                case TARGET_INCOME:
                    passed = (targetIncome <= lands.getTotalIncome());
                    break;
                case CYCLES_PASSED:
                    passed = (totalTimeElapsed / tickDuration) == targetCyclesCount;
                    break;
                case FORCED:
                    passed = true;
                    break;
                default:
                    passed = false;
            }
            if (passed)
                break;
        }

        return passed;
    }

    private LandCollection lands;
    private double accountBalance;
    private long totalTimeElapsed;
    private int tickDuration;

    private ArrayList<EndingConditionType> endingConditions;
    private double targetIncome;
    private int targetCyclesCount;
    private SimulationEventHandler seh;
}
