package gas.console;

import gas.main.CommandLine;
import gas.common.ConfigFile;
import gas.core.GameAccountSimulator;
import gas.core.EndingConditionType;

public class ConsoleClient {

    public ConsoleClient(CommandLine cl) {
        this.cf = new ConfigFile(cl.getConfigPath());
        this.gas = new GameAccountSimulator();
        this.cl = cl;
    }

    public void run() {
        try {
            cf.parse();
            gas.createCustomizedLandList(cf.getLandCounts());
            gas.setTargetIncome(cf.getTargetIncome());
            gas.addEndingConditionType(EndingConditionType.TARGET_INCOME);
            gas.setStartingAmount(cf.getStartingAmount());
            gas.setSimulationEventHandler(new SimulationEventHandlerImpl());
            if (cl.getCyclesCount() != Integer.MAX_VALUE) {
                gas.addEndingConditionType(EndingConditionType.CYCLES_PASSED);
                gas.setTargetCyclesCount(cl.getCyclesCount());
            }
            gas.run();
        } catch (Exception ex) {
            handleException(ex);
        }
    }

    private void handleException(Exception ex) {
        System.out.println(String.format("Exception occured! %s", ex.toString()));
    }

    private ConfigFile cf;
    private GameAccountSimulator gas;
    private CommandLine cl;
}
