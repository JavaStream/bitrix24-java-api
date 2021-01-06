package com.javastream.entity;

import lombok.Data;
import lombok.ToString;

/*  Created by JavaStream   */

@Data
@ToString
public class ProductSection {
    private Integer ID;
    private Integer CATALOG_ID;
    private Integer SECTION_ID;
    private String NAME;
    private String XML_ID;

    public void add_name(String name) {
        this.NAME = name;
    }
}
