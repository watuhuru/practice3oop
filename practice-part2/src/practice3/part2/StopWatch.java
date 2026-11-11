package practice3.part2;

public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch() { start(); }
    public long getStartTime() { return startTime; }
    public long getEndTime() { return endTime; }
    public void start() { startTime = System.currentTimeMillis(); endTime = startTime; }
    public void stop() { endTime = System.currentTimeMillis(); }
    public long getElapsedTime() { return endTime - startTime; }
}
