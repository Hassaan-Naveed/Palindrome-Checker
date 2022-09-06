# Palindrome Checker Application

---

## Outline

This application takes a user input to decide which palindrome checking algorithm to use. \
It checks each word within a given sentence for occurence of palindromes. \
Outputs each palindromic word within the sentence

### Class Outline
- Main
- PalindromeCheck
- PalReverse
- PalFor
- PalWhile

### Interface Outline 
- PalInterface
---

## Classes

### Main
Entry point of the application, initiates input and output.

#### main()
Initialises PalindromeCheck class and provides a sentence to pass to the getInput method. \
Recieves output from this method and outputs list of palindromes from the sentence to the console
```java
public static void main(String[] args) {
    PalindromeCheck pal = new PalindromeCheck();

    String sentence = "This is a TacoCat.";
    ArrayList<String> palindromesFound = pal.getInput(sentence);

    System.out.println(Arrays.toString(palindromesFound.toArray()));
}
```
---

### PalindromeCheck
Handles sentence cleaning and user input, as well as passing data to be processed and returning it to the Main class

#### getWords()
Takes String sentence as parameter\
Removes any none alphabet characters and single character words from the sentence and converts to lower case\
Then splits sentence by whitespace and returns as ArrayList
```java
public ArrayList<String> getWords(String sentence) {
    String clean = sentence.replaceAll("[^A-Z^a-z^\\s+]", "").toLowerCase();
    clean = clean.replaceAll("(\\b[a-z] \\b|\\b [a-z]\\b)", "");

    String[] strSplit = clean.split("\\s+");
    return new ArrayList<>(Arrays.asList(strSplit));
}
```

#### checkPalindromes()
Takes the PalInterface and sentence String as parameter\
Calls getWords() to generate wordlist\
Iterates through wordlist and passes word to palindrome checker
```java
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
```

#### getInput()
Initialises scanner object and gets user input until input matches "1", "2", or "3"
1. Reversal algorithm\
2. For loop algorithm\
3. While loop algorithm

Otherwise displays error message and repeats loop\
Returns array of found palindromes
```java
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
```
---

### PalReverse
Reversal palindrome checker class. Implements PalInterface

#### isPalindrome()
Uses StringBuilder object to reverse string\
Returns true if reversed string matches original
```java
@Override
public boolean isPalindrome(String text) {
    String reverse = new StringBuilder(text).reverse().toString();
    return reverse.equals(text);
}
```
---

### PalFor
For loop palindrome checker class. Implements PalInterface

#### isPalindrome()
Uses for loop to iterate through word and compare values at first and last index, and move through the indexes\
Stops and returns false if mismatch exists, otherwise returns true
```java
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
```
---

### PalWhile
While loop palindrome checker class. Implements PalInterface

#### isPalindrome()
Uses while loop to iterate through word and compare values at first and last index, and move through the indexes\
Stops and returns false if mismatch exists, otherwise returns true
```java
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
```
---

## Interfaces
### PalInterface
Provides `isPalindrome()` method\
Implemented by PalWhile, PalFor, and PalReverse classes
```java
public interface PalInterface {

    boolean isPalindrome(String text);
}
```