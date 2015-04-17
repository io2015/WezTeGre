<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page session="false" %>
<!doctype html>
<html>
<head>
  <title>Dodaj ogłoszenie</title>
</head>
<body>
<form:form method="POST" modelAttribute="advertisementForm" action="/addAdvertisement">
  <table>
    <tr>
      <td>Tytuł:</td>
      <td><form:input path="title"/></td>
      <td><form:errors path="title"></form:errors></td>
    </tr>
    <tr>
      <td>Opis:</td>
      <td><form:input path="content"/></td>
      <td><form:errors path="content"></form:errors></td>
    </tr>
    <tr>
      <td>Stan:</td>
      <td><form:input path="state"/></td>
      <td><form:errors path="state" /></td>
    </tr>
    <tr>
      <td>Data:</td>
      <td><form:input path="addTime"/></td>
      <td><form:errors path="addTime" /></td>
    </tr>
    <tr>
      <td>Data zakończenia:</td>
      <td><form:password path="potencialEndTime"/></td>
      <td><form:errors path="potencialEndTime" /></td>
    </tr>
    <tr>
      <td>Czy jest w bazie:</td>
      <td><form:password path="nonexistentGame"/></td>
      <td><form:errors path="nonexistentGame" /></td>
    </tr>
    <tr>
      <td>Platformy:</td>
      <td><form:password path="platforms"/></td>
      <td><form:errors path="platforms" /></td>
    </tr>
    <tr>
      <td>Języki:</td>
      <td><form:input path="languages"/></td>
      <td><form:errors path="languages" /></td>
    </tr>
    <tr>
      <td>Dystrybucje:</td>
      <td><form:input path="distribution"/></td>
      <td><form:errors path="distribution" /></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Dodaj ogłoszenie"/>
      </td>
    </tr>
  </table>
</form:form>
</body>
</html>
