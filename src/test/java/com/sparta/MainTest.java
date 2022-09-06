package com.sparta;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class MainTest {
    PalindromeCheck pal = new PalindromeCheck();

    PalReverse palReverse = new PalReverse();
    PalFor palFor = new PalFor();
    PalWhile palWhile = new PalWhile();

    String onePalindrome = "The time is noon.";
    String multiplePalindromes = "A tacocat called Anna sat in a racecar.";
    String noPalindrome = "These are not the palindromes you are looking for.";

    ArrayList<String> testDataOne = new ArrayList<>(Arrays.asList("noon"));
    ArrayList<String> testDataMultiple = new ArrayList<>(Arrays.asList("tacocat", "anna", "racecar"));
    ArrayList<String> testDataNone = new ArrayList<>(Arrays.asList());
    ArrayList<String> testDataWords = new ArrayList<>(Arrays.asList("tacocat", "called", "anna", "sat", "in", "racecar"));

    // getWords ----------------------------------------------------------------------------------
    @Test
    @DisplayName("Reverse -- One Palindrome")
    public void testGetWords() {
        Assertions.assertEquals(testDataWords, pal.getWords(multiplePalindromes));
    }

    // Reversal Algorithm ------------------------------------------------------------------------
    @Test
    @DisplayName("Reverse -- One Palindrome")
    public void testReverseOne() {
        Assertions.assertEquals(testDataOne, pal.checkPalindromes(palReverse, onePalindrome));
    }

    @Test
    @DisplayName("Reverse -- Multiple Palindromes")
    public void testReverseMultiple() {
        Assertions.assertEquals(testDataMultiple, pal.checkPalindromes(palReverse, multiplePalindromes));
    }

    @Test
    @DisplayName("Reverse -- No Palindromes")
    public void testReverseNone() {
        Assertions.assertEquals(testDataNone, pal.checkPalindromes(palReverse, noPalindrome));
    }

    // For Loop Algorithm ------------------------------------------------------------------------
    @Test
    @DisplayName("For -- One Palindrome")
    public void testForOne() {
        Assertions.assertEquals(testDataOne, pal.checkPalindromes(palFor, onePalindrome));
    }

    @Test
    @DisplayName("For -- Multiple Palindromes")
    public void testForMultiple() {
        Assertions.assertEquals(testDataMultiple, pal.checkPalindromes(palFor, multiplePalindromes));
    }

    @Test
    @DisplayName("For -- No Palindromes")
    public void testForNone() {
        Assertions.assertEquals(testDataNone, pal.checkPalindromes(palFor, noPalindrome));
    }

    // While Loop Algorithm ------------------------------------------------------------------------
    @Test
    @DisplayName("While -- One Palindrome")
    public void testWhileOne() {
        Assertions.assertEquals(testDataOne, pal.checkPalindromes(palWhile, onePalindrome));
    }

    @Test
    @DisplayName("While -- Multiple Palindromes")
    public void testWhileMultiple() {
        Assertions.assertEquals(testDataMultiple, pal.checkPalindromes(palWhile, multiplePalindromes));
    }

    @Test
    @DisplayName("While -- No Palindromes")
    public void testWhileNone() {
        Assertions.assertEquals(testDataNone, pal.checkPalindromes(palWhile, noPalindrome));
    }

}