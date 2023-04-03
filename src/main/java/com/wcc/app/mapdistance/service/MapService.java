package com.wcc.app.mapdistance.service;

import com.wcc.app.mapdistance.model.PostCodeLatLng;

import java.util.List;
import java.util.Map;

public interface MapService {
    PostCodeLatLng getPostcode(String postcode);
    List<PostCodeLatLng> getAll();
    int updatePostcode(PostCodeLatLng postCodeLatLng);
    double calculateDistance(PostCodeLatLng locationPostCode, PostCodeLatLng destinationPostCode);

}
