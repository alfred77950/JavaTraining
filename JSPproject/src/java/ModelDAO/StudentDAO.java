/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Config.ConnectionDB;
import Interface.CRUD;
import Model.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Alfredo Maldonado
 */
public class StudentDAO implements CRUD<Student> {
    
    PreparedStatement preparedStatement;
    ResultSet resultQuery;

    @Override
    public List listAll() {
        ArrayList<Student> listStudent = new ArrayList<>();
        String sql = "select * from student";
        try {
            preparedStatement = ConnectionDB.getConnection().prepareStatement(sql);
            resultQuery = preparedStatement.executeQuery();
            while(resultQuery.next()){
                Student student = new Student();
                student.setId(resultQuery.getInt("Id"));
                student.setName(resultQuery.getString("Name"));
                student.setLastName(resultQuery.getString("LastName"));
                student.setAge(resultQuery.getInt("Age"));
                listStudent.add(student);
            }
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        
        return listStudent;
    }

    @Override
    public Student listById(int id) {
        String sql = "select * from student where Id=" + id;
        Student student = new Student();

        try {
            preparedStatement = ConnectionDB.getConnection().prepareStatement(sql);
            resultQuery = preparedStatement.executeQuery();
            
            while(resultQuery.next()){
                student.setId(resultQuery.getInt("Id"));
                student.setName(resultQuery.getString("Name"));
                student.setLastName(resultQuery.getString("LastName"));
                student.setAge(resultQuery.getInt("Age"));
            }
            
        } catch (SQLException e) {
            System.out.println("Exception" + e.getMessage());
        }
        
        return student;
    }

    @Override
    public boolean add(Student student) {
        String sql = "insert into student(Name, LastName, Age)values('" 
                + student.getName() + "','" + student.getLastName()
                + "'," + student.getAge() + ")";
        
        try {
            preparedStatement = ConnectionDB.getConnection().prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return true;
    }

    @Override
    public boolean edit(Student student) {
        String sql = "update student set Name='" + student.getName() + "',LastName='" + student.getLastName() +
                "',Age='" + student.getAge() + "' where Id=" + student.getId();
        
        try {
            preparedStatement = ConnectionDB.getConnection().prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return true;
    }

    @Override
    public boolean delete(int id) {
        String sql = "delete from student where id=" + id;
        
        try {
            preparedStatement = ConnectionDB.getConnection().prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return true;
    }

    @Override
    public List findByValue(String value) {
        List<Student> listStudent = new LinkedList<>();
        String sql = "select * from student where Name like '" + value + "' or LastName like '" + value + "' or Age like '" + value + "'";
        
        try {
            preparedStatement = ConnectionDB.getConnection().prepareStatement(sql);
            resultQuery = preparedStatement.executeQuery();
            while(resultQuery.next()){
                Student student = new Student();
                student.setId(resultQuery.getInt("Id"));
                student.setName(resultQuery.getString("Name"));
                student.setLastName(resultQuery.getString("LastName"));
                student.setAge(resultQuery.getInt("Age"));
                listStudent.add(student);
            }
        } catch (SQLException e) {
            System.out.println("Exception: "  + e.getMessage());
        }
        
        return listStudent;
    }
}
