package com.galdovich.task_5.service.impl;

import com.galdovich.task_5.service.TextEdit;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTextEditImpl implements TextEdit {
    private static final String VOWELS = "[АУОЫИЭЯЮЁЕауоыиэяюёеEYUIOAeyuioa]";
    private static final String WORD_CERTAIN_LENGTH = "\\b\\p{L}{%d}\\b";
    private static final String SYMBOL_CERTAIN_LENGTH = "\\b\\p{L}{%d}";
    private static final String SYMBOL_EXCEPT_WORD_SPACE = "\\p{P}";
    private static final String SPACE = " ";

    @Override
    public Optional<String> replaceCharInWord(String text, int index, char symbol) {
        if (text == null || index < 0) {
            return Optional.empty();
        }
        Pattern pattern = Pattern.compile(String.format(SYMBOL_CERTAIN_LENGTH, index));
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            int start = matcher.start() + index - 1;
            int end = start + 1;
            text = text.substring(0, start) + symbol + text.substring(end);
        }
        return Optional.of(text);
    }

    @Override
    public Optional<String> replaceLetterBeforeLetter(String text, String twoOldChar,
                                            String twoNewChar) {
        if (text == null) {
            return Optional.empty();
        }
        Pattern pattern = Pattern.compile(twoOldChar);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            text = text.substring(0, start) + twoNewChar + text.substring(end);
        }
        return Optional.of(text);
    }

    @Override
    public Optional<String> replaceWordsToSubstring(String text, int wordLength, String subLine) {
        if (text == null) {
            return Optional.empty();
        }
        Pattern pattern = Pattern.compile(String.format(WORD_CERTAIN_LENGTH, wordLength));
        Matcher matcher = pattern.matcher(text);
        return Optional.of(matcher.replaceAll(subLine));
    }

    @Override
    public Optional<String> deleteAllNotSpaceOrLetter(String text) {
        if (text == null) {
            return Optional.empty();
        }
        Pattern pattern = Pattern.compile(SYMBOL_EXCEPT_WORD_SPACE);
        Matcher matcher = pattern.matcher(text);
        return Optional.of(matcher.replaceAll(SPACE));
    }

    @Override
    public Optional<String> deleteConsonantWords(String text, int wordLength) {
        if (text == null) {
            return Optional.empty();
        }
        Pattern pattern = Pattern.compile(String.format(WORD_CERTAIN_LENGTH, wordLength));
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            if (!String.valueOf(matcher.group().charAt(0)).matches(VOWELS)) {
                int start = matcher.start();
                int end = matcher.end();
                text = text.substring(0, start) + "" + text.substring(end);
            }
        }
        return Optional.of(text);
    }
}
