package JdbcStudy.com;

import java.sql.*;

public class MainTest {
    public static void main(String[] args) throws SQLException {

        try {
            Class.forName("java.sql.Driver");
            //1.注册驱动
//            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            //2.建立连接bv 参数一：协议 + 访问数据库 参数二：用户名 参数三：密码
              Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/day_01","root","980308");

             //创建Statement，连接数据库，一定需要！
              Statement st = conn.createStatement();

              //执行查询
            String sql = "select * from Student";
           ResultSet rs =  st.executeQuery(sql);
           //遍历
           while (rs.next()){
               int s_id = rs.getInt("s_id");
               String s_name = rs.getString("s+name");

               System.out.println("id"+ s_id +"****" + "name" + s_name);
           }

           rs.close();
           st.close();
           conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
