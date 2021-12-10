package com.epam.oval.logic;

import com.epam.oval.entity.CoordinatePlane;
import com.epam.oval.entity.Oval;
import com.epam.oval.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OvalCalculator {
    final double pi = Math.PI;

    private static final Logger LOGGER = LogManager.getLogger(OvalCalculator.class);

    public double calculateArea(Oval oval) {
        LOGGER.info("Started calculating the  area of " + oval.toString());
        Point firstpoint = oval.getFirstpoint();
        Point secondpoint = oval.getSecondpoint();
        double area = Math.abs(firstpoint.getxCoordinate() - secondpoint.getxCoordinate())  *
                Math.abs(firstpoint.getyCoordinate() - secondpoint.getyCoordinate()) * pi / 4;
        LOGGER.info("Calculated the  area of " + oval + ": " + area);
        return area;
    }

    public double calculatePerimeter(Oval oval) {
        LOGGER.info("Started calculating the perimeter of " + oval.toString());
        Point firstpoint = oval.getFirstpoint();
        Point secondpoint = oval.getSecondpoint();
        double perimeter = 2 * pi * Math.sqrt((Math.pow((firstpoint.getxCoordinate() - secondpoint.getxCoordinate())/2, 2)
                + Math.pow((firstpoint.getyCoordinate() - secondpoint.getyCoordinate())/2 , 2))/2 );
        LOGGER.info("Calculated the perimeter of " + oval + ": " + perimeter);
        return perimeter;
    }



    public boolean isCrossingCoordinatePlane(Oval oval, CoordinatePlane plane) {
        LOGGER.info("Checking for an crossing with the oval " + oval.toString() + "by plane " + plane.toString());
        Point firstPoint = oval.getFirstpoint();
        Point secondPoint = oval.getSecondpoint();
        double firstDistance = findDistance(firstPoint, plane);
        double secondDistance = findDistance(secondPoint, plane);
        return firstDistance == 0 || secondDistance == 0;
    }


    public double calculateTheDistanceToTheAsix(Oval oval, CoordinatePlane plane) {
        LOGGER.info("Started calculating the distance to the axis " + plane.toString() + "by " + oval.toString());
        if (isCrossingCoordinatePlane(oval, plane)) {
            return 0;
        }
        Point firstPoint = oval.getFirstpoint();
        Point secondPoint = oval.getSecondpoint();
        double firstDistance = findDistance(firstPoint, plane);
        double secondDistance = findDistance(secondPoint, plane);

        if (secondDistance  > firstDistance) {
            LOGGER.info("Calculated the distance: " + firstDistance);
            return firstDistance;
        } else {
            LOGGER.info("Calculated the distance: " + secondDistance);
            return secondDistance;
        }
    }

    private double findDistance(Point point, CoordinatePlane plane) {
        LOGGER.info("Find the distance from the point " + point.toString() + "to the plane" + plane.toString());
        double distance = 0;
        switch (plane) {
            case OX:
                distance = point.getxCoordinate();
                break;
            case OY:
                distance = point.getyCoordinate();
                break;
        }
        distance = Math.abs(distance);
        LOGGER.info("Calculated the distance: " + distance);
        return distance;
    }

    public boolean isValidOval(Oval oval){
        LOGGER.info("Checking for the valid oval: " + oval.toString());
        Point firstPoint = oval.getFirstpoint();
        Point secondPoint = oval.getSecondpoint();
        return firstPoint.getxCoordinate()!=secondPoint.getxCoordinate() && firstPoint.getyCoordinate()!=secondPoint.getyCoordinate();
    }
}
