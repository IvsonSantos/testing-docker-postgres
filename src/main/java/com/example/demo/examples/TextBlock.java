package com.example.demo.examples;

public class TextBlock {

    private static void jsonBlock() {
        String text = """
            {
              "name": "John Doe",
              "age": 45,
              "address": "Doe Street, 23, Java Town"
            }
          """;
        System.out.println(text);
    }

    public static void main(String[] args) {
        jsonBlock();
    }
}
