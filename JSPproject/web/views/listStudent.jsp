<%-- 
    Document   : listStudent
    Created on : May 4, 2020, 2:22:01 PM
    Author     : Alfredo Maldonado
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="Model.Student"%>
<%@page import="ModelDAO.StudentDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="./css/global.css">
        <title>My first JSP Page</title>
    </head>
    <body>
        <div class="container">
            <h1>List Students</h1>
            
            <div class="access-button">
                <a class="btn btn-success" href="StudentController?action=addStudent">Add new student</a>
                <form class="form-inline form-search">
                    <input type="search" class="form-control" name="findValue" placeholder="Enter text...">
                    <input type="submit" class="btn btn-outline-secondary" name="action" value="searchStudent"></input>
                </form>
            </div>
            <table class="table table-bordered" border="1">
                <thead>
                    <tr>
                        <th class="text-center">Id</th>
                        <th class="text-center">Name</th>
                        <th class="text-center">Last Name</th>
                        <th class="text-center">Age</th>
                        <th class="text-center">Actions</th>
                    </tr>
                </thead>
                <%
                    StudentDAO dao = new StudentDAO();
                    List<Student> students = (List<Student>)(request.getAttribute("data"));
                    
                    List<Student> list = dao.listAll();
                    Iterator<Student> iter = students.iterator();
                    Student per = null;
                    while (iter.hasNext()) {
                        per = iter.next();

                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= per.getId()%></td>
                        <td class="text-center"><%= per.getName()%></td>
                        <td class="text-center"><%= per.getLastName()%></td>
                        <td class="text-center"><%= per.getAge()%></td>
                        <td class="text-center">
                            <a class="btn btn-info" href="StudentController?action=editStudent&id=<%= per.getId()%>">Edit</a>
                            <a class="btn btn-danger" href="StudentController?action=removeStudent&id=<%= per.getId()%>">Remove</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
