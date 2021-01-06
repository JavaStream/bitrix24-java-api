package com.javastream.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Chat {
    private String ID;
    private String TITLE;
    private String DESCRIPTION;
    private String COLOR;
    private String MESSAGE;
}
