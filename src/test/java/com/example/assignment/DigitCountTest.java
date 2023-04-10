package com.example.assignment;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DigitCountTest {
    //    java DigitCounter 1 35 5
    @Test
    void testNumber() {
        Integer endNum = 35;
        Integer startNum = 1;
        int seriesCounter = 0;
        Integer param = 5;
        List<Integer> seriesNumbers = new ArrayList<>();
        Integer runningSeqNumber = 0;
        while (runningSeqNumber <= endNum) {
            runningSeqNumber = param + 10 * seriesCounter;
            if (runningSeqNumber <= endNum && runningSeqNumber > startNum) {
                seriesNumbers.add(runningSeqNumber);
            }
            seriesCounter++;
        }
        List<String> stringList = seriesNumbers.stream().map(String::valueOf).collect(Collectors.toList());
        String joinedString = String.join("", stringList);
        Stream<Character> charStream = new String(joinedString).chars().mapToObj(i -> (char)i);
       long count = charStream.filter(u -> u.toString().equalsIgnoreCase(param.toString())).count();
       System.out.println(param+" occurs "+count+" times in the number series "+startNum+"..."+endNum);
       assertEquals(4,count);
    }
//    java DigitCounter 1 35 3
    @Test
    void testNumber2() {
        Integer endNum = 35;
        Integer startNum = 1;
        int seriesCounter = 0;
        Integer param = 3;
        List<Integer> seriesNumbers = new ArrayList<>();
        Integer runningSeqNumber = 0;
        while (runningSeqNumber <= endNum) {
            runningSeqNumber = param + 10 * seriesCounter;
            if (runningSeqNumber <= endNum && runningSeqNumber > startNum) {
                seriesNumbers.add(runningSeqNumber);
            }
            seriesCounter++;
        }
        List<String> stringList = seriesNumbers.stream().map(String::valueOf).collect(Collectors.toList());
        String joinedString = String.join("", stringList);
        Stream<Character> charStream = new String(joinedString).chars().mapToObj(i -> (char)i);
        long count = charStream.filter(u -> u.toString().equalsIgnoreCase(param.toString())).count();
        System.out.println(param+" occurs "+count+" times in the number series "+startNum+"..."+endNum);
        assertEquals(5,count);
    }

    @Test
    //java DigitCounter 7 77 7
    void testNumber3() {
        Integer endNum = 77;
        Integer startNum = 7;
        int seriesCounter = 0;
        Integer param = 7;
        List<Integer> seriesNumbers = new ArrayList<>();
        Integer runningSeqNumber = 0;
        while (runningSeqNumber <= endNum) {
            runningSeqNumber = param + 10 * seriesCounter;
            if (runningSeqNumber <= endNum && runningSeqNumber >= startNum) {
                seriesNumbers.add(runningSeqNumber);
            }
            seriesCounter++;
        }
        List<String> stringList = seriesNumbers.stream().map(String::valueOf).collect(Collectors.toList());
        String joinedString = String.join("", stringList);
        Stream<Character> charStream = new String(joinedString).chars().mapToObj(i -> (char)i);
        long count = charStream.filter(u -> u.toString().equalsIgnoreCase(param.toString())).count();
        System.out.println(param+" occurs "+count+" times in the number series "+startNum+"..."+endNum);
        assertEquals(9,count);
    }

}
