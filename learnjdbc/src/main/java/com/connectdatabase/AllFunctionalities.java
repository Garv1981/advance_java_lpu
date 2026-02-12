package com.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class AllFunctionalities {

    // 1️ Connection method
    static Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://localhost:5433/college";
        String un = "postgres";
        String pwd = "root";

        return DriverManager.getConnection(url, un, pwd);
    }

    // 2️ INSERT
    static void insertEmp(int id, String name, String state) {
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();

            String sql = "insert into emp values (" + id + ",'" + name + "','" + state + "')";
            stmt.executeUpdate(sql);

            con.close();
            System.out.println("Data inserted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 3️ UPDATE
    static void updateEmp(int id, String state) {
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();

            String sql = "update emp set state='" + state + "' where id=" + id;
            stmt.executeUpdate(sql);

            con.close();
            System.out.println("Data updated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 4️ DELETE
    static void deleteEmp(int id) {
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();

            String sql = "delete from emp where id=" + id;
            stmt.executeUpdate(sql);

            con.close();
            System.out.println("Data deleted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 5️ FIND (by id)
    static void findEmp(int id) {
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();

            String sql = "select * from emp where id=" + id;
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                System.out.println(
                        rs.getInt(1) + " " +
                        rs.getString(2) + " " +
                        rs.getString(3)
                );
            } else {
                System.out.println("Record not found");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 6️ READ ALL
    static void readAll() {
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from emp");

            while (rs.next()) {
                System.out.println(
                        rs.getInt(1) + " " +
                        rs.getString(2) + " " +
                        rs.getString(3)
                );
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 7️⃣ MAIN METHOD
    public static void main(String[] args) {

        insertEmp(2, "Ravi", "UP");
        insertEmp(3, "Amit", "Delhi");

        readAll();

        updateEmp(1, "Punjab");

        findEmp(1);

        deleteEmp(2);

        readAll();
    }
}
