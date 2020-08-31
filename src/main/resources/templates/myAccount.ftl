<#import "parts/common.ftl" as c>

<@c.page>
</@c.page>
<a href="/myAccount/orders">Мои заказы</a>
<form action="/myAccount" method="post">

    <table>
        <tr>
            <td>Фамилия: </td>
            <td> <input type="text" name="surname" value="${user.getUserInfo().getSurname()}"></td>
        </tr>
        <tr>
            <td>Имя: </td>
            <td><input type="text" name="name" value="${user.getUserInfo().getName()}"></td>
        </tr>
        <tr>
            <td>Отчество: </td>
            <td><input type="text" name="middlename" value="${user.getUserInfo().getMiddlename()}"></td>
        </tr>
        <tr>
            <td>Номер телефона: </td>
            <td><input type="number" name="phone" value="${user.getUserInfo().getPhone()}"></td>
        </tr>
        <tr>
            <td>Электронная почта:</td>
            <td><input type="email" name="email" value="${user.getEmail()}"></td>
        </tr>
        <tr>
            <td><input type="hidden" value="${user.getId()}" name="userId"></td>
            <td><input type="hidden" value="${_csrf.token}" name="_csrf"></td>
        </tr>
    </table>


    <button type="submit">Save</button>
</form>
