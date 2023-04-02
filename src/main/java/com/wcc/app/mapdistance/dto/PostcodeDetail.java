package com.wcc.app.mapdistance.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostcodeDetail {
    private String postcode;
    private String longitude;
    private String latitude;
}
