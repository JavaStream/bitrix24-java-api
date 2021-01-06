package com.javastream.entity.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Phone {
    private String ID;
    private String TYPE_ID;
    private String VALUE;
    private String VALUE_TYPE;
}
