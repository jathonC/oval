package com.epam.oval.logic;

import com.epam.oval.entity.Oval;
import com.epam.oval.entity.Point;

public class OvalCreator {
    private final static String DELIMITER = " ";
    public Oval create(String line) {

        String[] splitLines = line.split(DELIMITER);
        double firstPointXCoordinate = Double.parseDouble(splitLines[0]);
        double firstPointYCoordinate = Double.parseDouble(splitLines[1]);
        double secondPointXCoordinate = Double.parseDouble(splitLines[2]);
        double secondPointYCoordinate = Double.parseDouble(splitLines[3]);
        Point firstPoint = new Point(firstPointXCoordinate, firstPointYCoordinate);
        Point secondPoint = new Point(secondPointXCoordinate, secondPointYCoordinate);
        return new Oval(firstPoint, secondPoint);
    }
}
