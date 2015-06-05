<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <title>Wyślij wiadomość</title>
    <style type="text/css">

    </style>
    <script type="application/javascript" src="<c:url value="/resources/jquery-1.11.2.min.js" />"></script>
    <script type="application/javascript" src="<c:url value="/resources/jquery.form.js" />"></script>
    <script type="application/javascript">
        $(function () {

        });
    </script>
</head>
<a>
    <a href="<c:url value="/message/list" />">Wróć</a><br/><br/>

    <div>
        <table>
            <tr>
                <td>
                    Temat:
                </td>
                <td>
                    ${message.subject}
                </td>
            <tr>
                <td>
                    Od:
                </td>
                <td>
                    ${message.sender}
                </td>
            </tr>
            <tr>
                <td>
                    Treść:
                </td>
                <td>
                    ${message.content}
                </td>
            </tr>
        </table>
    </div>
    <br/>

    </body>
</html>
