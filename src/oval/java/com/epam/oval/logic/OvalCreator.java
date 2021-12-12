package com.epam.oval.logic;

import com.epam.oval.entity.Oval;
import com.epam.oval.entity.Point;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OvalCreator {
    private static final Logger LOGGER = LogManager.getLogger(OvalCreator.class);
    private final static String DELIMITER = " ";
    public Oval create(String line) {
        LOGGER.info("Started creating an oval from string: " + line);
        String[] splitLines = line.split(DELIMITER);
        double firstPointXCoordinate = Double.parseDouble(splitLines[0]);
        double firstPointYCoordinate = Double.parseDouble(splitLines[1]);
        double secondPointXCoordinate = Double.parseDouble(splitLines[2]);
        double secondPointYCoordinate = Double.parseDouble(splitLines[3]);
        Point firstPoint = new Point(firstPointXCoordinate, firstPointYCoordinate);
        Point secondPoint = new Point(secondPointXCoordinate, secondPointYCoordinate);
        Oval createdOval =  new Oval(firstPoint, secondPoint);
        LOGGER.info("An Oval from string '" + line + "' is " + createdOval.toString());
        return createdOval;
    }
}
