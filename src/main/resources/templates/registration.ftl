<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
</@c.page>
<form action="/registration" method="post" style="margin-right: 5%; margin-left: 5%">
    <table>
        <tr>
            <td>Логин : </td>
            <td><input type="text" name="username"required/></td>
        </tr>
        <tr>
            <td>Пароль : </td>
            <td><input type="password" name="password"required/></td>
        </tr>
        <tr>
            <td>Почта : </td>
            <td><input type="email" name="email" placeholder="some@some.com" required/></td>
        </tr>
        <tr>
            <td>Фамилия : </td>
            <td><input type="text" name="surname"required/></td>
        </tr>
        <tr>
            <td>Имя : </td>
            <td><input type="text" name="name"required/></td>
        </tr>
        <tr>
            <td>Отчество : </td>
            <td><input type="text" name="middlename"/></td>
        </tr>
        <tr>
            <td>Номер телефона : </td>
            <td><input type="number" name="phone"required/></td>
        </tr>
        <tr>
            <td> <input type="hidden" name="_csrf" value="${_csrf.token}" /></td>
            <td><input type="submit" value="Создать"/></td>
        </tr>
    </table>

</form>