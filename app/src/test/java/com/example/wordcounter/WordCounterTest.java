
package com.example.wordcounter;

import org.junit.Test;
import static org.junit.Assert.*;

public class WordCounterTest {

    private final WordCounter wordCounter = new WordCounter();

    @Test
    public void COUNT_WORDS_CORRECTLY() {
        assertEquals(3, wordCounter.countWords("Hello, world. Android"));
    }

    @Test
    public void COUNT_WORDS_EMPTY_TEXT() {
        assertEquals(0, wordCounter.countWords(""));
    }

    @Test
    public void COUNT_CHARS_CORRECTLY()  {
        assertEquals(5, wordCounter.countChars("Hello"));
    }

    @Test
    public void COUNT_SENTENCES_CORRECTLY() {
        assertEquals(3, wordCounter.countSentences("Hello! How are you? Fine."));
    }

    @Test
    public void COUNT_NUMBERS_CORRECTLY() {
        assertEquals(2, wordCounter.countNumbers("I have 2 cats and 15 dogs."));
    }
}
