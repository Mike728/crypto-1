package com.company;

import java.io.StringWriter;

public class CaesarCipher {

    public String encrypt(String text, int key) {
       return text.chars()
            .map(ch -> ch + key)
            .collect(() -> new StringWriter(),
                (stringWriter, ch) -> stringWriter.write(ch),
                (swl, swr) -> swl.write(swr.toString()))
            .toString();
    }

    public String decrypt(String text, int key) {
        return text.chars()
            .map(ch -> ch - key)
            .collect(() -> new StringWriter(),
                (stringWriter, ch) -> stringWriter.write(ch),
                (swl, swr) -> swl.write(swr.toString()))
            .toString();
    }
}

