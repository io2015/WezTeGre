<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
<head>
    <title>Lista wiadomości</title>
    <style type="text/css">

    </style>
    <script type="application/javascript" src="<c:url value="/resources/jquery-1.11.2.min.js" />"></script>
    <script type="application/javascript" src="<c:url value="/resources/jquery.form.js" />"></script>
    <script type="application/javascript">
        $(function () {
            var contextUrl = "<c:url value='/advertisement/' />";
        });
    </script>
</head>
<a>
    <a href="<c:url value="/" />">Wróć</a> <a href="<c:url value="/message/add" />">Wyślij nową</a>
    <br/>
    <br/>

    <table id="messages">
        <tr>
            <th>
                Temat
            </th>
            <th>
                Od
            </th>
            <th>
                Data
            </th>
            <th>
                Czas
            </th>
        </tr>
        <c:forEach items="${messages}" var="item">
            <tr>
                <td>
                    <a href="<c:url value="/message/${item.id}" />">${item.subject}</a>
                </td>
                <td>
                    ${item.sender}
                </td>
                <td>
                    ${item.date}
                </td>
                <td>
                    ${item.time}
                </td>
            </tr>
        </c:forEach>
    </table>
    </body>
</html>
