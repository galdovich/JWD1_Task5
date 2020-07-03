package com.galdovich.task_5.reader;

import com.galdovich.task_5.exception.CustomException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FileReaderTest {
    FileReader fileReader;
    String text = "A regular expression, specified as a string, must first be compiled into an instance of this class.";

    @BeforeTest
    public void setUp(){
        fileReader = new FileReader();
    }

    @Test
    public void testReadFromFile() {
        try{
            String actual = fileReader.readFromFile("resources\\text.txt");
            String expected = text;
            assertEquals(actual, expected);
        }catch (CustomException e){fail();}
    }

    @Test
    public void testReadFromDefaultFile() {
        try{
            String actual = fileReader.readFromFile("resources\\tester.txt");
            String expected = text;
            assertEquals(actual, expected);
        }catch (CustomException e){fail();}
    }

    @Test(expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "Reading problem")
    public void readNumbersFromFileNegativeTest() throws CustomException {
        fileReader.readFromFile("resources\\text.pdf");
    }
}