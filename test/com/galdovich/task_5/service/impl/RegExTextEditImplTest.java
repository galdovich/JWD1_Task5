package com.galdovich.task_5.service.impl;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Optional;

import static org.testng.Assert.*;

public class RegExTextEditImplTest {
    RegExTextEditImpl regExTextEdit;
    String text = "A regular expression, specified as a string, must first be " +
            "compiled into an instance of this class.";

    @BeforeMethod
    public void setUp() {
        regExTextEdit = new RegExTextEditImpl();
    }

    @Test
    public void testReplaceCharInWordPositive() {
        Optional<String> actual = regExTextEdit.replaceCharInWord(text, 3, '^');
        Optional<String> expected = Optional.of("A re^ular ex^ression, sp^cified as a st^ing," +
                " mu^t fi^st be co^piled in^o an in^tance of th^s cl^ss.");
        assertEquals(actual, expected);
    }

    @Test
    public void testReplaceCharInWordNegative() {
        Optional<String> actual = regExTextEdit.replaceCharInWord(null, 3, '^');
        Optional<String> expected = Optional.empty();
        assertEquals(actual, expected);
    }

    @Test
    public void testReplaceLetterBeforeLetterPositive() {
        Optional<String> actual = regExTextEdit.replaceLetterBeforeLetter(text, "n,", "ns");
        Optional<String> expected = Optional.of("A regular expressions specified as a string, must first be " +
                "compiled into an instance of this class.");
        assertEquals(actual, expected);
    }

    @Test
    public void testReplaceLetterBeforeLetterNegative() {
        Optional<String> actual = regExTextEdit.replaceLetterBeforeLetter(null, "n,", "ns");
        Optional<String> expected = Optional.empty();
        assertEquals(actual, expected);
    }

    @Test
    public void testReplaceWordsToSubstringPositive() {
        Optional<String> actual = regExTextEdit.replaceWordsToSubstring(text, 5, "CHANGE");
        Optional<String> expected = Optional.of("A regular expression, specified as a string, must CHANGE be " +
                "compiled into an instance of this CHANGE.");
        assertEquals(actual, expected);
    }

    @Test
    public void testReplaceWordsToSubstringNegative() {
        Optional<String> actual = regExTextEdit.replaceWordsToSubstring(null, 5, "CHANGE");
        Optional<String> expected = Optional.empty();
        assertEquals(actual, expected);
    }

    @Test
    public void testDeleteAllNotSpaceOrLetterPositive() {
        Optional<String> actual = regExTextEdit.deleteAllNotSpaceOrLetter(text);
        Optional<String> expected = Optional.of("A regular expression  specified as a string  must first be " +
                "compiled into an instance of this class ");
        assertEquals(actual, expected);
    }

    @Test
    public void testDeleteAllNotSpaceOrLetterNegative() {
        Optional<String> actual = regExTextEdit.deleteAllNotSpaceOrLetter(null);
        Optional<String> expected = Optional.empty();
        assertEquals(actual, expected);
    }

    @Test
    public void testDeleteConsonantWordsPositive() {
        Optional<String> actual = regExTextEdit.deleteConsonantWords(text, 2);
        Optional<String> expected = Optional.of("A regular expression, specified as a string, must first  " +
                "compiled into an instance of this class.");
        assertEquals(actual, expected);
    }

    @Test
    public void testDeleteConsonantWordsNegative() {
        Optional<String> actual = regExTextEdit.deleteConsonantWords(null, 3);
        Optional<String> expected = Optional.empty();
        assertEquals(actual, expected);
    }
}