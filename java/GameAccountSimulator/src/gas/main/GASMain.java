package gas.main;

import gas.console.ConsoleClient;

public class GASMain {

    public static void main(String[] args) {
        CommandLine cl = new CommandLine(args);

        if (cl.isGui()) {
            initGui(cl);
        } else {
            initConsole(cl);
        }
    }
    
    private static void initGui(CommandLine cl) {

    }

    private static void initConsole(CommandLine cl) {
        ConsoleClient cc = new ConsoleClient(cl);
        cc.run();
    }
}
