package ru.bashlykov.crackingthecodinginterview.arraysandstrings;

import java.util.Arrays;

public class PermutationChecker {

    public boolean isPermutation(String str1, String str2) {
        return isPermutationOptimized(str1, str2);
    }

    public boolean isPermutationArraySort(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }

    public boolean isPermutationOptimized(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        //below we assume string contain ASCII chars only
        int[] charCounts = new int[256];
        for (char c1 : str1.toCharArray()) {
            charCounts[c1]++;
        }

        for (char c2 : str2.toCharArray()) {
            int charCount = --charCounts[c2];
            if (charCount < 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        PermutationChecker checker = new PermutationChecker();
        System.out.println(checker.isPermutation("abc", "acb"));
        System.out.println(checker.isPermutation("abc", "ac"));
        System.out.println(checker.isPermutation("abc", "abc"));
        System.out.println(checker.isPermutation("abc", "abd"));
        System.out.println(checker.isPermutation("", ""));
    }
}
