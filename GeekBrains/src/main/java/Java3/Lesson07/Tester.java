package Java3.Lesson07;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

class SortbyProperty implements Comparator<Method>
{
    // Сортировка методов по приоритету
    public int compare(Method a, Method b)
    {
        return a.getAnnotation(Test.class).priority() - b.getAnnotation(Test.class).priority();
    }
}

public class Tester {

    public static void start(Class TestClass) throws RuntimeException {

         TestClass myTest = null;
         try {      // Создаем экземпляр класса TestClass
            Constructor testCounstructor = TestClass.class.getConstructor();
            myTest = (TestClass)testCounstructor.newInstance();
         } catch (InstantiationException | IllegalAccessException  | NoSuchMethodException | InvocationTargetException  e) {
            e.printStackTrace();
         }

         Method[] methods = TestClass.class.getDeclaredMethods();
         ArrayList<Method> testList = new ArrayList<Method>();
         Method beforeMetod = null;
         int beforeMetodCount = 0;
         Method afterMethod = null;
         int afterMethodCount = 0;

         for (Method o : methods) {
             if(o.getAnnotation(Test.class) != null) {
                 testList.add(o);           // Добавляем в ArrayList методы с аннотацией Test
             }
             if (o.getAnnotation(BeforeSute.class) != null) {   // Ищем методы с аннотацией BeforeSute
                 beforeMetodCount++;
                 if (beforeMetodCount > 1) throw new RuntimeException("Annotation 'BeforeSute' found more than once");
                 else  beforeMetod = o;
             }
             if (o.getAnnotation(AfterSute.class) != null) {    // Ищем методы с аннотацией AfterSute
                 afterMethodCount++;
                 if (afterMethodCount > 1) throw new RuntimeException("Annotation 'AfterSute' found more than once");
                 else  afterMethod = o;
             }
         }

        RunBeforeAfterMetod(myTest, beforeMetod);

        RunAllTestMethods(myTest, testList);

        RunBeforeAfterMetod(myTest, afterMethod);

     }

    private static void RunAllTestMethods(TestClass myTest, ArrayList<Method> testList) {

        Collections.sort(testList, new SortbyProperty());   // Сортируем методы с аннотацией Test по приоритету

        for (int i = 0; i < testList.size(); i++) {
            Test anot = testList.get(i).getAnnotation(Test.class);
            System.out.println("Метод - " + testList.get(i).getName() +  "; Приоритет = " + anot.priority());

            try {
                    if (testList.get(i).getName() == "TestSubtract") {
                        testList.get(i).invoke(myTest, 3, 10, 7);
                    }

                    if (testList.get(i).getName() == "TestDiv") {
                        testList.get(i).invoke(myTest, 2, 10, 5);
                    }
                    if (testList.get(i).getName() == "TestMult") {
                        testList.get(i).invoke(myTest, 15, 5, 3);
                    }
                    if (testList.get(i).getName() == "TestAdd") {
                        testList.get(i).invoke(myTest, 3, 2, 2);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
        }
    }

    private static void RunBeforeAfterMetod(TestClass myTest, Method myMetod) {
        if (myMetod != null) {  // Если есть метод BeforeSute или AfterSute, выполняем его
            try {
                myMetod.invoke(myTest);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Tester.start(TestClass.class);
    }
}
