package com.galdovich.task_5.reader;

import com.galdovich.task_5.exception.CustomException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReader {
    private static final String DEFAULT_FILE = "resources\\DefaultText.txt";

    public String readFromFile(String file) throws CustomException {
        String line = null;
        StringBuilder builder = new StringBuilder();
        Path path = Paths.get(file);
        if (Files.notExists(path)) {
            path = Paths.get(DEFAULT_FILE);
        }
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            return builder.toString();
        } catch (IOException e) {
            throw new CustomException("Reading problem");
        }
    }
}
