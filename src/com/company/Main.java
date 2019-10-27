package com.company;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        CaesarCipher caesarCipher = new CaesarCipher();
        DataLoader dataLoader = new DataLoader();
        AffineCipher affineCipher = new AffineCipher();

        List<Integer> keys = loadKeys(dataLoader);

        Integer caesarKey = keys.get(0);
        Integer affineA = keys.get(1);
        Integer affineB = keys.get(2);

        List<String> loadedPlainText = dataLoader.loadPlainText();
        List<String> encryptedText = dataLoader.loadEncryptedText();

        Function<String, String> caesarCipherEncrypt = text -> caesarCipher.encrypt(text, caesarKey);
        Function<String, String> caesarCipherDecrypt = text -> caesarCipher.decrypt(text, caesarKey);
        Function<String, String> affineEncrypt = text -> affineCipher.encrypt(text, new AffineKey(affineA, affineB));
        Function<String, String> affineDecrypt = text -> affineCipher.decrypt(text, new AffineKey(affineA, affineB));

        encryptedText.stream()
            .map(affineDecrypt)
            .forEach(v -> {
                try {
                    Files.write(Paths.get("decrypt.txt"), v.getBytes());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
    }

    private static List<Integer> loadKeys(DataLoader dataLoader) {
        return dataLoader.loadKey()
            .stream()
            .map(v -> v.split(" "))
            .flatMap(v -> Arrays.asList(v).stream())
            .map(v -> new Integer(v))
            .collect(Collectors.toList());
    }
}
