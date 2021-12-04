package logic;

import com.epam.oval.datareader.DataException;
import com.epam.oval.datareader.DataReader;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataReaderTest {
    private final DataReader reader = new DataReader();

    @Test
    public void testReadShouldReadStringsWhenFileHasOneString() throws DataException {
        //given
        List<String> expectedLines = Arrays.asList("1.0 2.0 3.0 4.0");
        String path = "src/test/resources/oneLine.txt";
        //when
        List<String> actualLines = reader.read(path);
        //then
        Assert.assertEquals(expectedLines, actualLines);
    }

    @Test
    public void testReadShouldReadStringsWhenFileHasMultipleStrings() throws DataException {
        //given
        List<String> expectedLines = Arrays.asList("1.0 2.0 3.0 4.0", "line", "12345");
        //when
        List<String> actualLines = reader.read("src/test/resources/multipleLinesTxtFile");
        //then
        Assert.assertEquals(expectedLines, actualLines);
    }
}
