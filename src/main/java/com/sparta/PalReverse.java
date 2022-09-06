package com.sparta;

public class PalReverse implements PalInterface {

    @Override
    public boolean isPalindrome(String text) {
        String reverse = new StringBuilder(text).reverse().toString();
        return reverse.equals(text);
    }
}
