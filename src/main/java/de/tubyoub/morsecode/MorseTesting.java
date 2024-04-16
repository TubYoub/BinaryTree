package de.tubyoub.morsecode;

import de.tubyoub.lib.BinaryTree;

public class MorseTesting {
    private MorseDecoder morseDecoder;
    private MorseEncoder morseEncoder;
    private BinaryTree<String> morseCodeTree;
    public MorseTesting(){
        morseCodeTree = new BinaryTree<>(" ");

        morseCodeTree.setLeftTree(new BinaryTree<>("E"));
        morseCodeTree.setRightTree(new BinaryTree<>("T"));


        morseCodeTree.getLeftTree().setLeftTree(new BinaryTree<>("I"));
        morseCodeTree.getLeftTree().setRightTree(new BinaryTree<>("A"));

        morseCodeTree.getRightTree().setLeftTree(new BinaryTree<>("N"));
        morseCodeTree.getRightTree().setRightTree(new BinaryTree<>("M"));


        morseCodeTree.getLeftTree().getLeftTree().setLeftTree(new BinaryTree<>("S"));
        morseCodeTree.getLeftTree().getLeftTree().setRightTree(new BinaryTree<>("U"));

        morseCodeTree.getLeftTree().getRightTree().setLeftTree(new BinaryTree<>("R"));
        morseCodeTree.getLeftTree().getRightTree().setRightTree(new BinaryTree<>("W"));

        morseCodeTree.getRightTree().getLeftTree().setLeftTree(new BinaryTree<>("D"));
        morseCodeTree.getRightTree().getLeftTree().setRightTree(new BinaryTree<>("K"));

        morseCodeTree.getRightTree().getRightTree().setLeftTree(new BinaryTree<>("G"));
        morseCodeTree.getRightTree().getRightTree().setRightTree(new BinaryTree<>("O"));


        morseCodeTree.getLeftTree().getLeftTree().getLeftTree().setLeftTree(new BinaryTree<>("H"));
        morseCodeTree.getLeftTree().getLeftTree().getLeftTree().setRightTree(new BinaryTree<>("V"));

        morseCodeTree.getLeftTree().getLeftTree().getRightTree().setLeftTree(new BinaryTree<>("F"));
        morseCodeTree.getLeftTree().getLeftTree().getRightTree().setRightTree(new BinaryTree<>("Ü"));

        morseCodeTree.getLeftTree().getRightTree().getLeftTree().setLeftTree(new BinaryTree<>("L"));
        morseCodeTree.getLeftTree().getRightTree().getLeftTree().setRightTree(new BinaryTree<>("Ä"));

        morseCodeTree.getLeftTree().getRightTree().getRightTree().setLeftTree(new BinaryTree<>("P"));
        morseCodeTree.getLeftTree().getRightTree().getRightTree().setRightTree(new BinaryTree<>("J"));

        morseCodeTree.getRightTree().getLeftTree().getLeftTree().setLeftTree(new BinaryTree<>("B"));
        morseCodeTree.getRightTree().getLeftTree().getLeftTree().setRightTree(new BinaryTree<>("X"));

        morseCodeTree.getRightTree().getLeftTree().getRightTree().setLeftTree(new BinaryTree<>("C"));
        morseCodeTree.getRightTree().getLeftTree().getRightTree().setRightTree(new BinaryTree<>("Y"));

        morseCodeTree.getRightTree().getRightTree().getLeftTree().setLeftTree(new BinaryTree<>("Z"));
        morseCodeTree.getRightTree().getRightTree().getLeftTree().setRightTree(new BinaryTree<>("Q"));

        morseCodeTree.getRightTree().getRightTree().getRightTree().setLeftTree(new BinaryTree<>("Ö"));
        morseCodeTree.getRightTree().getRightTree().getRightTree().setRightTree(new BinaryTree<>("CH"));

        morseDecoder = new MorseDecoder(morseCodeTree);
        morseEncoder = new MorseEncoder(morseCodeTree);
    }

    public String decodeMorseSentence(String morseCode) {
        return morseDecoder.decodeMorseSentence(morseCode);
    }
    public String encodeMorseSentence(String text){
        return morseEncoder.encodeSentence(text);
    }
}
