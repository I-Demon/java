package Java2.Lesson02;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException {

    private String message;

    MyArraySizeException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
