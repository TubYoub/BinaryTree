package de.tubyoub.morsecode;

import de.tubyoub.lib.BinaryTree;

import java.util.Objects;

public class MorseEncoder {
    private BinaryTree<String> morseTree;

    public MorseEncoder(BinaryTree<String> morseTree) {
        this.morseTree = morseTree;
    }

    public String encode(String message) {
        StringBuilder encodedMessage = new StringBuilder();
        for (char character : message.toUpperCase().toCharArray()) {
            String morseCode = encodeCharacter(morseTree, character, "");
            if (morseCode != null) {
                encodedMessage.append(morseCode).append(" ");
            } else {
                encodedMessage.append("Character not found");
            }
        }
        return encodedMessage.toString().trim();
    }

    private String encodeCharacter(BinaryTree<String> tree, char character, String morseCode) {
        if (tree == null || tree.isEmpty()) {
            return null;
        }
        if (" ".equals(String.valueOf(character))){
            return "/";
        }
        if (tree.getContent().equals(String.valueOf(character))) {
            return morseCode;
        }
        String leftSearch = encodeCharacter(tree.getLeftTree(), character, morseCode + ".");
        if (leftSearch != null) {
            return leftSearch;
        }
        return encodeCharacter(tree.getRightTree(), character, morseCode + "-");
    }
}