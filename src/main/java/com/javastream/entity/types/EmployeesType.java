package com.javastream.entity.types;

/**
 * EmployeesType.
 *
 * @author javastream
 */
public enum EmployeesType {
    LESS_THAN_50("EMPLOYEES_1"),
    FROM_50_TO_250("EMPLOYEES_2"),
    FROM_250_TO_500("EMPLOYEES_3"),
    OVER_500("EMPLOYEES_4");

    private String code;

    EmployeesType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}