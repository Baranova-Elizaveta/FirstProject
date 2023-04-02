<%@ page pageEncoding="UTF-8" isELIgnored="false" %>
<?php
setcookie("logon","",time()-113600, "/");
header("location: /");
?>