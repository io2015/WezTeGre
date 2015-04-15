<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
  <title>Panel kontrolny</title>
</head>
<body>
Witaj <strong>${nick}</strong>!<br />
Co tam? <br />
Chcesz się <a href="<c:url value="/logout_perform" />">wylogować</a>?
</body>
</html>
