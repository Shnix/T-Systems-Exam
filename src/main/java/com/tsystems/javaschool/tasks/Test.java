package com.tsystems.javaschool.tasks;

import com.tsystems.javaschool.tasks.calculator.Calculator;
import com.tsystems.javaschool.tasks.pyramid.PyramidBuilder;
import com.tsystems.javaschool.tasks.subsequence.Subsequence;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        List<Integer> xList = Stream.of(1,2,3,4,5).collect(Collectors.toList());
        List<Integer> yList = Stream.of(1,5,7,2,4,4,4,3,900,987,5).collect(Collectors.toList());
        System.out.println(new Subsequence().find(xList,yList));

         int[][] pyramid = new PyramidBuilder()
                 .buildPyramid(Stream.of(1,8,4,2,7,16)
                         .collect(Collectors.toList()));

        for (int[] ints : pyramid) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.print("\n");
        }
        System.out.println(new Calculator().evaluate("2((+3"));
    }
}
