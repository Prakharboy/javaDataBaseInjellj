package com.stackroute;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class SqlStatement extends HttpServlet implements RowMapper<SqlStatement> {
    private static final long serialVersionUID = 1L;

    private String firstName;
    private String LastName;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }



    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int id;


    private int age;


    public static void main(String[] args) throws IOException {
        JdbcTemplate jdbcTemplatel;
        DataSource dataSource = null;


ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
dataSource=(DataSource)context.getBean(DataSource.class);
        jdbcTemplatel = new JdbcTemplate(dataSource);




      //  System.out.println(jdbcTemplatel.queryForRowSet("select * from REGISTRATIONn;"));

        List<Map<String, Object>> sss=jdbcTemplatel.queryForList("select * from REGISTRATIONn;");

        for(Map<String, Object> row : sss){
            String id = row.get("id").toString();
            String name = (String)row.get("first");
            System.out.println(id + " " + name + " ");
        }
        SqlStatement sd=new SqlStatement();;



    }



    @Override
    public SqlStatement mapRow(ResultSet resultSet, int i) throws SQLException {


        SqlStatement st=new SqlStatement();
        st.setId(resultSet.getInt("id"));
        st.setFirstName(resultSet.getString("first"));

        return st;

    }
}
