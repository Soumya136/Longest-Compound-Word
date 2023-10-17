# Longest Compound Word using Trie data structure

This Java code implements a Trie data structure along with functions for inserting words, searching for words, and breaking down words into their constituent parts. It also includes a function to find the longest and second longest compound words from a given list of words.

## Files

- **Trie.java**: Contains the implementation of the Trie data structure and related functions.
- **LongestCompoundWord.java**: Provides an example of how to use the Trie and find the longest and second longest compound words from a list of words(dictionary).

## Usage

- **Inserting Words**: Use the `insert(String word)` method to add words to the Trie.
- **Searching for Words**: Use the `search(String key)` method to check if a word is present in the Trie.
- **Breaking Down Words**: The `wordsBreak(String wordToSearch, int count)` function checks if a given word can be broken down into constituent words from the Trie.
- **Finding Longest and Second Longest Compound Words:**: Use the `findLongestCompoundWords(List<String> dictionary)` function by passing a list of words. It will return an array with the longest and second longest compound words.

## Note

- Ensure that the Trie.java file is included in the same directory as Main.java for the code to run successfully.
- This code assumes that the words are in lowercase and that the dictionary contains only valid English words.
