package com.wcc.app.mapdistance.repository;

import com.wcc.app.mapdistance.model.PostCodeLatLng;

public interface PostcodeRepositoryCustom {
    int updatePostcode(PostCodeLatLng postCodeLatLng);
}