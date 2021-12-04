package com.epam.oval.logic;

import com.epam.oval.entity.CoordinatePlane;
import com.epam.oval.entity.Oval;
import com.epam.oval.entity.Point;

public class OvalCalculator {
    final double pi = Math.PI;

    public double calculateArea(Oval oval) {
        Point firstpoint = oval.getFirstpoint();
        Point secondpoint = oval.getSecondpoint();
        double area = Math.abs(firstpoint.getxCoordinate() - secondpoint.getxCoordinate())  *
                Math.abs(firstpoint.getyCoordinate() - secondpoint.getyCoordinate()) * pi / 4;
        return area;
    }

    public double calculatePerimeter(Oval oval) {
        Point firstpoint = oval.getFirstpoint();
        Point secondpoint = oval.getSecondpoint();
        double perimeter = 2 * pi * Math.sqrt((Math.pow((firstpoint.getxCoordinate() - secondpoint.getxCoordinate())/2, 2)
                + Math.pow((firstpoint.getyCoordinate() - secondpoint.getyCoordinate())/2 , 2))/2 );
        return perimeter;
    }



    public boolean isCrossingCoordinatePlane(Oval oval, CoordinatePlane plane) {
        Point firstPoint = oval.getFirstpoint();
        Point secondPoint = oval.getSecondpoint();
        double firstDistance = findDistance(firstPoint, plane);
        double secondDistance = findDistance(secondPoint, plane);
        return firstDistance == 0 || secondDistance == 0;
    }


    public double calculateTheDistanceToTheAsix(Oval oval, CoordinatePlane plane) {
        if (isCrossingCoordinatePlane(oval, plane)) {
            return 0;
        }
        Point firstPoint = oval.getFirstpoint();
        Point secondPoint = oval.getSecondpoint();
        double firstDistance = findDistance(firstPoint, plane);
        double secondDistance = findDistance(secondPoint, plane);

        if (secondDistance  > firstDistance) {
            return firstDistance;
        } else {
            return secondDistance;
        }
    }

    private double findDistance(Point point, CoordinatePlane plane) {
        double distance = 0;
        switch (plane) {
            case OX:
                distance = point.getxCoordinate();
                break;
            case OY:
                distance = point.getyCoordinate();
                break;
        }
        return Math.abs(distance);
    }

    public boolean isValidOval(Oval oval){
        Point firstPoint = oval.getFirstpoint();
        Point secondPoint = oval.getSecondpoint();
        return firstPoint.getxCoordinate()!=secondPoint.getxCoordinate() && firstPoint.getyCoordinate()!=secondPoint.getyCoordinate();
    }
}
