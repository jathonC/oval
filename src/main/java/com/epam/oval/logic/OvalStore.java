package com.epam.oval.logic;

import com.epam.oval.entity.OvalObservable;
import com.epam.oval.entity.Parameters;

import java.util.HashMap;
import java.util.Map;

public class OvalStore implements Observer<OvalObservable> {

    private static OvalStore INSTANCE;

    private final OvalCalculator ovalCalculator = new OvalCalculator();

    private final Map<Integer, Parameters> parameters = new HashMap<>();


    public void update(OvalObservable oval) {
        double volume = ovalCalculator.calculatePerimeter(oval);
        double surfaceArea = ovalCalculator.calculateArea(oval);
        parameters.put(oval.getId(), new Parameters(volume, surfaceArea));
    }

    public Parameters get(Object key) {
        return parameters.get(key);
    }

    public static   OvalStore getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new OvalStore();
        }
        return INSTANCE;
    }

}
