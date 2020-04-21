import Java3.Lesson06.MainClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public  class ParamTest {
   public static int[][] arr =  {
        {},
        {0, 0, 0},
        {2, 2, 4, 1},
        {5, 5, 10},
        {4, 4, 4, 0,0,1,0,0},
        {-1, 1, -4}

    };
    public static class param{
        int[] arrParam;
        boolean res;

        public param(int[] arrParam, boolean res) {
            this.arrParam = arrParam;
            this.res = res;
        }
    }

    @Parameterized.Parameters
    public static Collection<param> data() {
        ArrayList<param> resList = new ArrayList<>();
        resList.add(new param(arr[0], false));
        resList.add(new param(arr[1], false));
        resList.add(new param(arr[2], true));
        resList.add(new param(arr[3], false));
        resList.add(new param(arr[4], true));
        resList.add(new param(arr[5], false));

        return resList;
    }

    private int[] arrParam;
    private boolean res;

    public ParamTest(param arr) {
        this.arrParam = arr.arrParam;
        this.res = arr.res;
    }

    private MainClass mn;

    @Before
    public void init() {
        mn = new MainClass();
    }

    @Test
    public void arrTestHas14() {
        Assert.assertEquals(res, mn.isArrayHas14(arrParam));
    }
}

