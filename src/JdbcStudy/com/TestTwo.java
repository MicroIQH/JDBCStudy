package JdbcStudy.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class TestTwo {
    private static final String URL = "jdbc:mysql://localhost/day_01?serverTimezone=UTC980";
    private static final String USER = "root";
    private static  String PASSWORD;
    public static void main(String[] args)throws Exception {
        Scanner b= new Scanner(System.in);
        System.out.println("请输入密码：");
        PASSWORD = b.next();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from student");
        while (resultSet.next()){
            System.out.println(resultSet.getString("s_id")+","+resultSet.getString("s_name"));


        }
    }

}
