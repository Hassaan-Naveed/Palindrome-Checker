package com.sparta;

public class PalFor implements PalInterface{

    @Override
    public boolean isPalindrome(String text) {
        int length = text.length();

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) != text.charAt(length-1-i)) {
                return false;
            }
        }
        return true;
    }
}
