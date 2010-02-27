package gas.main;

public class CommandLine {

    public CommandLine(String[] args) {
        try {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-config")) {
                    configPath = args[i+1];
                } else if (args[i].equals("-c")) {
                    cyclesCount = Integer.parseInt(args[i+1]);
                } else if (args[i].equalsIgnoreCase("-gui")) {
                    gui = true;
                }
            }
        } catch (Exception ex) {
            //handleException(ex);
        }
    }

    public String getConfigPath() {
        return configPath;
    }

    public int getCyclesCount() {
        return cyclesCount;
    }

    public boolean isGui() {
        return gui;
    }

    private int cyclesCount = Integer.MAX_VALUE;
    private String configPath = "C:\\temp\\GASConfig.xml";
    private boolean gui = false;
}
