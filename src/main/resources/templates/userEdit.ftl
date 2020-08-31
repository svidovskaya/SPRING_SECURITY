<#import "parts/common.ftl" as c>

<@c.page>
    User editor

    <form action="/user" method="post">
        <div><label>Логин: </label>
        <input type="text" name="username" value="${user.username}"> </div>
        <div><label>Фамилия: </label>
            <input type="text" name="surname" value="${user.surname}"></div>
            <div><label>Имя: </label>

                <input type="text" name="name" value="${user.name}"></div>
                <div><label>Отчество: </label>
        <input type="text" name="middlename" value="${user.middlename}"></div>
                    <div><label>Номер телефона: </label>
        <input type="number" name="phone" value="${user.phone}"></div>


<div><label>Роль: </label></div>
        <#list roles as role>
            <div>
                <label>  <input type="checkbox"  name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
            </div>
        </#list>
        <input type="hidden" value="${user.id}" name="userId">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit">Save</button>
    </form>
</@c.page>