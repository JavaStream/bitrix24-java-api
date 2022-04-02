package com.javastream.entity.model.chat;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * User.
 *
 * @author javastream
 */
@Data
@ToString
@Builder
public class User {
    private Integer id;
}
