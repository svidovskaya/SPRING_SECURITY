<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
</@c.page>
    <div>
        <span><a href="/newProd">Создать товар</a></span>

    </div>



    Список продукции
    <table border="1px">
        <thead>
        <tr>
            <th>Штрих-код</th>
            <th>Код</th>
            <th>Название</th>
            <th>Цена</th>
            <th>Производитель</th>

            <th>Просмотр</th>
            <th>Редактировать</th>
            <th>Удалить</th>



        </tr>
        </thead>
        <tbody>
        <#list products as product>
        <tr>
                                        <td>${product.getShtrih()}</td>
                                        <td>${product.getKode()}</td>
                                        <td>${product.getName()}</td>
                                        <td>${product.getPrice()}</td>
                                        <td>${product.getManufacturer().getManuf_name()}</td>

<#--                                        <td><#list product.getDop_categoriesSet() as category>${category.getCategory().getCategory_name()}<#sep>, </#list></td>-->

                                        <td><a href="/product/${product.getId()}">Просмотр</a></td>
            <td><a href="/product/${product.getId()}/edit">Изменить</a></td>
            <td><a href="/panel/${product.getId()}/delete">Удалить</a></td>


        </tr>
        </#list>
        </tbody>
    </table>


