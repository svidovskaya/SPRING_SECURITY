<#include "security.ftl" >



<nav class="navbar navbar-expand-lg navbar-light bg-light">

    <div class="collapse navbar-collapse" id="navbarSupportedContent">

        <ul class="navbar-nav mr-auto">


                    <li class="nav-item">
                    <a class="nav-link" href="/product">Продукты</a>
                </li>


            <#if r="ADMIN">
                <li class="nav-item">
                    <a class="nav-link" href="/user">Пользователи</a>
                </li>
            <#else>

            </#if>



        </ul>

    </div>
</nav>