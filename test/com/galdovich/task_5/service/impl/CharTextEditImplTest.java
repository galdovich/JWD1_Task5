package com.galdovich.task_5.service.impl;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.Optional;

import static org.testng.Assert.*;

public class CharTextEditImplTest {
    CharTextEditImpl charTextEdit;
    String text = "A regular expression, specified as a string, must first be " +
            "compiled into an instance of this class.";

    @BeforeClass
    public void setUp() {
        charTextEdit = new CharTextEditImpl();
    }

    @Test
    public void testReplaceCharInWordPositive() {
        Optional<String> actual = charTextEdit.replaceCharInWord(text, 3, '^');
        Optional<String> expected = Optional.of("A re^ular ex^ression, sp^cified as a st^ing," +
                " mu^t fi^st be co^piled in^o an in^tance of th^s cl^ss.");
        assertEquals(actual, expected);
    }

    @Test
    public void testReplaceCharInWordNegative() {
        Optional<String> actual = charTextEdit.replaceCharInWord(null, 3, '^');
        Optional<String> expected = Optional.empty();
        assertEquals(actual, expected);
    }

    @Test
    public void testReplaceLetterBeforeLetterPositive() {
        Optional<String> actual = charTextEdit.replaceLetterBeforeLetter(text, "n,", "ns");
        Optional<String> expected = Optional.of("A regular expressions specified as a string, must first be " +
                "compiled into an instance of this class.");
        assertEquals(actual, expected);
    }

    @Test
    public void testReplaceLetterBeforeLetterNegative() {
        Optional<String> actual = charTextEdit.replaceLetterBeforeLetter(null, "n,", "ns");
        Optional<String> expected = Optional.empty();
        assertEquals(actual, expected);
    }

    @Test
    public void testReplaceWordsToSubstringPositive() {
        Optional<String> actual = charTextEdit.replaceWordsToSubstring(text, 5, "CHANGE");
        Optional<String> expected = Optional.of("A regular expression, specified as a string, must CHANGE be " +
                "compiled into an instance of this CHANGE.");
        assertEquals(actual, expected);
    }

    @Test
    public void testReplaceWordsToSubstringNegative() {
        Optional<String> actual = charTextEdit.replaceWordsToSubstring(null, 5, "CHANGE");
        Optional<String> expected = Optional.empty();
        assertEquals(actual, expected);
    }

    @Test
    public void testDeleteAllNotSpaceOrLetterPositive() {
        Optional<String> actual = charTextEdit.deleteAllNotSpaceOrLetter(text);
        Optional<String> expected = Optional.of("A regular expression  specified as a string  must first be " +
                "compiled into an instance of this class ");
        assertEquals(actual, expected);
    }

    @Test
    public void testDeleteAllNotSpaceOrLetterNegative() {
        Optional<String> actual = charTextEdit.deleteAllNotSpaceOrLetter(null);
        Optional<String> expected = Optional.empty();
        assertEquals(actual, expected);
    }

    @Test
    public void testDeleteConsonantWordsPositive() {
        Optional<String> actual = charTextEdit.deleteConsonantWords(text, 2);
        Optional<String> expected = Optional.of("A regular expression, specified as a string, must first  " +
                "compiled into an instance of this class.");
        assertEquals(actual, expected);
    }

    @Test
    public void testDeleteConsonantWordsNegative() {
        Optional<String> actual = charTextEdit.deleteConsonantWords(null, 3);
        Optional<String> expected = Optional.empty();
        assertEquals(actual, expected);
    }
}