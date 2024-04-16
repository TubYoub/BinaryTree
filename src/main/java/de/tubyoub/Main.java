package de.tubyoub;

import de.tubyoub.morsecode.MorseTesting;

import java.lang.reflect.GenericDeclaration;

public class Main {
    private static MorseTesting morseTesting;

    public static void main(String[] args) {
        System.out.println("Hello world!");

        morseTesting = new MorseTesting();

        String morseCode = ".... . .-.. .-.. ---/.-- --- .-. .-.. -..";
        String decodedMessage = morseTesting.decodeMorseSentence(morseCode);
        String encodedMessage = morseTesting.encodeMorseSentence(decodedMessage);

        System.out.println("Decoded message: " + decodedMessage);
        System.out.println("Encoded message:" + encodedMessage);
    }
}