<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
        <title>Zaloguj się</title>
</head>
<body>
<div id="login">
        <c:if test="${not empty error}">
                <div style="color: #F00;">${error}</div>
                <hr/>
        </c:if>
        <c:if test="${not empty msg}">
                <div style="color: #2C6700;">${msg}</div>
                <hr/>
        </c:if>
        <form action="<c:url value='/login_perform' />" method="POST">
                <table>
                        <tr>
                                <td>Email:</td>
                                <td><input type="text" name="email"/></td>
                        </tr>
                        <tr>
                                <td>Hasło:</td>
                                <td><input type="password" name="password"/></td>
                        </tr>
                        <tr>
                                <td colspan="2"><input type="checkbox" name="_spring_security_remember_me"/> zapmiętaj
                                        mnie
                                </td>
                        </tr>
                        <tr>
                                <td colspan='2'><input name="submit" type="submit"
                                                       value="Login"/></td>
                        </tr>
                </table>
        </form>
</div>
</body>
</html>
