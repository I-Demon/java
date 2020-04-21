package Java3.Lesson06;

public class MainClass {

    public int[] GetArray17(int[] arr) throws RuntimeException{
        if (arr.length == 0) {   throw new RuntimeException("Number 4 not found"); }
        int[] res;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) index = i;
        }
        if (index == 0) {   throw new RuntimeException("Number 4 not found");   }
        res = new int[arr.length -(index+1)];
        System.arraycopy(arr, (index+1), res, 0, (arr.length -(index+1)));
        return res;
    }

    public boolean isArrayHas14(int[] arr){
        if (arr.length == 0)   return false;
        boolean found1 = false;
        boolean found4 = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1 ) found1 = true;
            if (arr[i] == 4 ) found4 = true;
            if (found1 && found4)  return true  ;
        }
        return (found1 && found4);
    }
}
