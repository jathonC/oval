package repository;

import com.epam.oval.entity.OvalObservable;
import com.epam.oval.entity.Point;
import com.epam.oval.repository.OvalRepositoryImpl;
import com.epam.oval.repository.OvalSpecification;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OvalrepositoryImplTest {
    private static final OvalObservable OVAL1 = new OvalObservable(new Point(0,0), new Point(2,2),2);
    private static final OvalObservable OVAL2 =new OvalObservable(new Point(0,0), new Point(4,4),2);

    @Test
    public void testQueryShouldReturnOvalWhenOvalFitsSpecification() {
        //given
        OvalRepositoryImpl ovalRepository = new OvalRepositoryImpl();
        ovalRepository.add(OVAL1);
        OvalSpecification specification = Mockito.mock(OvalSpecification.class);
        Mockito.when(specification.specified(OVAL1)).thenReturn(true);
        List<OvalObservable> expectedQuery = Arrays.asList(OVAL1);
        //when
        List<OvalObservable> actualQuery = ovalRepository.query(specification);
        //then
        Assert.assertEquals(expectedQuery, actualQuery);
    }

    @Test
    public void testQueryShouldNotReturnOvalWhenOvalDoesNotFitSpecification() {
        //given
        OvalRepositoryImpl ovalRepository = new OvalRepositoryImpl();
        ovalRepository.add(OVAL1);
        OvalSpecification specification = Mockito.mock(OvalSpecification.class);
        Mockito.when(specification.specified(OVAL1)).thenReturn(false);
        List<OvalObservable> expectedQuery = new ArrayList<>();
        //when
        List<OvalObservable> actualQuery = ovalRepository.query(specification);
        //then
        Assert.assertEquals(expectedQuery, actualQuery);
    }


   
}
