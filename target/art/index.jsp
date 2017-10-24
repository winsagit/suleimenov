<%@ page import="java.util.ArrayList" %>
<%@ page import="mainservlet.Phone" %>
<%@ page import="mainservlet.models.PhoneModel" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Telephones</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="./css/uikit.almost-flat.min.css" />
    <link rel="stylesheet" href="./css/font-awesome.min.css">
    <link rel="stylesheet" href="./css/style.css" />
</head>
<body>
<nav id="menu" class="uk-navbar">
    <span class="uk-navbar-brand" href="#">Справочник</span>
    <menu class="uk-navbar-nav">
        <li class="uk-navbar-content">
            <form class="uk-form uk-display-inline-block">
                <input id="query" type="text" placeholder="ФИО"/>
            </form>
        </li>
        <li class="uk-navbar-content">
            <form class="uk-form uk-display-inline-block">
                <input id="query" type="text" placeholder="Телефон">
            </form>
        </li>
        <li class="uk-navbar-content">
            <form class="uk-form uk-display-inline-block">
                <input id="query" type="text" placeholder="Адрес">
            </form>
        </li>
        <li style="top: 7px;">
        <button>Найти</button>
        <button>Добавить</button>
        </li>
    </menu>
</nav>
<table cellpadding="0" cellspacing="0" border="0" id="table" class="uk-table">
    <thead>
    <tr>
        <th><h3>ФИО</h3></th>
        <th><h3>Телефон</h3></th>
        <th><h3>Aдрес</h3></th>
    </tr>
    </thead>
    <tbody>
        <%  PhoneModel phoneModel = new PhoneModel();
            ArrayList<Phone> phones = phoneModel.getAllPhones();
            for(int i = 0; i < phones.size(); i++) { %>
<tr>
    <td><%=phones.get(i).getName() %></td>
    <td><%=phones.get(i).getPhone() %></td>
    <td><%=phones.get(i).getAdress() %></td>
</tr>
        <% } %>
    </tbody>
</table>

</body>
</html>