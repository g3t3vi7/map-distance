package com.wcc.app.mapdistance.repository;

import com.wcc.app.mapdistance.model.PostCodeLatLng;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostcodeRepository extends JpaRepository<PostCodeLatLng, Integer>, PostcodeRepositoryCustom {
    Optional<PostCodeLatLng> findByPostcode(String postcode);

}