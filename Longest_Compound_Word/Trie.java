import java.util.List;
public class Trie {
    static class Node {
        Node[] children;
        boolean eow;

        public Node() {
            children = new Node[26]; // as there are 26 alphabets
            for(int i=0;i<26;i++) {
                children[i] = null;
            }
            eow = false;
        }
    }

    static Node root = new Node();

    //insertion of words
    public void insert(String word) {
        Node curr = root;
        for(int i=0;i<word.length();i++) {
            int idx = word.charAt(i) - 'a';

            if(curr.children[idx] == null) {
                //new node will be added
                curr.children[idx] = new Node();
            }

            if(i == (word.length() - 1)) {
                curr.children[idx].eow = true;
            }

            curr = curr.children[idx];
        }
    }

    //searching of words
    public boolean search(String key) {
        Node curr = root;
        for(int i=0;i<key.length();i++) {
            int idx = key.charAt(i) - 'a';

            if(curr.children[idx] == null) {
                return false;
            }

            if(i == (key.length() - 1) && curr.children[idx].eow == false) {
                return false;
            }

            curr = curr.children[idx];
        }
        return true;
    }
    //break each word in the dictionary
    public boolean wordsBreak(String wordToSearch, int count){

        if(wordToSearch.length() == 0 && count > 1){
            return true;
        }

        for(int i = 1; i <= wordToSearch.length(); i++){
            String first = wordToSearch.substring(0, i);
            String second = wordToSearch.substring(i);

            if(search(first) && wordsBreak(second, count + 1)){
                return true;
            }
        }

        return false;
    }
    // function to find longest and second longest words from the dictionary
    public String[] findLongestCompoundWords(List<String> dictionary) {
        String longestWord = "";
        String secondLongestWord = "";

        for (String word : dictionary) {
            if(wordsBreak(word, 0)) {
                if (word.length() > longestWord.length()) {
                    secondLongestWord = longestWord;
                    longestWord = word;
                } else if (word.length() > secondLongestWord.length() && !word.equals(longestWord)) {
                    secondLongestWord = word;
                }
            }
        }

        return new String[]{longestWord, secondLongestWord};
    }

    // public String getLongestCompoundWord() {
    //     String longestWord = "";
    //     String curr = "";

    //     for(int i=0;i<26;i++) {
    //         if(root.children[i] != null) {
    //             char c = (char) ('a' + i);
    //             curr = findLongestCompoundWord(root.children[i], String.valueOf(c));
    //             if(curr.length() > longestWord.length()) {
    //                 longestWord = curr;
    //             }
    //         }
    //     }

    //     return longestWord;
    // }

    // public String findLongestCompoundWord(Node node, String curr) {
    //     String longest = curr;
        
    //     if(node.eow) { 
    //         curr = "";
    //     }

    //     for(int i=0;i<26;i++) {
    //         if(node.children[i] != null) {
    //             char c = (char) ('a' + i);
    //             String newWord = curr + c;
    //             String next = findLongestCompoundWord(node.children[i], newWord);
    //             if(next.length() > longest.length()) {
    //                 longest = next;
    //             }
    //         }
    //     }

    //     return longest;
    // }

    // public String getSecondLongestCompoundWord() {
    //     String longestWord = getLongestCompoundWord();

    //     String secondLongestWord = "";

    //     for (int i = 0; i < 26; i++) {
    //         if (root.children[i] != null) {
    //             char c = (char) ('a' + i);
    //             String curr = findLongestCompoundWord(root.children[i], String.valueOf(c));
    //             if (curr.length() > secondLongestWord.length() && !curr.equals(longestWord)) {
    //                 secondLongestWord = curr;
    //             }
    //         }
    //     }

    //     return secondLongestWord;
    // }
}