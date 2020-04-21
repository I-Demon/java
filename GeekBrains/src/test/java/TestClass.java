import Java3.Lesson06.MainClass;

import org.junit.Assert;
import org.junit.Test;

public class TestClass {

    private MainClass mn;

    @Test
    public void testArr1(){
        mn = new MainClass();
        int[] arr = {1, 2, 4, 3, 2, 3, 4, 1, 7 };
        int[] res = {1,7};
        Assert.assertArrayEquals(res, mn.GetArray17(arr));
    }

    @Test
    public void testArr2(){
        mn = new MainClass();
        int[] arr = {1, 2, 4, 3, 2, 3, 0, 1, 7 };
        int[] res = {1,7};
        Assert.assertArrayEquals(res, mn.GetArray17(arr));
    }

    @Test
    public void testArr3(){
        mn = new MainClass();
        int[] arr = {1, 2, 4, 3, 2, 3, 0, 1, 7};
        int[] res = {3, 2, 3, 0, 1, 7};
        Assert.assertArrayEquals(res, mn.GetArray17(arr));
    }

    @Test(expected = RuntimeException.class)
    public void testArr4(){
        mn = new MainClass();
        int[] arr = {};
        int[] res = {1};
        Assert.assertArrayEquals(res, mn.GetArray17(arr));
    }

    @Test(expected = RuntimeException.class)
    public void testArr5(){
        mn = new MainClass();
        int[] arr = {1,1,1,1};
        int[] res = {};
        Assert.assertArrayEquals(res, mn.GetArray17(arr));
    }
}
