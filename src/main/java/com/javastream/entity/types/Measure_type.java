package com.javastream.entity.types;


public enum Measure_type {

    METER("1"), LITER("3"), GRAM("5"), KILOGRAM("7"), PIECE("9");


    private String code;

    Measure_type(String code){
        this.code = code;
    }

    public String getCode(){ return code;}

}
