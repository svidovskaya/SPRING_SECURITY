<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>


<@c.page>
</@c.page>
    <form action="/newProd" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>Штрих-код</td><td><input type="number"  name="shtrih"  required/></td>
            </tr>
            <tr>
                <td>Код</td><td><input type="number"  name="kode"  required/></td>
            </tr>
            <tr>
                <td>Название</td><td><input type="text"  name="name"  required/></td>
            </tr>
            <tr>
                <td>Описание1</td><td><input type="text"  name="discript" /></td>
            </tr>
            <tr>
                <td>Описание2</td><td><input type="text"  name="discription" /></td>
            </tr>
            <tr>
                <td>Цена </td><td><input type="number"  name="price" /></td>
            </tr>
            <tr>
                <td>Производитель: </td><td>    <select name="manufacturer">
                        <#list manufacturers as manufacturer>

                            <option value="${manufacturer.id}"${manufacturer.manuf_name}</option>${manufacturer.manuf_name}

                        </#list>
                    </select></td>
            </tr>
            <tr>
                <td>Категория: </td><td>    <select name="dop_category">
                        <#list dop_category as dop_cat>

                            <option value="${dop_cat.id}"${dop_cat.name}</option>${dop_cat.name}

                        </#list>
                    </select></td>
            </tr>
            <tr><td><input type="file" name="file"></td><td></td></tr>
            <tr><td>  <input type="hidden" name="_csrf" value="${_csrf.token}" /></td><td><input type="submit" value="Создать"/></td></tr>
        </table>



    </form>
