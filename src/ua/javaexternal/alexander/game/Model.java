package ua.javaexternal.alexander.game;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private int minBarrier;
    private int maxBarrier;
    private int secretValue;

    private List<Integer> log = new ArrayList<Integer>();

    public boolean checkValue(int value) {
        log.add(value);
        if (value == secretValue) {
            return true;
        } else if (value > secretValue) {
            maxBarrier = value;
        } else {
            minBarrier = value;
        }
        return false;
    }

    public void setPrimaryBarrier(int minBarrier, int maxBarrier) {
        if (minBarrier > maxBarrier) {
            int tmp = minBarrier;
            minBarrier = maxBarrier;
            maxBarrier = tmp;

        }
        this.minBarrier = minBarrier;
        this.maxBarrier = maxBarrier;
    }

    public void setSecretValue() {
        secretValue = (int) (Math.random() *
                (maxBarrier - minBarrier + 1) + minBarrier);
    }

    public int getSecretValue() {
        return secretValue;
    }

    public int getMinBarrier() {
        return minBarrier;
    }

    public int getMaxBarrier() {
        return maxBarrier;
    }

    public List<Integer> getLog() {
        return log;
    }

    public int getAttemptsCount(){ return log.size();}
}
