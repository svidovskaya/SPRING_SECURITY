<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>

    Список пользователей
<div>
    <span><a href="/registration">Создать нового пользователя</a></span>

</div>

    <table>
        <thead>
        <tr>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Отчество</th>
            <th>Номер телефона</th>
            <th>Роль</th>

            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.surname}</td>
                <td>${user.name}</td>
                <td>${user.middlename}</td>
                <td>${user.phone}</td>

                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td><a href="/user/${user.id}">edit</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>