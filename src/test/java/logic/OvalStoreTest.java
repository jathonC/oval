package logic;

import com.epam.oval.entity.OvalObservable;
import com.epam.oval.entity.Parameters;
import com.epam.oval.entity.Point;
import com.epam.oval.logic.OvalStore;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class OvalStoreTest {
    private static final double DELTA=0.01;

    @Test
    public void testUpdateShouldUpdateParametersWhenAOvalIsChanged(){
        //given
        OvalStore ovalStore= OvalStore.getInstance();
        OvalObservable ovalObservable1 =new OvalObservable(new Point(0,0),new Point(2,2), 1);
        ovalObservable1.attach(ovalStore);
        ovalStore.update(ovalObservable1);
        OvalObservable ovalObservable2=new OvalObservable(new Point(2,2),new Point(6,6), 2);
        ovalObservable2.attach(ovalStore);
        ovalStore.update(ovalObservable2);
        double expectedParameter=12.56;
        //when
        ovalObservable2.setFirstpoint(new Point(2,2));
        ovalObservable2.setSecondpoint(new Point(6,6));
        Parameters actualParameters=ovalStore.get(2);
        double actualVolume= actualParameters.getPerimeter();
        //then
        Assert.assertEquals(expectedParameter, actualVolume, DELTA);
    }
}
