package Java1.Lesson_05;

public class Person
{
    public String personFIO;
    public String post;
    public String email;
    private String phone;
    private int salary;
    private int age;

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        boolean error = false;
        for (int i = 0; i < phone.length(); i++)
        {
            if (i==0)
            {
               if  ((phone.charAt(i) == '+') || ((phone.charAt(i) >= '0') && (phone.charAt(i) <= '9') ))
                    error = false;
               else
                    error = true;
            }
            if (i>0)
            {
                error = !((phone.charAt(i) >= '0') && (phone.charAt(i) <= '9'));
            }
            if (error)
            {
                break;
            }
        }
        if (error) System.out.println("Телефон сотрудника  (" + personFIO +  ")  указан не корректно");
        else this.phone = phone;
    }

    public int getSalary() 
    {
        return salary;
    }   

    public void setSalary(int salary)
    {
        if (salary < 1) System.out.println("Зарплата сотрудника  (" + personFIO +  ") должна быть больше нуля");
        else   this.salary = salary;
    }

    public int getAge() 
    {
        return age;
    }

    public void setAge(int age)
    {
        if (age < 1) System.out.println("Возраст сотрудника (" + personFIO + ") указан не верно. Он должен быть больше нуля");
        else this.age = age;
    }

    public Person(String personFIO, String post, String email, String phone, int salary, int age)
    {
        this.personFIO = personFIO;
        this.post = post;
        this.email = email;
        setPhone(phone);
        setSalary(salary);
        setAge(age);
    }

    public void printInfo()
    {
        System.out.println("Ф.И.О. - " + personFIO + "; Должность - " + post + "; e-mail - " + email + "; Тел - " + phone + "; Зарплата - " + salary + "; Возраст - " + age);
    }

    public static void main(String[] args)
    {
        Person[] persArray = new Person[5];

        persArray[0] = new Person("Иванов Петр Сергеевич", "прораб", "ref@mail.ru", "+780980098", 50, 25);
        persArray[1] = new Person("Петров Иван Анатольевич", "Врач", "doc@mail.ru", "11111111", 20, 50);
        persArray[2] = new Person("Кузнецов Илья Игоревич", "учитель", "teacher@mail.ru", "+2222222", 10, 40);
        persArray[3] = new Person("Орлов Иван Петрович", "программист", "prog@gmail.com", "3333333", 90, 35);
        persArray[4] = new Person("Крылов Юрий Павлович", "продавец", "ref@mail.ru", "4444444", 10, 42);

        System.out.println("Сотрудники старше 40 лет");
        for (Person person : persArray)
        {
          if (person.getAge() > 40) person.printInfo();
        }
    }
}
