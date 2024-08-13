package com.example.demo.streams;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex10 {

    public static void main(String[] args) {
        List<City> cities = Arrays.asList(
                City.builder().name("Olinda").population(200000).build(),
                City.builder().name("Recife").population(200000).build(),
                City.builder().name("Minas").population(10000).build(),
                City.builder().name("Paraiba").population(10000).build()
        );

        // old way
        int sum = 0;
        for (City city : cities) {
            int population = city.getPopulation();
            if (population > 100_000) {
                sum += population;
            }
        }

        System.out.println("Sum = " + sum);

        // better way
        Stream<City> streamOfCities = cities.stream();
        Stream<Integer> populations = streamOfCities.map(City::getPopulation);
        Stream<Integer> filteredPopulations = populations.filter(population -> population > 100_000);

    }
}
