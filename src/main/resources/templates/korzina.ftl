<#import "parts/common.ftl" as c>
<@c.page>
</@c.page>

<div class="content">
<h6>Корзина: </h6>
    <form method="post">
<table>

  <#list products as product>
     <tr>
         <td>${product.getProduct().getName()}</td>
         <td>${product.getPrice()} грн</td>
         <td><input type="number" name="kolvo" value="${product.getKolvo()}"></td>
         <td><input type="submit" name="next" value="Изменить" /></td>
         <td> <input type="submit" name="next" value="Удалить" /></td>

         <input type="hidden" value="${product.getProduct().getId()}" name="productId">
         <input type="hidden" value="${_csrf.token}" name="_csrf">
     </tr>

  </#list>

</table>


    </form>
<form method="get" action="/korzina/2">
    <a href="/">Назад</a>
    <button type="submit" name="next">Продолжить</button>

</form>




</div>