package com.javastream.entity.types;

/**
 * MeasureType.
 *
 * @author javastream
 */
public enum MeasureType {
    METER("1"),
    LITER("3"),
    GRAM("5"),
    KILOGRAM("7"),
    PIECE("9");

    private String code;

    MeasureType(String code){
        this.code = code;
    }

    public String getCode(){ return code;}
}