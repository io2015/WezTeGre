<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page session="false" %>
<!doctype html>
<html>
<head>
        <title>Zarejestruj</title>
</head>
<body>
<form:form method="POST" modelAttribute="userForm" action="/signup">
        <table>
                <tr>
                        <td>Email:</td>
                        <td><form:input path="email"/></td>
                        <td><form:errors path="email"/></td>
                </tr>
                <tr>
                        <td>Imię:</td>
                        <td><form:input path="name"/></td>
                        <td><form:errors path="name"></form:errors></td>
                </tr>
                <tr>
                        <td>Nazwisko:</td>
                        <td><form:input path="surname"/></td>
                        <td><form:errors path="surname"/></td>
                </tr>
                <tr>
                        <td>Hasło:</td>
                        <td><form:password path="password"/></td>
                        <td><form:errors path="password"/></td>
                </tr>
                <tr>
                        <td>Potwierdzenie hasła:</td>
                        <td><form:password path="passwordConfirmation"/></td>
                        <td><form:errors path="passwordConfirmation"/></td>
                </tr>
                <tr>
                        <td colspan="2">
                                <input type="submit" value="Zarejestruj"/>
                        </td>
                </tr>
        </table>
</form:form>
</body>
</html>
