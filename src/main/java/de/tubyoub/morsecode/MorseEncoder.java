package de.tubyoub.morsecode;

import de.tubyoub.lib.BinaryTree;

public class MorseEncoder {
    private BinaryTree<String> morseCodeTree;

    public MorseEncoder(BinaryTree<String> morseCodeTree){
        this.morseCodeTree = morseCodeTree;
    }

   public String encodeCharacter(char character, BinaryTree<String> currentNode) {
        if (currentNode == null || currentNode.getContent() == null)
            return "";

        if (character == ' ') {
            return "/";
        } else if (character == currentNode.getContent().charAt(0)) {
            return "";
        } else {
            String leftEncoding = encodeCharacter(character, currentNode.getLeftTree());
            if (!leftEncoding.equals("")) {
                return "." + leftEncoding;
            }

            String rightEncoding = encodeCharacter(character, currentNode.getRightTree());
            if (!rightEncoding.equals("")) {
                return "-" + rightEncoding;
            }
        }

        return "";
    }

    public String encodeWord(String word) {
        StringBuilder encodedWord = new StringBuilder();
        for (char c : word.toUpperCase().toCharArray()) {
            String encoding = encodeCharacter(c, morseCodeTree);
            if (!encoding.equals("")) {
                encodedWord.append(encoding).append(" ");
            }
        }
        return encodedWord.toString().trim();
    }

    public String encodeSentence(String sentence) {
        String[] words = sentence.split("\\s+");
        StringBuilder encodedSentence = new StringBuilder();
        for (String word : words) {
            encodedSentence.append(encodeWord(word)).append(" / ");
        }
        return encodedSentence.toString().trim();
    }
}
