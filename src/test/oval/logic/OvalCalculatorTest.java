package logic;

import com.epam.oval.entity.CoordinatePlane;
import com.epam.oval.entity.Oval;
import com.epam.oval.entity.Point;
import com.epam.oval.logic.OvalCalculator;
import org.junit.*;
import org.junit.jupiter.api.Test;


public class OvalCalculatorTest {
    @Test
    public void testCalculateAreaShouldCalculateWhenOvalIsValid() {
        //given
        OvalCalculator calculator = new OvalCalculator();
        Oval oval = new Oval(new Point(0, 0), new Point(2, 2));
        //when
        double area = calculator.calculateArea(oval);
        //then
        Assert.assertEquals(3.14, area, 0.01);
    }

    @Test
    public void testShouldCalculatePerimeterShouldCalculateWhenOvalIsValid() {
        //given
        OvalCalculator calculator = new OvalCalculator();
        Oval oval = new Oval(new Point(0, 0), new Point(2, 2));
        //when
        double perimeter = calculator.calculatePerimeter(oval);
        //then
        Assert.assertEquals(6.28, perimeter, 0.01);
    }

    @Test
    public void testShouldReturnTrueWhenOvalCrossThePlane() {
        //given
        OvalCalculator calculator = new OvalCalculator();
        Oval oval = new Oval(new Point(0, 0), new Point(2, 2));
        //when
        boolean distanceToTheAxis = calculator.isCrossingCoordinatePlane(oval, CoordinatePlane.OX);
        //then
        Assert.assertEquals(true, distanceToTheAxis);
    }

    @Test
    public void testShouldReturnFalseWhenOvalDoesNotCrossThePlane() {
        //given
        OvalCalculator calculator = new OvalCalculator();
        Oval oval = new Oval(new Point(1, 1), new Point(3, 3));
        //when
        boolean distanceToTheAxis = calculator.isCrossingCoordinatePlane(oval, CoordinatePlane.OX);
        //then
        Assert.assertEquals(false, distanceToTheAxis);
    }


    @Test
    public void testShouldCalculateTheDistanceWhenOvalDoesNotCrossThePlane() {
        //given
        OvalCalculator calculator = new OvalCalculator();
        Oval oval = new Oval(new Point(1, 1), new Point(3, 3));
        //when
        double distanceToTheAxis = calculator.calculateTheDistanceToTheAsix(oval, CoordinatePlane.OX);
        //then
        Assert.assertEquals(1, distanceToTheAxis, 0.1);
    }

    @Test
    public void testReturnTrueWhenOvalIsValid() {
        //given
        OvalCalculator calculator = new OvalCalculator();
        Oval oval = new Oval(new Point(1, 1), new Point(3, 3));
        //when
        boolean validOval = calculator.isValidOval(oval);
        //then
        Assert.assertEquals(true, validOval);
    }

    @Test
    public void testReturnFalseWhenOvalIsNotValid() {
        //given
        OvalCalculator calculator = new OvalCalculator();
        Oval oval = new Oval(new Point(1, 1), new Point(1, 1));
        //when
        boolean validOval = calculator.isValidOval(oval);
        //then
        Assert.assertEquals(false, validOval);
    }
}