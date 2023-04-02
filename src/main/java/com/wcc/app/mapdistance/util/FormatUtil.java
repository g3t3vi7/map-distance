package com.wcc.app.mapdistance.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class FormatUtil {

    public static String roundFormat(double n) {
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.CEILING);
        return df.format(n);
    }
}
