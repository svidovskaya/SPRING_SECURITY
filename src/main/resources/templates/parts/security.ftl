<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal

    <#--    r = "ADMIN"-->
    >

    <#list user.roles as role>
        <#assign r= role >
    </#list>

<#else>
    <#assign


    r="none"
    isAdmin = false
    >
</#if>