package com.tsystems.javaschool.tasks.subsequence;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Subsequence {

    /**
     * Checks if it is possible to get a sequence which is equal to the first
     * one by removing some elements from the second one.
     *
     * @param x first sequence
     * @param y second sequence
     * @return <code>true</code> if possible, otherwise <code>false</code>
     */
    @SuppressWarnings("rawtypes")
    public boolean find(List x, List y) {
        if(checkLists(x,y)) {
            if (x.isEmpty()) return true;

            Queue<Object> yQueue = new LinkedList<>(y);
            Queue<Object> xQueue = new LinkedList<>(x);

            Object xObj;
            Object yObj;
            xObj = xQueue.remove();

            while (!yQueue.isEmpty()) {
                yObj = yQueue.remove();
                if (yObj.equals(xObj)) {
                    if (xQueue.isEmpty()) return true;
                    xObj = xQueue.remove();
                }
            }
        }
        return false;
    }

    private static boolean checkLists(List x, List y){
        if( x == null || y == null ) throw new IllegalArgumentException();
        return x.size() <= y.size();
    }
}
