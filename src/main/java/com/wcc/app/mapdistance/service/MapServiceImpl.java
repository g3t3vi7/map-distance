package com.wcc.app.mapdistance.service;

import com.wcc.app.mapdistance.exception.PostCodeNotFound;
import com.wcc.app.mapdistance.function.MapDistance;
import com.wcc.app.mapdistance.model.PostCodeLatLng;
import com.wcc.app.mapdistance.repository.PostcodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MapServiceImpl implements MapService {

    private final PostcodeRepository postcodeRepository;

    /**
     * Calculate distance between 2 locations.
     *
     * @return distance in double value
     */
    @Override
    public double calculateDistance(PostCodeLatLng locationPostCode, PostCodeLatLng destinationPostCode) {
        return new MapDistance().calculateDistance(
                locationPostCode.getLatitude(),
                locationPostCode.getLongitude(),
                destinationPostCode.getLatitude(),
                destinationPostCode.getLongitude()
        );
    }

    /**
     * Retrieve postcode detail.
     *
     * @param postcode
     * @return Optional<PostCodeLatLng>
     */
    @Override
    public PostCodeLatLng getPostcode(String postcode) {
        return postcodeRepository.findByPostcode(postcode)
                .orElseThrow(() -> new PostCodeNotFound("Postcode not found"));
    }

    /**
     * @param postCodeLatLng
     * @return
     */
    @Override
    public int updatePostcode(PostCodeLatLng postCodeLatLng) {
        return postcodeRepository.updatePostcode(postCodeLatLng);
    }

}
