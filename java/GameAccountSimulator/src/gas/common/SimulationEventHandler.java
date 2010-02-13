package gas.common;

public interface SimulationEventHandler {
    public void init();
    public void handlePurchase(PurchaseEventParams e);
    public void handleBeginCycle();
    public void handleEndCycle();
    public void handleEndSimulation(SimulationEndEventParams e);
    public void handleStartSimulation();
}
