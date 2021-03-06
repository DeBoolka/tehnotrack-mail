package ru.mail.track.jdbc;

/**
 * Created by r.kildiev on 02.11.2015.
 */

import java.sql.*;

public class JDBCExample {

    public static void main(String[] argv) throws SQLException, ClassNotFoundException {

        Class.forName("org.postgresql.Driver");

        Connection c = DriverManager.getConnection("jdbc:postgresql://178.62.140.149:5432/mydb",
                "senthil", "ubuntu");

        Statement stmt;
        String sql;

        stmt = c.createStatement();
        sql = "CREATE TABLE IF NOT EXISTS company" +
                "(ID INT PRIMARY KEY     NOT NULL," +
                " NAME           TEXT    NOT NULL, " +
                " AGE            INT     NOT NULL, " +
                " ADDRESS        CHAR(50), " +
                " SALARY         REAL)";
        stmt.executeUpdate(sql);
        stmt.close();
//        c.close();

        c.setAutoCommit(false);

        stmt = c.createStatement();
        sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                + "VALUES (1, 'Paul', 32, 'California', 20000.00 );";
        stmt.executeUpdate(sql);

        sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                + "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );";
        stmt.executeUpdate(sql);

        sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                + "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );";
        stmt.executeUpdate(sql);

        sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                + "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );";
        stmt.executeUpdate(sql);

        stmt.close();
        c.commit();
//        c.close();

        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM COMPANY;");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String address = rs.getString("address");
            float salary = rs.getFloat("salary");
            System.out.println("ID = " + id);
            System.out.println("NAME = " + name);
            System.out.println("AGE = " + age);
            System.out.println("ADDRESS = " + address);
            System.out.println("SALARY = " + salary);
            System.out.println();
        }
        rs.close();
        stmt.close();
//        c.close();

        stmt = c.createStatement();
        sql = "UPDATE COMPANY SET SALARY = 25000.00 WHERE ID=1;";
        stmt.executeUpdate(sql);
        c.commit();

        rs = stmt.executeQuery("SELECT * FROM COMPANY;");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String address = rs.getString("address");
            float salary = rs.getFloat("salary");
            System.out.println("ID = " + id);
            System.out.println("NAME = " + name);
            System.out.println("AGE = " + age);
            System.out.println("ADDRESS = " + address);
            System.out.println("SALARY = " + salary);
            System.out.println();
        }
        rs.close();
        stmt.close();
//        c.close();

        stmt = c.createStatement();
        sql = "DELETE FROM COMPANY WHERE ID=2;";
        stmt.executeUpdate(sql);
        c.commit();

        rs = stmt.executeQuery("SELECT * FROM COMPANY;");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String address = rs.getString("address");
            float salary = rs.getFloat("salary");
            System.out.println("ID = " + id);
            System.out.println("NAME = " + name);
            System.out.println("AGE = " + age);
            System.out.println("ADDRESS = " + address);
            System.out.println("SALARY = " + salary);
            System.out.println();
        }
        rs.close();
        stmt.close();
        c.close();

//        PreparedStatement prepStmnt = c.prepareStatement("INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
//                + "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );");
//        int parameterIndex = 234;
//        prepStmnt.setString(parameterIndex, "asd");
//        rs = prepStmnt.executeQuery();

    }

}
