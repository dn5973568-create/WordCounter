package com.example.wordcounter;

public class WordCounter {

    public int countWords(String text) {
        if (text.trim().isEmpty()) {
            return 0;
        }

        return text.trim().split("[\\s,.]+").length;
    }

    public int countChars(String text) {
        return text.length();
    }

    public int countSentences(String text) {
        if (text.trim().isEmpty()) {
            return 0;
        }

        return text.trim().split("[.!?]+").length;
    }

    public int countNumbers(String text) {
        int count = 0;

        String[] parts = text.trim().split("[\\s,.!?]+");

        for (String part : parts) {
            if (part.matches("\\d+")) {
                count++;
            }
        }

        return count;
    }}