<#import "parts/common.ftl" as c>
<@c.page>
</@c.page>
<style>
    .navmenu{
        width: 100%;
        background-color: #7f7f7f;
    }
    .navmenu ul {
        list-style: none;
        margin: 0;
        padding: 0;
    }
    .navmenu a {
        display: block;
        text-decoration: none;
        outline: none;
        transition: .4s ease-in-out;
    }
    .topmenu {
        backface-visibility: hidden;
        background: rgba(255,255,255,.8);
    }
    .topmenu > li {
        display: inline-block;
        position: relative;
    }
    .topmenu > li > a {
        font-family: 'Exo 2', sans-serif;
        height: 10px;
        line-height: 70px;
        padding: 0 10px;
        font-weight: bold;
        color: #003559;
        text-transform: uppercase;
    }
    .down:after {
        content: "\f107";
        margin-left: 8px;
        font-family: FontAwesome;
    }
    .topmenu li a:hover { color: red; }
    .submenu {
        background: white;
        border: 2px solid #003559;
        position: absolute;
        left: 0;
        visibility: hidden;
        opacity: 0;
        z-index: 5;
        width: 150px;
        transform: perspective(600px) rotateX(-90deg);
        transform-origin: 0% 0%;
        transition: .6s ease-in-out;
    }
    .topmenu > li:hover .submenu{
        visibility: visible;
        opacity: 1;
        transform: perspective(600px) rotateX(0deg);
    }
    .submenu li a {
        color: #7f7f7f;
        font-size: 13px;
        line-height: 36px;
        padding: 0 25px;
        font-family: 'Kurale', serif;
    }
</style>
<nav class="navmenu">
    <ul class="topmenu">
        <#list categories as category>
            <li><a href="/${category.id}">${category.category_name}</a>
                <ul class="submenu">

                    <#list dopcategories as dopcategory>
                        <#if dopcategory.category.getCategory_name() == category.getCategory_name()>
                            <li><a href="">${dopcategory.name}</a></li>
                          </#if>
                    </#list>
                </ul>
            </li>

        </#list>

    </ul>
</nav>
<div class="filters" style="float: right; margin-right: 5%" >
    <form method="get" action="/">
<div class="filler_name">
    <h6>ПОИСК ПО ТОВАРАМ:</h6>
    <input type="text" name="filter">
</div>

        <div class="filter_brand_ch">



                <#list manufacturers as manufacturer>

                    <input type="checkbox" name="filter_manuf" value="${manufacturer.id}">${manufacturer.manuf_name}</input>
                </#list>

        </div>
        <div> <button type="submit" >Поиск</button></div>
    </form>
</div>
<#if finds_p == 0>
    <div class="products" style="overflow: hidden">
        <#list products as product>
            <form method="post" action="/add">
                <div class="product" style="float: left; width: 30%; height: 30% ">
                    <img src="/static/img_prod/${product.imgname}" width="30%" height="30%">
                    <p><a href="/product/${product.id}">${product.name}</a>  </p>
                    <h6>${product.price} грн</h6> <input type="number" name="kolvo" value="1" width="10px">
                    <input type="hidden" value="${product.id}" name="productId">
                    <input type="hidden" value="${_csrf.token}" name="_csrf">
                    <button type="submit" >В корзину</button>
                </div>
            </form>
        </#list>

    </div>
    <#else >
        <div class="products" style="overflow: hidden">
            <#list finds as find>
                <#list find.getProductsSet() as product>
                    <form method="post" action="/add">
                        <div class="product" style="float: left; width: 30%; height: 30% ">
                            <img src="/static/img_prod/${product.imgname}" width="30%" height="30%">
                            <p><a href="/product/${product.id}">${product.name}</a>  </p>
                            <h6>${product.price} грн</h6> <input type="number" name="kolvo" value="1" width="10px">
                            <input type="hidden" value="${product.id}" name="productId">
                            <input type="hidden" value="${_csrf.token}" name="_csrf">
                            <button type="submit" >В корзину</button>
                        </div>
                    </form>
                </#list>

            </#list>


        </div>
</#if>
