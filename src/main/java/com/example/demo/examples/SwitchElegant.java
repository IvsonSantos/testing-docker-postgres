package com.example.demo.examples;

public class SwitchElegant {

    static void TestTriangle(Shape s)  {
        /*
        switch (s) {
            case null:
                break;
            //case Triangle t:
            //    if (t.area() > 100) {
            //        System.out.println("large");
            //    }
            default:
                System.out.println("normal triangle");
        }

         */
    }

    // java 21
    static void TestTriangle2(Shape s) {
        /*
        switch (s) {
            //case Triangle t && (t.area() > 100) -> System.out.println("large");
            //case Triangle t -> System.out.println("normal");
            default -> System.out.println("non triangle");
        }

         */
    }
}

class Shape{}
class Rectangle extends Shape{}
class Triangle extends Shape{
    int area() {
        return 10;
    }
}