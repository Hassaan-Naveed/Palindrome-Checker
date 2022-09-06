package com.sparta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PalindromeCheck pal = new PalindromeCheck();

        String sentence = "This is a TacoCat.";
        ArrayList<String> palindromesFound = pal.getInput(sentence);

        System.out.println(Arrays.toString(palindromesFound.toArray()));
    }
}