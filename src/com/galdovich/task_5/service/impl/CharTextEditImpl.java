package com.galdovich.task_5.service.impl;

import com.galdovich.task_5.service.TextEdit;
import java.util.Optional;

public class CharTextEditImpl implements TextEdit{
    private static final String VOWELS = "АУОЫИЭЯЮЁЕауоыиэяюёеEYUIOAeyuioa";
    private static final String NUMBER_LETTERS = "[\\p{L}]{%d}";
    private static final int ASCII_SPACE_DEC = 32;
    private static final String BOUNDARY = "\\b";
    private static final String SPACE = " ";

    @Override
    public Optional<String> replaceCharInWord(String text, int index, char symbol){
        if (text == null || index < 0) {
            return Optional.empty();
        }
        char[] symbolArray = text.toCharArray();
        int length = symbolArray.length;
        int count = 0;
        for (int i = 0; i < length; i++){
            count++;
            if (symbolArray[i] == ASCII_SPACE_DEC || count == index){
                while (symbolArray[i] == 32){
                    i++;
                    count = 1;
                }
                if (count == index){
                    symbolArray[i] = symbol;
                    while (symbolArray[i] == ASCII_SPACE_DEC){
                        i++;
                        count = 0;
                    }
                }
            }
        }
        return Optional.of(new String(symbolArray));
    }

    @Override
    public Optional<String> replaceLetterBeforeLetter(String text, String twoOldChar,
                                            String twoNewChar){
        if (text == null) {
            return Optional.empty();
        }
        char[] charsArray = text.toCharArray();
        for (int i = 0; i < charsArray.length - 1; i++){
            if (charsArray[i] == twoOldChar.charAt(0) &&
            charsArray[i+1] == twoOldChar.charAt(1)){
                charsArray[i+1] = twoNewChar.charAt(1);
            }
        }
        return Optional.of(new String(charsArray));
    }

    @Override
    public Optional<String> replaceWordsToSubstring(String text, int wordLength, String substring) {
        if (text == null) {
            return Optional.empty();
        }
        String[] words = text.split(BOUNDARY);
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            char[] wordChars = word.toCharArray();
            if (wordChars.length != wordLength) {
                stringBuilder.append(wordChars);
            } else {
                if (!word.matches(String.format(NUMBER_LETTERS, wordLength))) {
                    stringBuilder.append(wordChars);
                } else {
                    stringBuilder.append(substring);
                }
            }
        }

        return Optional.of(stringBuilder.toString());
    }

    @Override
    public Optional<String> deleteAllNotSpaceOrLetter(String text) {
        if (text == null) {
            return Optional.empty();
        }
        char[] chars = text.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetterOrDigit(chars[i]) || Character.isWhitespace(chars[i])) {
                stringBuilder.append(chars[i]);
            } else {
                stringBuilder.append(" ");
            }
        }
        return Optional.of(stringBuilder.toString());
    }

    @Override
    public Optional<String> deleteConsonantWords(String text, int wordLength){
        if (text == null) {
            return Optional.empty();
        }
        String[] words = text.split(BOUNDARY);
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            char[] wordChars = word.toCharArray();
            if (wordChars.length != wordLength) {
                stringBuilder.append(wordChars);
            } else {
                if (!word.matches(String.format(NUMBER_LETTERS, wordLength))) {
                    stringBuilder.append(wordChars);
                } else {
                    if (VOWELS.contains(String.valueOf(wordChars[0]))) {
                        stringBuilder.append(wordChars);
                    }
                }
            }
        }
        return Optional.of(stringBuilder.toString());
    }
}
