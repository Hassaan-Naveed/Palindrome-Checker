package com.sparta;

public class PalWhile implements PalInterface{

    @Override
    public boolean isPalindrome(String text) {
        int length = text.length();

        int front = 0;
        int back = length-1;

        while (back > front) {
            char frontChar = text.charAt(front++);
            char backChar = text.charAt(back--);

            if (frontChar != backChar) {
                return false;
            }
        }
        return true;
    }
}
