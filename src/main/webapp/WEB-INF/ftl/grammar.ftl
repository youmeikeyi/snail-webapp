<#-- validate user exist  -->
<h1>Welcome ${user!"Anoymous"}!</h1>

<#if user??><h1>Welcome Anoymous!</h1></#if>

<#if (animals.python.price)?? ></#if>
<#-- same as above -->
<#if animals.python.price?? ></#if>
