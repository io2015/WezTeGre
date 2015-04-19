<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!doctype html>
<html>
<head>
        <title>Zmiana danych użytkownika</title>
</head>
<body>
Twój email: <strong>${email}</strong>
<hr />

<form:form method="POST" modelAttribute="userData" action="/user/changeData">
        <table>
                <tr>
                        <td>Imię:*</td>
                        <td><form:input path="name"/></td>
                        <td><form:errors path="name"/></td>
                </tr>
                <tr>
                        <td>Nazwisko:*</td>
                        <td><form:input path="surname"/></td>
                        <td><form:errors path="surname"/></td>
                </tr>
                <tr>
                        <td>Miasto:</td>
                        <td><form:input path="city"/></td>
                        <td><form:errors path="city"/></td>
                </tr>
                <tr>
                        <td>Adres:</td>
                        <td><form:input path="address"/></td>
                        <td><form:errors path="address"/></td>
                </tr>
                <tr>
                        <td>Skype:</td>
                        <td><form:input path="skype"/></td>
                        <td><form:errors path="skype"/></td>
                </tr>
                <tr>
                        <td>Telefon:</td>
                        <td><form:input path="phoneNumber"/></td>
                        <td><form:errors path="phoneNumber"/></td>
                </tr>
                <tr>
                        <td>Gadu-gadu:</td>
                        <td><form:input path="gaduGadu"/></td>
                        <td><form:errors path="gaduGadu"/></td>
                </tr>
                <td colspan="2">
                        <input type="submit" value="Zmień dane kontaktowe"/>
                </td>
        </table>
</form:form>
</body>
</html>
