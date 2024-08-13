package com.example.demo.record;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex {

    public static void main(String[] args) {
        List<City> cities = new ArrayList<>();

        cities.add(new City("city1", new State("state1")));
        cities.add(new City("city1", new State("state2")));
        cities.add(new City("city2", new State("state1")));
        cities.add(new City("city3", new State("state3")));

        // compute the state that has the greatest number of cities.
        Map<State, Long> numberOfCitiesPerState = cities.stream()
                .collect(Collectors.groupingBy(
                    City::state,
                    Collectors.counting()
                ));
        System.out.println(numberOfCitiesPerState);

        Map.Entry<State, Long> stateWithTheMostCities =
                numberOfCitiesPerState.entrySet().stream()
                        .max(Map.Entry.comparingByValue())
                        .orElseThrow();
        System.out.println(stateWithTheMostCities);
    }
}
