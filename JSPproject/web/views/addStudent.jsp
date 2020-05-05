<%-- 
    Document   : addStudent
    Created on : May 4, 2020, 2:21:40 PM
    Author     : Alfredo Maldonado
--%>

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
                <h1>Add new student</h1>
                <form action="StudentController">
                    <div class="access-button">
                        <a class="btn btn-info" href="StudentController?action=listStudent">Back</a>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                          <span class="input-group-text" id="inputGroup-sizing-default">Name</span>
                        </div>
                        <input type="text" class="form-control" name="name" size="50">
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                          <span class="input-group-text" id="inputGroup-sizing-default">Last Name</span>
                        </div>
                        <input type="text" class="form-control" name="lastname" size="50">
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                          <span class="input-group-text" id="inputGroup-sizing-default">Age</span>
                        </div>
                        <input type="number" class="form-control" name="age" size="2">
                    </div>
                    <input class="btn btn-success" type="submit" name="action" value="Save">
                </form>
            </div>
        </div>
    </body>
</html>
