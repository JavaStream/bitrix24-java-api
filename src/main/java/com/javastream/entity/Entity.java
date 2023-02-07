package com.javastream.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
abstract public class Entity {
    @SerializedName("ID")
    protected Integer id;
}
