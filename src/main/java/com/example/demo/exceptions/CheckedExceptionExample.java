package com.example.demo.exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * checked exceptions represent errors outside the control of the program.
 * For example, the constructor of FileInputStream throws FileNotFoundException if the input file does not exist.
 * Java verifies checked exceptions at compile-time.
 */
public class CheckedExceptionExample {

    /**
     * Some common checked exceptions in Java are IOException, SQLException and ParseException.
     */
    private static void checkedExceptionWithThrows() throws IOException {
        File file = new File("not_existing_file.txt");

        try (FileInputStream stream = new FileInputStream(file)) {
            stream.close();
        }
    }

}
