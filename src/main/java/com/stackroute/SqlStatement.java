package com.stackroute;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlStatement extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private String firstName;
    private String LastName;
    private int id;
    private int age;

    public static void main(String[] args) throws ServletException, IOException {
        SqlStatement sqlStatement=new SqlStatement();
        sqlStatement.doPost();
    }

    protected void doPost() throws ServletException, IOException
    {
        try {


            Connection con = DataBaseTest.initializeDatabase();

            String sql = new StringBuilder().append("CREATE TABLE REGISTRATIONn").append("(id INTEGER not NULL,").append("first VARCHAR(255),").append("last VARCHAR(255),").append(" age INTEGER,").append(" PRIMARY KEY ( id ));").toString();

//            String insertSql=new StringBuilder().append("insert into REGISTRATIONn values").append("(1,").append("'prakhar',").append("'bajpai',").append("22);").toString();
//
//            System.out.println(insertSql);


//            System.out.println(sql);
             PreparedStatement statement;
//            = con
//                    .prepareStatement(insertSql);
//
//            st.executeUpdate();


            statement = con.prepareStatement("SELECT * FROM REGISTRATIONn;");


            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                this.id = rs.getInt("id");
                this.firstName = rs.getString("first");
                this.LastName = rs.getString("last");
                this.age = rs.getInt("age");
            }

            System.out.println(this.age+this.firstName);

            statement.close();
            con.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
