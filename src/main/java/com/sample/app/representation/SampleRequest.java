package com.sample.app.representation;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@Getter
@Setter
public class SampleRequest {

    private int id;
    private String name;
    private String status;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
