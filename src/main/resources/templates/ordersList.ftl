<#import "parts/common.ftl" as c>
<@c.page>
</@c.page>

<div class="content">
<h6>Заказы: </h6>
    <form method="get">

<table border="2px">
    <tr>
        <td>Номер заказа </td>
        <td>Сумма заказа /грн</td>
        <td>Статус</td>
        <td>Просмотр</td>
    </tr>
    <#list orders as order>
        <tr>
            <td>${order.getOrderid()}</td>
            <td>${order.getOrdr_summa()}</td>
            <td>${order.getOrdr_st()} </td>
            <td><a href="/myAccount/orders/${order.getOrderid()}">Просмотр</a></td>
        </tr>
    </#list>
<#--    <#list orders as order>-->
<#--        <tr>-->
<#--            <td>${order.getOrderid()}</td>-->
<#--            <td>${order.getOrdr_summa()} грн</td>-->
<#--            <td>${order.getOrdr_st()} </td>-->

<#--            <td><a href="/myAccount/orders/${order.getOrderid()}">Просмотр</a></td>-->
<#--        </tr>-->


<#--    </#list>-->
</table>



    </form>

</div>