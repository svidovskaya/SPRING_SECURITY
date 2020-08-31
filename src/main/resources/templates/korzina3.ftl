<#import "parts/common.ftl" as c>
<@c.page>
</@c.page>

<div class="content">
<h6>Данные: </h6>
    <form method="post">
        <table>
            <tr>
                <td>Фамилия: </td><td>${danni.getUser().getUserInfo().getSurname()}</td>
            </tr>
            <tr>
                <td>Имя: </td><td>${danni.getUser().getUserInfo().getName()}</td>
            </tr>
            <tr>
                <td>Отчество: </td><td>${danni.getUser().getUserInfo().getMiddlename()}</td>
            </tr>
            <tr>
                <td>Почта: </td><td>${danni.getUser().getEmail()}</td>
            </tr>
            <tr>
                <td>Номер телефона: </td><td>${danni.getUser().getUserInfo().getPhone()}</td>
            </tr>
            <tr>
                <td>Доставка: ${danni.getOrderInfo().getDostavka_method()}</td><td>${danni.getOrderInfo().getDostavka_adr()}</td>
            </tr>
            <tr>
                <td>Метод оплаты: </td>
                <td> ${danni.getOrderInfo().getOpl_method()}</td>
            </tr>
            <tr><td><input type="hidden" value="${_csrf.token}" name="_csrf"></td>
            </tr>


        </table>
        <h6>Товары: </h6>
        <table border="1px">
            <#list orderProducts as op>
                <tr>
                    <td>${op.getProduct().getName()}</td>
                    <td>${op.getKolvo()} шт</td>
                    <td>${op.getPrice()} грн</td>
                    <td>
                    ${(op.getKolvo() * op.getPrice())} грн
                    </td>
                </tr>
            </#list>
        </table>

        <#list orderProducts as op>
            <h6>Сумма заказа: ${op.getOrder().getOrdr_summa()} грн</h6>
            <#break>
        </#list>

        <button type="submit" name="next">Продолжить</button>
    </form>

</div>