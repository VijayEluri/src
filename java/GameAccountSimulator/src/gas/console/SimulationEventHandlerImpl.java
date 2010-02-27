package gas.console;

import gas.common.*;

public class SimulationEventHandlerImpl implements SimulationEventHandler {

    public SimulationEventHandlerImpl() {
        pi = new PurchaseInfo();
    }

    public void handleBeginCycle() {
        pi.clear();
    }

    public void handleEndCycle() {
        pi.printReceipt();
        System.out.println("--------------------------------------------------------------------------------");
    }

    public void handlePurchase(PurchaseEventParams e) {
        pi.purchase(e.getPurchasedLand());
    }

    public void init() {
        pi.clear();
    }

    public void handleEndSimulation(SimulationEndEventParams e) {
        System.out.println("Simulation ended ...");
        System.out.println(String.format("Total time elapsed: %d days %d hours and %d minutes", e.getTotalTimeElapsed() / 1440, (e.getTotalTimeElapsed() % 1440) / 60, (e.getTotalTimeElapsed() % 1440) % 60));
    }

    public void handleStartSimulation() {
        System.out.println("Simulation started ...");
    }

    private PurchaseInfo pi;
}
