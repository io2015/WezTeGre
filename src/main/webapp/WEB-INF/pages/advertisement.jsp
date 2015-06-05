<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="false" %>
<!doctype html>
<html>
<head>
        <title>Ogłoszenie ${advertisement.title}</title>

        <script type="application/javascript" src="<c:url value="/resources/jquery-1.11.2.min.js" />"></script>
        <script type="application/javascript" src="<c:url value="/resources/jquery.form.js" />"></script>
        <script type="application/javascript">
                $(function () {

                });
        </script>
</head>
<body>
        <a href="<c:url value="/advertisement/${id}/edit" />">Edytuj</a>
        <table>
                <tr>
                        <td>Tytuł:</td>
                        <td>${advertisement.title}</td>
                </tr>
                <tr>
                        <td>Opis:</td>
                        <td>${advertisement.content}</td>
                </tr>
                <tr>
                        <td>Gra:</td>
                        <td>${advertisement.game}</td>
                </tr>
                <tr>
                        <td>Stan:</td>
                        <td>${advertisement.state}</td>
                </tr>
                <tr>
                        <td>Platforma:</td>
                        <td>${advertisement.platform}</td>
                </tr>
                <tr>
                        <td>Język:</td>
                        <td>${advertisement.language}</td>
                </tr>
                <tr>
                        <td>Nośnik:</td>
                        <td>${advertisement.distribution}</td>
                </tr>
        </table>
        <hr />
        Poszukiwane gry:
        <table>
                <tr>
                        <td>Nazwa</td>
                        <td>Platforma</td>
                        <td>Język</td>
                        <td>Nośnik</td>
                        <td></td>
                </tr>

                        <c:forEach items="${advertisement.gamesForExchange}" var="item">
                        <tr>
                                <td>${item.game}</td>
                                <td>${item.platform}</td>
                                <td>${item.language}</td>
                                <td>${item.distribution}</td>
                        <tr>
                        </c:forEach>
        </table>
        <hr />

        <c:forEach items="${photos}" var="item">
                <img src="${item}" height="300" />
        </c:forEach>

</body>
</html>
