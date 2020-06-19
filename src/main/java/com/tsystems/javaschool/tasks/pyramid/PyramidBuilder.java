package com.tsystems.javaschool.tasks.pyramid;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PyramidBuilder {

    /**
     * Builds a pyramid with sorted values (with minumum value at the top line and maximum at the bottom,
     * from left to right). All vacant positions in the array are zeros.
     *
     * @param inputNumbers to be used in the pyramid
     * @return 2d array with pyramid inside
     * @throws {@link CannotBuildPyramidException} if the pyramid cannot be build with given input
     */
    public int[][] buildPyramid(List<Integer> inputNumbers) {

        if(inputNumbers.contains(null)) throw new CannotBuildPyramidException();
        int rows = getRows(inputNumbers);
        if(rows == -1) throw new CannotBuildPyramidException();

        int columns = 2 * rows - 1;
        int[][] pyramid = new int[rows][columns];
        Collections.sort(inputNumbers);
        Queue<Integer> integerQueue = new LinkedList<>(inputNumbers);
//        top of pyramid
        int startPoint = (pyramid[0].length) / 2;

        for(int i = 0; i < pyramid.length; i++) {

            int start = startPoint;

            for(int j = 0; j <= i; j++) {
                pyramid[i][start] = integerQueue.remove();
                start += 2;
            }
//            first element of next raw will be 1 digit left
            startPoint --;
        }
        return pyramid;
    }

//    digits count check
    private static int getRows(List<Integer> inputNumbers){
        double res = (Math.sqrt(1+ 8 * inputNumbers.size()) - 1)/2;
        return res == Math.ceil(res) ? (int)res : -1;
    }



}
