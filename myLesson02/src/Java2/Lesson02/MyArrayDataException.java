package Java2.Lesson02;

public class MyArrayDataException extends NumberFormatException {

    private String message;

    MyArrayDataException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
