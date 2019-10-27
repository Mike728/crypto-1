package com.company;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AffineCipher {

    private CharsMap charsMap;

    public AffineCipher() {
        this.charsMap = new CharsMap();
    }

    public String encrypt(String text, AffineKey key) {
        return text.toLowerCase()
            .chars()
            .map(v -> {
                System.out.print("Encrypting " + (char) v + " as ");
                int a = key.getA();
                int b = key.getB();
                int x = charsMap.getCharsMap().get(String.valueOf((char) v)).intValue();
                return (x * a + b) % 26;
            })
            .boxed()
            .map(v -> {
                System.out.print(getCharByValue(v) + "\n");
                return getCharByValue(v);
            })
            .collect(Collectors.joining(""));
    }

    public String decrypt(String text, AffineKey key) {
        return text.toLowerCase()
            .chars()
            .map(v -> {
                System.out.print("Decrypting " + (char) v + " as ");
                EuclideanAlgorithm euclideanAlgorithm = new EuclideanAlgorithm(key.getA(), 26);
                int a = euclideanAlgorithm.licz();
                int b = key.getB();
                int y = charsMap.getCharsMap().get(String.valueOf((char) v)).intValue();
                return a * (y - b) % 26;
            })
            .boxed()
            .map(v -> {
                System.out.print(getCharByValue(v) + "\n");
                return getCharByValue(v);
            }).collect(Collectors.joining(""));
    }

    private String getCharByValue(Integer v) {
        return charsMap.getCharsMap()
            .entrySet()
            .stream()
            .filter(entry -> v.equals(entry.getValue()))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList())
            .stream()
            .findFirst()
            .get();
    }
}
