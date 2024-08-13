package com.example.demo.streams;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class State {

    private String name;
    private List<City> cities;

}
