<#import "parts/common.ftl" as c>
<@c.page>
</@c.page>

<div class="content">
<h6>Введите данные: </h6>

<form method="post" action="/korzina/2">
    <table>
        <tr>
            <td>Фамилия: </td><td><input type="text" name="surname" value="${user.getUserInfo().getSurname()}"></td>
        </tr>
        <tr>
            <td>Имя: </td><td> <input type="text" name="name" value="${user.getUserInfo().getName()}"></td>
        </tr>
        <tr>
            <td>Отчество: </td><td><input type="text" name="middlename" value="${user.getUserInfo().getMiddlename()}"></td>
        </tr>
        <tr>
            <td>Почта: </td><td><input type="email" name="email" value="${user.getEmail()}"></td>
        </tr>
        <tr>
            <td>Номер телефона: </td><td>  <input type="number" name="phone" value="${user.getUserInfo().getPhone()}"></td>
        </tr>
        <tr>
            <td><select name="dostavka">
                    <option value="Самовывоз_Винница">Самовывоз Винница</option>
                    <option value="Курьер_Винница">Курьер Винница</option>
                    <option value="УкрПочта">УкрПочта</option>
                    <option value="НоваяПочта">Новая Почта</option>
                </select></td><td><input type="text" name="dostavka_adr" required></td>
        </tr>
        <tr>
            <td> <select name="oplata">
                    <option value="Безналичный_расчёт">Безналичный расчёт</option>
                    <option value="Наложенный_платёж">Наложенный платёж</option>
                    <option value="Оплата_наличными">Оплата наличными</option>
                </select></td>
        </tr>
        <tr><td><input type="hidden" value="${_csrf.token}" name="_csrf"></td>
       </tr>


    </table>









    <button type="submit" name="next">Продолжить</button>
    <a href="/">Назад</a>
</form>



</div>