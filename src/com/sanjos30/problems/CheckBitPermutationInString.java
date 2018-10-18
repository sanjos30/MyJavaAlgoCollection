package com.sanjos30.problems;

import java.util.ArrayList;
import java.util.List;
public class CheckBitPermutationInString {

    public static void main(String[] args) {
        System.out.println(isValid("101010101110101110110", 3));
    }

    public static boolean isValid(String s, int k) {
        List<String> l = getAllBinarySubsets(k);
        for (String binary : l) {
            if (s.indexOf(binary) == -1) {
                return false;
            }
        }
        return true;
    }

    public static List<String> getAllBinarySubsets(int k) {
        List<String> list = new ArrayList<>();
        String format = "%0" + k + "d";

        for(int i = 0; i < Math.pow(2, k); i++) {
            list.add(String.format(format, Integer.valueOf(Integer.toBinaryString(i))));
        }
        return list;
    }
}

