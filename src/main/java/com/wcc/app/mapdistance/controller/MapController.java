package com.wcc.app.mapdistance.controller;

import com.wcc.app.mapdistance.dto.MapResult;
import com.wcc.app.mapdistance.dto.PostcodeDetail;
import com.wcc.app.mapdistance.model.PostCodeLatLng;
import com.wcc.app.mapdistance.service.MapService;
import com.wcc.app.mapdistance.util.FormatUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/map")
public class MapController {

    Logger logger = LoggerFactory.getLogger(MapController.class);
    private final MapService service;
    private final ModelMapper modelMapper;

    @GetMapping("calc/{location}/{destination}")
    public ResponseEntity<?> getDistance(
            @PathVariable("location") String location,
            @PathVariable("destination") String destination) {

        PostCodeLatLng locationPostcode = service.getPostcode(location);
        PostCodeLatLng destinationPostcode = service.getPostcode(destination);

        String distance = FormatUtil.roundFormat(service.calculateDistance(locationPostcode, destinationPostcode));

        MapResult map = MapResult.builder()
                .location(modelMapper.map(locationPostcode, PostcodeDetail.class))
                .destination(modelMapper.map(destinationPostcode, PostcodeDetail.class))
                .distance(distance).build();

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updatePostcode(@RequestBody PostcodeDetail postcodeDetail) {
        PostCodeLatLng postCodeLatLng = modelMapper.map(postcodeDetail, PostCodeLatLng.class);
        if(service.updatePostcode(postCodeLatLng) < 1) {
            return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(postcodeDetail, HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<?> getAllPostcodes() {

        List<PostcodeDetail> postcodeDetails = service.getAll().stream()
                .map(p -> modelMapper.map(p, PostcodeDetail.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(postcodeDetails, HttpStatus.OK);
    }

    @GetMapping("/{postcode}")
    public ResponseEntity<?> getPostcode(
            @PathVariable("postcode") String postcode) {
        return new ResponseEntity<>(
                modelMapper.map(service.getPostcode(postcode), PostcodeDetail.class), HttpStatus.OK);
    }

    @GetMapping("/testapi")
    public ResponseEntity<?> testAPI() {
        logger.info("hit!");
        return new ResponseEntity<>("Completed", HttpStatus.OK);
    }

}