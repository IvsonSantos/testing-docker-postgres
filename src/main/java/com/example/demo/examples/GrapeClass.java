package com.example.demo.examples;

import java.awt.*;

public class GrapeClass {

    private Color color;
    private Integer num;

    public GrapeClass(Color color, Integer num) {
        this.color = color;
        this.num = num;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

}
