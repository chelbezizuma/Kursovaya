<!DOCTYPE html>
<html>
<head>
    <title>BUYSELL</title>
</head>
<body>
<h1>BUYSELL</h1><hr>
<h4>Подробная информация о товаре</h4>
<#list images as img>
    <img src="/images/${img.id}" height="60px"/><br><br>
</#list>
<b>Название товара: </b>${user.title}<br>
<b>Описание товара: </b>${user.description}<br>
<b>Цена: </b>${user.price}<br>
<b>Город: </b>${user.city}<br>
<b>Автор: </b>${user.author}<br>
<hr>
<form action="/user/delete/${user.id}" method="post">
    <input type="submit" value="Удалить товар"/>
</form>
</body>
</html>