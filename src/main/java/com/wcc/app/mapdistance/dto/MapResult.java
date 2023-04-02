package com.wcc.app.mapdistance.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MapResult {

    private static final String UNIT = " km";

    private PostcodeDetail location;
    private PostcodeDetail destination;
    private String distance;

    public String getDistance() {
        return distance + UNIT;
    }
}
