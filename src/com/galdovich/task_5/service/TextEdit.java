package com.galdovich.task_5.service;

import java.util.Optional;

public interface TextEdit {

    Optional<String> replaceCharInWord(String text, int index,
                             char symbol);

    Optional<String> replaceLetterBeforeLetter (String text, String target,
                                      String newSymbol);

    Optional<String> replaceWordsToSubstring(String text, int wordLength,
                                   String substring);

    Optional<String> deleteAllNotSpaceOrLetter(String text);

    Optional<String> deleteConsonantWords(String text, int wordLength);

}
