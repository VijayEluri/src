package gas.common;


public class SimulationEndEventParams {

    public SimulationEndEventParams(long totalTimeElapsed) {
        this.totalTimeElapsed = totalTimeElapsed;
    }

    public long getTotalTimeElapsed() {
        return totalTimeElapsed;
    }

    public void setTotalTimeElapsed(long totalTimeElapsed) {
        this.totalTimeElapsed = totalTimeElapsed;
    }
    
    long totalTimeElapsed;
}
