package club.banyuan;

import java.util.LinkedList;
import java.util.List;


public class TimerImpl implements Timer {
    public long startTime = 0;
    public long terminalTime = 0;
    public long actualCostTime = 0;


    @Override
    public void start() throws IllegalStateException {
        if (startTime != 0) {
            throw new IllegalStateException("请reset！");
        }
        reset();
        startTime = System.currentTimeMillis();
    }


    @Override
    public void stop() throws IllegalStateException {
        if (startTime == 0) {
            throw new IllegalStateException("请先start！");
        }else if(actualCostTime!=0){
            throw new IllegalStateException("请先reset！");
        }
        else {
            terminalTime = System.currentTimeMillis();
            actualCostTime = terminalTime - startTime;
        }

    }

    @Override
    public void reset() {
        startTime = 0;
        terminalTime = 0;
        actualCostTime = 0;
    }

    @Override
    public long getTimeMillisecond() {
        if (actualCostTime > 0) {
            return actualCostTime;
        } else
            return 0;
    }


}
