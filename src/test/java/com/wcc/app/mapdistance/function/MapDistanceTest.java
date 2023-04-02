package com.wcc.app.mapdistance.function;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapDistanceTest {

    @Test
    public void CalculateDistanceTest() {
        MapDistance md = new MapDistance();
        Assertions.assertEquals(
                0.8050251643085133,
                md.calculateDistance(57.144156, -2.114864 , 57.137871, -2.121487));
    }
}
