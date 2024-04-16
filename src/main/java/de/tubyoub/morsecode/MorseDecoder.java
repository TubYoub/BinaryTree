package de.tubyoub.morsecode;

import de.tubyoub.lib.BinaryTree;

public class MorseDecoder {
    private BinaryTree<String> morseCodeTree;

    public MorseDecoder(BinaryTree<String> morseCodeTree){
        this.morseCodeTree = morseCodeTree;
    }

    public String decodeMorseWord(String morseCode, BinaryTree<String> currentNode) {
        if (morseCode.isEmpty()) {
            return currentNode.getContent();
        }

        char symbol = morseCode.charAt(0);
        String restMorseCode = morseCode.substring(1);

        if (symbol == '.') {
            return decodeMorseWord(restMorseCode, currentNode.getLeftTree());
        } else if (symbol == '-') {
            return decodeMorseWord(restMorseCode, currentNode.getRightTree());
        } else if (symbol == ' ') {
            return currentNode.getContent() + decodeMorseWord(restMorseCode, morseCodeTree);
        }

        return "Invalid Morse code.";
    }

    public String decodeMorseSentence(String morseCode) {
        String[] words = morseCode.split("/");
        StringBuilder decodedSentence = new StringBuilder();

        for (String word : words) {
            String decodedWord = decodeMorseWord(word, morseCodeTree);
            decodedSentence.append(decodedWord).append(" ");
        }

        return decodedSentence.toString().trim();
    }
}