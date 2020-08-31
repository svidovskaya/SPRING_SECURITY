<#macro login path>
    <form action="/login" method="post" style="margin-left: 5%; margin-right: 5%">
        <table>
            <tr>
                <td>Логин: </td>
                <td><input type="text" name="username"/></td>
            </tr>
            <tr>
                <td>Пароль: </td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td><input type="hidden" name="_csrf" value="${_csrf.token}" /></td>
                <td><input type="submit" value="Sign In"/></td>
            </tr>
        </table>

    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="submit" value="Sign Out"/>
    </form>
</#macro>