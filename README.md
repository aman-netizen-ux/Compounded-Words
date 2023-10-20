# Compounded-Words

# Overview:
The Compounded Words Finder is a Java program that takes a list of words as input and identifies the longest and second longest compounded words in the list. A compounded word is one that can be constructed by concatenating shorter words from the same list.

# Execution Steps:
To run the program, follow these steps:

1. Ensure you have Java installed on your system.

2. Compile the Java source code using the following command in the terminal:
      javac CompoundedWords.java
   
3. Execute the program using the following command:
      java CompoundedWords
   
4. The program will prompt you to enter a list of words, one word per line, with no spaces. Press Enter for a new word, and when you're done, simply press Enter again.

5. The program will process the input and display the longest compounded word and the second longest compounded word.

# Design Decisions and Approach:

- The program uses a sorted list of words, sorted by their length, to optimize the search for compounded words.
- It employs a recursive approach to check if a word is compounded, taking into account the words already processed.
- The isCompounded function checks if a word can be compounded by splitting it into prefixes and suffixes and recursively searching for matching words.
- The findLongestCompoundedWord function starts from the longest words and moves towards shorter words, excluding the currently checked word from future searches.
- The findSecondLongestCompoundedWord function uses a similar approach but also checks for the second longest compounded word while excluding the longest one.
- This program provides an efficient way to identify the longest and second longest compounded words in a list of words.
