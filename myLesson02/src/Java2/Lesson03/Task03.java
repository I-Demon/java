package Java2.Lesson03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Task03 {
    private static final String str = "в недрах тундры выдры в гетрах тырят в вёдра ядра кедров выдрав с выдры в тундре гетры вытру выдрой ядра кедров вытру гетрой выдре морду ядра в вёдра выдру в тундру";
    private static String[] arr = str.split(" ");

    public static void main(String[] args) {
        //System.out.println( Arrays.toString(arr));
        HashMap<String, Integer> arrayMap=new HashMap<String, Integer>();
        for (int i = 0; i < arr.length; i++) {
            int value = 1;
            if (arrayMap.containsKey(arr[i])) value = arrayMap.get(arr[i]) + 1;     // Если слово уже есть в HashMap, то увеличиваем счетчик слов на 1
            arrayMap.put(arr[i], value);
        }

        //  Выводим все уникальные слова массива и кол-во повторов каждого слова

        for (Map.Entry entry : arrayMap.entrySet()) {
            System.out.println("Слово: '" + entry.getKey() + "' - кол-во повторов = " + entry.getValue());
        }

        //  Создаем список людей
        Person per1 = new Person("Иванов", "1111-1111", "11@mail.ru");
        Person per2 = new Person("Иванов", "2222-2222", "22@mail.ru");
        Person per3 = new Person("Петров", "3333-3333", "33@mail.ru");
        Person per4 = new Person("Петров", "4444-4444", "44@mail.ru");
        Person per5 = new Person("Иванов", "5555-5555", "55@mail.ru");

        //  Добавляем людей в телефонную книгу
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addPerson(per1);
        phoneBook.addPerson(per3);
        phoneBook.addPerson(per2);
        phoneBook.addPerson(per5);
        phoneBook.addPerson(per4);

        String[] phoneList;
        String[] emailList;

        //  Выводим списки телефонов и email по фамилии
        phoneList = phoneBook.getPersonPhone("Иванов");
        emailList = phoneBook.getPersonEmail("Иванов");
        System.out.println("");
        System.out.println("Список телефонов человека по фамилии Иванов");
        System.out.println( Arrays.toString(phoneList));
        System.out.println("Список email человека по фамилии Иванов");
        System.out.println( Arrays.toString(emailList));

        System.out.println("");
        phoneList = phoneBook.getPersonPhone("Петров");
        emailList = phoneBook.getPersonEmail("Петров");
        System.out.println("Список телефонов человека по фамилии Петров");
        System.out.println( Arrays.toString(phoneList));
        System.out.println("Список email человека по фамилии Петров");
        System.out.println( Arrays.toString(emailList));

        System.out.println("");
        phoneList = phoneBook.getPersonPhone("Сидоров");
        emailList = phoneBook.getPersonEmail("Сидоров");
        System.out.println("Список телефонов человека по фамилии Сидоров");
        System.out.println( Arrays.toString(phoneList));
        System.out.println("Список email человека по фамилии Сидоров");
        System.out.println( Arrays.toString(emailList));

    }
}
