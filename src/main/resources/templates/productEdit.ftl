<#import "parts/common.ftl" as c>

<@c.page>
    Prod editor

    <form action="/product" method="post">
        <input type="number" name="shtrih" value="${product.shtrih}">
        <input type="number" name="kode" value="${product.kode}">

        <input type="text" name="name" value="${product.name}">




        <#list manufacturers as manufacturer>
            <div>

                <label><input type="radio"  name="manufacturer" value="${manufacturer}" ${product.manufacturers?seq_contains(manufacturer)?string("checked", "")}>${manufacturer}</label>
            </div>
        </#list>
        <br>
        <#list categorys as category>
            <div>

                <label><input type="radio"  name="category" value="${category}" ${product.categorys?seq_contains(category)?string("checked", "")}>${category}</label>
            </div>
        </#list>

        <input type="hidden" value="${product.id}" name="prodId">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit">Save</button>
    </form>
</@c.page>

