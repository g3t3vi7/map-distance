package com.wcc.app.mapdistance.controller;

import com.wcc.app.mapdistance.dto.PostcodeDetail;
import com.wcc.app.mapdistance.model.PostCodeLatLng;
import com.wcc.app.mapdistance.service.MapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


public class TestMapController {

  private MapController controller;
  private MapService mapService = Mockito.mock(MapService.class);
  private ModelMapper modelMapper = Mockito.spy(ModelMapper.class);

  @BeforeEach
  void initUseCase() {
    controller = new MapController(mapService, modelMapper);
  }

  @Test
  public void getAllPostCodesTest() throws Exception {
    Assert.isTrue(controller.getAllPostcodes().getStatusCode().is2xxSuccessful(), "Expected 200 status code");
  }

  @Test
  public void calculateDistanceTest() throws Exception {
    List<PostCodeLatLng> postCodeLatLngs = new ArrayList<>();
    postCodeLatLngs.add(new PostCodeLatLng());
    when(mapService.getAll()).thenReturn(postCodeLatLngs);

    List<PostcodeDetail> postcodeDetails = (List<PostcodeDetail>) controller.getAllPostcodes().getBody();
    Assert.notEmpty(postcodeDetails, "List is empty");
  }


}