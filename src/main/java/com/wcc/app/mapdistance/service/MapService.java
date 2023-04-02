package com.wcc.app.mapdistance.service;

import com.wcc.app.mapdistance.model.PostCodeLatLng;

public interface MapService {
    PostCodeLatLng getPostcode(String postcode);
    int updatePostcode(PostCodeLatLng postCodeLatLng);
    double calculateDistance(PostCodeLatLng locationPostCode, PostCodeLatLng destinationPostCode);

}
