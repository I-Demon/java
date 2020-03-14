package Java2.Lesson03;

public class Person {
        private String surname;
        private String phoneNumber;
        private String email;

    public Person(String surname, String phoneNumber, String email) {
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
