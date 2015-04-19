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
      <td><form:select name="state" path="state" multiple="false">
          <form:option value="New">Nowa</form:option>
          <form:option value="UsedBad">Używana, słaba</form:option>
          <form:option value="UsedAverage">Używana, średnia</form:option>
          <form:option value="UsedGood">Używana, dobra</form:option>
            </form:select></td>
      <td><form:errors path="state" /></td>
    </tr>
    <tr>
      <td>Data:</td>
      <td><form:input type="date" path="addTime"/></td>
      <td><form:errors path="addTime" /></td>
    </tr>
    <tr>
      <td>Data zakończenia:</td>
      <td><form:input type="date" path="potencialEndTime"/></td>
      <td><form:errors path="potencialEndTime" /></td>
    </tr>
    <tr>
      <td>Czy jest w bazie:</td>
      <td><form:checkbox path="nonexistentGame" value="nonexistentGame"/></td>
      <td><form:errors path="nonexistentGame" /></td>
    </tr>
    <tr>
      <td>Platformy:</td>
      <td>
        <form:select name="platforms" path="platforms" multiple="false">
            <form:option value="pc">PC</form:option>
            <form:option value="ps">PS</form:option>
            <form:option value="xbox">Xbox</form:option>
        </form:select></td>
      <td><form:errors path="platforms" /></td>
    </tr>
    <tr>
      <td>Języki:</td>
      <td><form:select name="languages" path="languages" multiple="false">
          <form:option value="pl">PL</form:option>
          <form:option value="en">EN</form:option>
          <form:option value="de">DE</form:option>
      </form:select></td>
      <td><form:errors path="languages" /></td>
    </tr>
    <tr>
      <td>Dystrybucje:</td>
      <td><form:select name="distribution" path="distribution" multiple="false">
          <form:option value="rockstar">Rockstar</form:option>
          <form:option value="cenega">Cenega</form:option>
          <form:option value="ea">EA</form:option>
      </form:select></td>
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
