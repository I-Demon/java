package Java3.Lesson07;

public class TestClass {

    public TestClass() {

    }

    private Calculator calc;

    @BeforeSute
    public void StartTest(){
        calc = new Calculator();
        System.out.println("Test Start");
    }


    @Test(priority = 7)
    public void TestAdd(int res, int A, int B){

        if (res == calc.Add(A, B)) {
            System.out.println("Сложение выполнено верно");
        }
        else {
            System.out.println("Сложение выполнено с ошибкой");
        }
    }

    @Test(priority = 1)
    public void TestSubtract(int res, int A, int B){

        if (res == calc.Subtract(A, B)) {
            System.out.println("Вычитание выполнено верно");
        }
        else {
            System.out.println("Вычитание выполнено с ошибкой");
        }
    }


    @Test(priority = 3)
    public void TestMult(int res, int A, int B){

        if (res == calc.Mult(A, B)) {
            System.out.println("Умножение выполнено верно");
        }
        else {
            System.out.println("Умножение выполнено с ошибкой");
        }
    }

    @Test(priority = 2)
    public void TestDiv(int res, int A, int B){

        if (res == calc.Div(A, B)) {
            System.out.println("Деление выполнено верно");
        }
        else {
            System.out.println("Деление выполнено с ошибкой");
        }
    }


    @AfterSute
    public void End(){
        System.out.println("Test End");
    }

}
