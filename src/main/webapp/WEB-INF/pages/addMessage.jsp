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
            var url = "<c:url value="" />";

            $("button[name='send']").click(function () {
                var dataForm = {
                    addressee: {
                        id: $("select option:selected").val()
                    },
                    subject: $("input[name='subject']").val(),
                    content: $("textarea[name='content']").val()
                };

                $.ajax({
                    type: "POST",
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    url: "<c:url value="/message/add" />",
                    data: JSON.stringify(dataForm),
                    dataType: "json",
                    success: function(result) {
                        if(result.redirect == null) {
                            $("table .error").remove();

                            if(result.subjectError != null)
                                $("table tr#subject").append("<td class='error'>" + result.subjectError + "</td>");

                            if(result.contentError != null)
                                $("table tr#content").append("<td class='error'>" + result.contentError + "</td>");
                        } else {
                            window.location.replace(url + "/" + result.redirect);
                        }
                    }
                })
            });
        });
    </script>
</head>
<a>
    <a href="<c:url value="/" />">Wróć</a><br/><br/>

    <div>
        <table>
            <tr>
                <td>
                    Wyślij do:
                </td>
                <td>
                    <select>
                        <c:forEach items="${users}" var="item">
                            <option value="${item.id}">${item.name} ${item.surname} (${item.email})</option>
                        </c:forEach>
                    </select>
                </td>
            <tr id="subject">
                <td>
                    Temat:
                </td>
                <td>
                    <input type="text" name="subject"/>
                </td>
            </tr>
            <tr id="content">
            <td>
                Treść:
            </td>
            <td>
                <textarea rows="4" cols="50" name="content"></textarea>
            </td>
            </tr>
            <td colspan="2">
                <button type="button" name="send">Wyślij</button>
            </td>
            </tr>
        </table>
    </div>
    <br/>

    </body>
</html>
