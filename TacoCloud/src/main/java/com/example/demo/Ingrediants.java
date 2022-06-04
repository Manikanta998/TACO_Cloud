package com.example.demo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Ingrediants {
    private  final String id;
    private final String name;
    private final Type type;
    public static enum Type{
        WRAP,PROTEIN,VEGGIES,CHESS, CHEESE, SAUCE
    }
}
