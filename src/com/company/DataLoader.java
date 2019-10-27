package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DataLoader {

    public List<String> loadPlainText() {
        try {
            return Files.readAllLines(Paths.get("plain.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

    public List<String> loadEncryptedText() {
        try {
            return Files.readAllLines(Paths.get("crypto.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

    public List<String> loadKey() {
        try {
            return Files.readAllLines(Paths.get("key.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }
}
