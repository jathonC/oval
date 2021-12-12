package logic;

import com.epam.oval.logic.OvalValidator;
import org.junit.Assert;
import org.junit.Test;

public class OvalValidatorTest {

    private static final String VALID_LINE = "1.0 2.0 3.0 4.0";
    private static final String INVALID_LINE = "1.z0 2.0 3.0 4.0";

    private final OvalValidator validator = new OvalValidator();

    @Test
    public void testIsValidLineShouldReturnTrueWhenTheLineIsValid() {
        //given
        //when
        boolean statement = validator.isValidLine(VALID_LINE);
        //then
        Assert.assertTrue(statement);
    }

    @Test
    public void testIsValidLineShouldReturnTrueWhenTheLineIsInvalid() {
        //given
        //when
        boolean statement = validator.isValidLine(INVALID_LINE);
        //then
        Assert.assertFalse(statement);
    }
}