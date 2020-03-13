package Java2.Lesson03;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
        private ArrayList <Person> personList;
        private HashMap<String, ArrayList <Person>> phoneBook = new HashMap<String, ArrayList <Person>>();

        // Метод добавления людей в телефонную книгу
        public void addPerson(Person aPerson){
            personList = new  ArrayList<>();
            if (phoneBook.containsKey(aPerson.getSurname())) personList = phoneBook.get(aPerson.getSurname());     // Если слово уже есть в HashMap, то увеличиваем счетчик слов на 1
            personList.add(aPerson);
            phoneBook.put(aPerson.getSurname(), personList);
        }

        // Метод получения списка телефоном человека по фамилии
        public String[] getPersonPhone(String surname){

            if (phoneBook.containsKey(surname)) personList = phoneBook.get(surname);
            else return new String[1] ;

            int recCount = personList.size();
            String[] phoneList = new String[recCount];

            for (int i = 0; i < recCount; i++) {
                phoneList[i] = personList.get(i).getPhoneNumber();
            }

            return phoneList;
        }

        // Метод получения списка email человека по фамилии
        public String[] getPersonEmail(String surname){

            if (phoneBook.containsKey(surname)) personList = phoneBook.get(surname);
            else return new String[1] ;

            int recCount = personList.size();
            String[] emailList = new String[recCount];

            for (int i = 0; i < recCount; i++) {
                emailList[i] = personList.get(i).getEmail();
            }

            return emailList;
        }

}
