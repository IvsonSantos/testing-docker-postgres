package com.example.demo.examples;

public abstract sealed class Celestial permits Planet, Star, Comet {
}

final class Planet extends Celestial {};
final class Star extends Celestial {};
final class Comet extends Celestial {};

