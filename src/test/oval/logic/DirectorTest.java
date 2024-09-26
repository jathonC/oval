package logic;
import com.epam.oval.dao.DataException;
import com.epam.oval.dao.DataReader;
import com.epam.oval.entity.Oval;
import com.epam.oval.entity.Point;
import com.epam.oval.logic.Director;
import com.epam.oval.logic.OvalCreator;
import com.epam.oval.logic.OvalValidator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
public class DirectorTest {
    private static final String TEST_PATH = "path";
    private static final String VALID_LINE1 = "1.0 3.0 4.0 5.0";
    private static final String VALID_LINE2 = "2.0 -3.0 4.0 5.0";
    private static final Oval VALID_OVAL1 = new Oval(new Point(1,1), new Point(2, 3));
    private static final Oval VALID_OVAL2 = new Oval(new Point(3,3), new Point(-3, 4));



    @Test
    public void testReadShouldReadLinesWhenLinesAreValid() throws DataException {
        //given
        List<String> actualLines = Arrays.asList(VALID_LINE1, VALID_LINE2);
        DataReader reader = Mockito.mock(DataReader.class);
        Mockito.when(reader.read(TEST_PATH)).thenReturn(actualLines);
        OvalValidator validator = Mockito.mock(OvalValidator.class);
        Mockito.when(validator.isValidLine(VALID_LINE1)).thenReturn(true);
        Mockito.when(validator.isValidLine(VALID_LINE2)).thenReturn(true);
        OvalCreator creator = Mockito.mock(OvalCreator.class);
        Mockito.when(creator.create(VALID_LINE1)).thenReturn(VALID_OVAL1);
        Mockito.when(creator.create(VALID_LINE2)).thenReturn(VALID_OVAL2);
        Director director = new Director(reader, validator, creator);
        List<Oval> expectedOvals = Arrays.asList(VALID_OVAL1, VALID_OVAL2);
        //when
        List<Oval> actualOvals = director.read(TEST_PATH);
        //then

        Assert.assertEquals(expectedOvals, actualOvals);

    }
}
