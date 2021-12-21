package com.sample.app.representation;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@Getter
@Setter
@Builder
public class SampleResponse {

    private int id;
    private String status;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
