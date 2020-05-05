<%-- 
    Document   : editStudent
    Created on : May 4, 2020, 2:21:51 PM
    Author     : Alfredo Maldonado
--%>

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
            <div class="form-student">
                <%
                    StudentDAO studentDAO = new StudentDAO();
                    int id = Integer.parseInt(request.getParameter("id"));
                    Student student = studentDAO.listById(id);
                %>
                <h1>Edit student</h1>
                <form action="StudentController">
                    <div class="access-button">
                        <a class="btn btn-info" href="StudentController?action=listStudent">Back</a>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                          <span class="input-group-text" id="inputGroup-sizing-default">Name</span>
                        </div>
                        <input type="hidden" class="form-control" name="id" value="<%= student.getId() %>" size="50"/>
                        <input type="text" class="form-control" name="name" value="<%= student.getName() %>" size="50"/>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                          <span class="input-group-text" id="inputGroup-sizing-default">Last Name</span>
                        </div>
                        <input type="text" class="form-control" name="lastname" value="<%= student.getLastName() %>" size="50"/>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                          <span class="input-group-text" id="inputGroup-sizing-default">Age</span>
                        </div>
                        <input type="number" class="form-control" name="age" value="<%= student.getAge() %>" />
                    </div>
                    <input class="btn btn-success" type="submit" name="action" value="Update">
                </form>
            </div>
        </div>
    </body>
</html>
