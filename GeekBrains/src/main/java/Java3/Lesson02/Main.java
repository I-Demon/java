package Java3.Lesson02;

import java.io.*;
import java.sql.*;
import java.util.Arrays;

public class Main {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstmt;


    public static void main(String[] args) throws SQLException {

        try {
            connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        create(stmt);   // Создание таблицы students, если ее нет в базе

        insert(stmt, "Bob5", "111");     // добавление записи

        update(stmt, 5, "777");     // обновление записи с ID = 5

        delete(stmt, 7);    // Удаление записи с ID = 7


        try {
            updatefromfile(stmt);           // обновление таблицы данными из файла
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        select(stmt);   // Выборка всех записей из таблицы

        disconnect();

    }

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:C:/GitProjects/JavaProjects/java/mainDB.db");
        stmt = connection.createStatement();
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void create(Statement stm) throws SQLException {
        String sql = "CREATE TABLE if not exists 'students' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'score' TEXT);";
        stm.execute(sql);
        System.out.println("Таблица создана");

    }

    public static void select(Statement stm) throws SQLException {
        String sql = "SELECT id, name, score FROM students" ;
        ResultSet rs = stm.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString("name") + " " + rs.getString("score"));
        }
    }

    public static  void insert(Statement stm, String name, String score)  throws SQLException {
        String sql = String.format("INSERT INTO students (name, score)  values('%s', '%s')", name, score) ;
        stm.execute(sql);
        System.out.println("Добавлена запись");
    }

    public static void update(Statement stm, int id,  String score) throws SQLException {
        String sql = String.format("Update students set score = '%s' Where Id = %d", score, id) ;
        stm.execute(sql);
        System.out.println("Обновлена запись");
    }

    public static void delete(Statement stm, int id) throws SQLException {
        String sql = String.format("Delete from students Where Id = %d", id) ;
        stm.execute(sql);
        System.out.println("запись c id = " + id + "  удалена");
    }

    public static void updatefromfile(Statement stm) throws SQLException, FileNotFoundException {
        //FileInputStream file = new FileInputStream("C:/GitProjects/JavaProjects/DZ_update.txt");
        try  {
            BufferedReader reader = new BufferedReader(new FileReader("C:/GitProjects/JavaProjects/DZ_update.txt"));
            String str;
            int id;
            String[] arr; // = new String[3];
            connection.setAutoCommit(false);    // отключаем автокоммит
            try {
                while ((str = reader.readLine()) != null) {
                    arr = str.split("  ");  //Разбираем строку на колонки
                    try {
                        id = Integer.parseInt(arr[0]);  // Пытаемся из первой колонки получить код идентификатора
                        if (id > 0) {
                            update(stm, id, arr[2]);    // Если полученный код > 0, то обновляем запись в БД
                        }
                    } catch (NumberFormatException e) {

                    }
                }
            }
            finally {
                connection.setAutoCommit(true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

