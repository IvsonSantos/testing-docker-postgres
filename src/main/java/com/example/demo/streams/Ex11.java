package com.example.demo.streams;

import java.util.Arrays;
import java.util.List;

public class Ex11 {

    public static void main(String[] args) {

        List<State> states = Arrays.asList(
                State.builder().name("Olinda").cities(Arrays.asList(City.builder().name("Olinda").population(200000).build())).build(),
                State.builder().name("Recife").cities(Arrays.asList(City.builder().name("Recife").population(200000).build())).build(),
                State.builder().name("Minas").cities(Arrays.asList(City.builder().name("Teste").population(10000).build())).build(),
                State.builder().name("Paraiba").cities(Arrays.asList(City.builder().name("Bruxelas").population(10000).build())).build()
        );

        int totalPopulation = 0;
        for (State state : states) {
            for (City city : state.getCities()) {
                //totalPopulation += city.getPopulation();
                totalPopulation += state.getCities().stream().mapToInt(City::getPopulation).sum();
            }
        }
        System.out.println("Total population = " + totalPopulation);


        // better way
        int totalPopulation2 = states.stream()
                .flatMap(state -> state.getCities().stream())
                .mapToInt(City::getPopulation)
                .sum();
        System.out.println("Total population = " + totalPopulation2);
    }
}
