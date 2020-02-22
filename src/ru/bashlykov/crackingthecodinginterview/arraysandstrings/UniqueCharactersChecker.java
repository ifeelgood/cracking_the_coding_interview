package ru.bashlykov.crackingthecodinginterview.arraysandstrings;

import java.util.HashSet;
import java.util.Set;

public class UniqueCharactersChecker {
    //Implement an algorithm to determine if a string has all unique characters

    public boolean check(String str) {
//        return checkWithHashSet(str);
        return checkBooleanArray(str);
//        return checkWithoutAdditionalDataStructures(str);
    }

    public boolean checkWithHashSet(String str) {
        // use hasSet to store characters of the string while iterating through it
        Set<Integer> chars = new HashSet<>();
        return !str.chars().filter(c -> !chars.add(c)).findAny().isPresent();
    }

    public boolean checkWithoutAdditionalDataStructures(String str) {
        for (int i = 0; i < str.length() - 1; i ++) {
            for (int j = i +1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j))
                    return false;
            }
        }
        return true;
    }

    public boolean checkBooleanArray(String str) {
        if (str.length() > 256) return false;

        boolean[] chars = new boolean[256];

        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (chars[val]) return false;
            chars[val] = true;
        }

        return true;
    }

    public static void main(String[] args){
        UniqueCharactersChecker uc = new UniqueCharactersChecker();
        System.out.println("abc: " + uc.check("abc"));
        System.out.println("abcb: " + uc.check("abcb"));
        System.out.println("abcc: " + uc.check("abcc"));
        System.out.println(": " + uc.check(""));
    }
}
