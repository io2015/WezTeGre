<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <title>Lista gier</title>
    <style type="text/css">
        .checkboxes {
            border: 1px solid #ccc;
            width: 300px;
            height: 100px;
            overflow-y: scroll;
        }
    </style>
    <script type="application/javascript" src="<c:url value="/resources/jquery-1.11.2.min.js" />"></script>
    <script type="application/javascript" src="<c:url value="/resources/jquery.form.js" />"></script>
    <script type="application/javascript">
        $(function () {
            var contextUrl = "<c:url value='/advertisement/' />";

            function addAvertisement(id, title, description, game) {
                var toAdd = "<div>" + "Tytuł: <a href='" + contextUrl + id + "'>" + title + "</a> <br/>";
                toAdd += "Opis: " + description + "<br />";
                toAdd += "Opis: " + game + "<br/><br/></div>";

                console.log(toAdd);
                $("div#advertisements").append(toAdd);
            };

            $("button[name='find']").click(function () {
                var toSend = {
                    find: "",
                    inTitle: false,
                    inDescription: false
                };

                toSend.find = $("input[name='find'][type='text']").val();
                toSend.inDescription = $("input[name='inDescription'][type='checkbox']").is(":checked");
                toSend.inTitle = $("input[name='inTitle'][type='checkbox']").is(":checked");

                $.ajax({
                    url: "<c:url value="/advertisement/list/filter" />",
                    data: JSON.stringify(toSend),
                    type: "POST",
                    beforeSend: function (xhr) {
                        xhr.setRequestHeader("Accept", "application/json");
                        xhr.setRequestHeader("Content-Type", "application/json");
                    },
                    success: function (result) {
                        console.log(result);

                        $("div#advertisements div").remove();
                        $(result).each(function (index, value) {
                            addAvertisement(value.id, value.title, value.content, value.game.name);
                        });
                    }
                });
            });
        });
    </script>
</head>
<a>
    <a href="<c:url value="/signup" />">Zarejestruj się</a>
    <a href="<c:url value="/login" />">Zaloguj się</a>
    <a href="<c:url value="/advertisement/add" />">Dodaj ogłoszenie</a>
    <a href="<c:url value="/message/list" />">Wiadomości</a><br/><br/>

    <div id="find">
        <div>
            <table>
                <tr>
                    <td>
                        Szukaj:
                    </td>
                    <td>
                        <input type="text" name="find"/>
                    </td>
                    <td>
                        <input type="checkbox" name="inDescription"/> szukaj w opisach
                    </td>
                    <td>
                        <input type="checkbox" name="inTitle"/> szukaj w tytułach oferowanych gier
                    </td>
                    <td>
                        <button type="button" name="find">Szukaj</button>
                    </td>
                </tr>
            </table>
        </div>
    </div>
    <br/>

    <div id="advertisements">
        <div>
            <c:forEach items="${advertisements}" var="item">
                Tytuł: <a href="<c:url value="/advertisement/${item.id}" />">${item.title}</a> <br/>
                Opis: ${item.content} <br/>
                Gra: ${item.game.name} <br/><br/>
            </c:forEach>
        </div>
    </div>
    </body>
</html>
