package com.sparta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PalindromeCheck {
    public ArrayList<String> getWords(String sentence) {
        String clean = sentence.replaceAll("[^A-Z^a-z^\\s+]", "").toLowerCase();
        clean = clean.replaceAll("(\\b[a-z] \\b|\\b [a-z]\\b)", "");

        String[] strSplit = clean.split("\\s+");
        return new ArrayList<>(Arrays.asList(strSplit));
    }

    public ArrayList<String> checkPalindromes(PalInterface pal, String sentence) {
        ArrayList<String> wordList = new ArrayList<>(getWords(sentence));
        ArrayList<String> palindromesFound = new ArrayList<>();

        for (String word : wordList) {
            if (pal.isPalindrome(word)) {
                palindromesFound.add(word);
            }
        }

        return palindromesFound;
    }

    public ArrayList<String> getInput(String sentence) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> palindromesFound = new ArrayList<>();

        boolean loop = true;
        while(loop) {
            System.out.println("Which algorithm would you like to use? (1, 2, 3) :");
            String input = scanner.next();

            switch (input) {
                case "1" -> {
                    PalReverse palReverse = new PalReverse();
                    palindromesFound = checkPalindromes(palReverse, sentence);
                    loop = false;
                }
                case "2" -> {
                    PalFor palFor = new PalFor();
                    palindromesFound = checkPalindromes(palFor, sentence);
                    loop = false;
                }
                case "3" -> {
                    PalWhile palWhile = new PalWhile();
                    palindromesFound = checkPalindromes(palWhile, sentence);
                    loop = false;
                }
                default -> System.out.println("Not a valid algorithm! Try Again!");
            }
        }
        return palindromesFound;
    }





}
