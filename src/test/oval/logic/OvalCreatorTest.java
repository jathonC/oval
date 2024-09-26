package logic;

import com.epam.oval.entity.Oval;
import com.epam.oval.entity.Point;
import com.epam.oval.logic.OvalCreator;
import org.junit.Assert;
import org.junit.Assert;
import org.junit.Test;

public class OvalCreatorTest { //refactor

    private static final String VALID_LINE = "1.0 1.0 1.0 1.0";
    private static final String INVALID_LINE = "-3e.0 9.0 22.0 34.0";
    private final OvalCreator creator = new OvalCreator();

    @Test
    public void testShouldCreateOvalWhenDataIsValid() {

        //given
        Oval expectedOval = new Oval(new Point(1, 1), new Point(1, 1));
        //when
        Oval createdOval = creator.create(VALID_LINE);
        //then
        Assert.assertEquals(expectedOval, createdOval);
    }

    @Test
    public void testShouldCreateOvalWhenDataIsInValid() {
        //given
        Oval expectedOval = new Oval(new Point(1, 1), new Point(1, 1));
        //when
        Oval createdOval = creator.create(INVALID_LINE);
        //then
        Assert.assertEquals(expectedOval, createdOval);
    }
}