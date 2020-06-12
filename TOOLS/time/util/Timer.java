package util;

/**
 * This is a tool to time
 *
 * @param starttime This Parameter captures the time at the beginning of a program
 * @param endtime   This Parameter captures the time at the end of a program
 * @Author BiteCoding --> https://github.com/BiteCoding
 */

import java.util.Date;

public class Timer {
    private long starttime;
    private long endtime;

    public Timer() {
        starttime = 0;
        endtime = 0;
    }

    public void start() {
        starttime = new Date().getTime();
    }

    public void end() {
        endtime = new Date().getTime();
    }

    private long deltaTime() {
        if (starttime == 0 || endtime == 0) {
            return -1;
        } else {
            return endtime-starttime;
        }
    }

    public String timeNeeded(){
        return "Time needed " + deltaTime() + " ms";
    }
}