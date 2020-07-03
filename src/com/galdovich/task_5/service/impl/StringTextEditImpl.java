package com.galdovich.task_5.service.impl;

import com.galdovich.task_5.service.TextEdit;
import java.util.Optional;

public class StringTextEditImpl implements TextEdit{
    private static final String VOWELS = "[АУОЫИЭЯЮЁЕауоыиэяюёеEYUIOAeyuioa]";
    private static final String PUNCTUATION = "\\W";
    private static final String STRING_SPACE = " ";
    private static final char CHAR_SPACE = ' ';
    private static final String WORDS = "\\b";

    @Override
    public Optional<String> replaceCharInWord(String text, int index, char symbol) {
        if (text == null || index < 0) {
            return Optional.empty();
        }
        String[] wordsArray = text.split(STRING_SPACE);
        text = "";
        for (String word: wordsArray){
            StringBuilder stringBuilder = new StringBuilder(word);
            if (word.length() >= index){
                stringBuilder.setCharAt(index - 1, symbol);
            }
            text = text.concat(stringBuilder.toString().concat(STRING_SPACE));
        }
        return Optional.of(text.trim());
    }

    /**
     * The method changes a two specific character on a two given character.
     *
     * @param text Input text
     * @param twoOldChar Two changeable characters
     * @param twoNewChar Two new character that change 'twoOldChar'
     */
    @Override
    public Optional<String> replaceLetterBeforeLetter(String text,
                                                   String twoOldChar,
                                                   String twoNewChar) {
        if (text == null) {
            return Optional.empty();
        }
        StringBuilder stringBuilder = new StringBuilder(text);
        for (int i = 0; i < stringBuilder.length() - 1; i++){
            if(stringBuilder.charAt(i) == twoOldChar.charAt(0)
                    && stringBuilder.charAt(i+1) == twoOldChar.charAt(1)){
                stringBuilder.setCharAt(i+1, twoNewChar.charAt(1));
            }
        }
        text = stringBuilder.toString();
        return Optional.of(text);
    }

    @Override
    public Optional<String> replaceWordsToSubstring(String text, int length, String substring) {
        if (text == null) {
            return Optional.empty();
        }
        StringBuilder builder = new StringBuilder();
        String[] words = text.split(WORDS);
        for (String word : words) {
            if (word.length() == length) {
                builder.append(substring);
            } else {
                builder.append(word);
            }
        }
        return Optional.of(builder.toString());
    }

    @Override
    public Optional<String> deleteAllNotSpaceOrLetter(String text) {
        if (text == null) {
            return Optional.empty();
        }
        StringBuilder stringBuilder = new StringBuilder(text);
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (!Character.isLetter(stringBuilder.charAt(i))) {
                stringBuilder.setCharAt(i, CHAR_SPACE);
            }
        }
        text = stringBuilder.toString();
        return Optional.of(text);
    }

    @Override
    public Optional<String> deleteConsonantWords(String text, int wordLength) {
        if (text == null) {
            return Optional.empty();
        }
        StringBuilder builder = new StringBuilder();
        String[] words = text.split(WORDS);
        for (String word : words) {
            if (word.length() == wordLength) {
                if (String.valueOf(word.charAt(0)).matches(VOWELS) ||
                String.valueOf(word.charAt(0)).matches(PUNCTUATION)) {
                    builder.append(word);
                }
            } else {
                builder.append(word);
            }
        }
        return Optional.of(builder.toString());
    }
}
