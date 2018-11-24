<%@ page language="java" pageEncoding="utf-8" isELIgnored="false" %>
<html>
<body>
<h2>添加图书页面</h2>
<form action="addBook" method="post">
    图书名称：<input name="book.bookname"/>
    图书作者：<input name="book.bookauthor"/>
    图书价格：<input name="book.bookprice"/>
    <input type="submit" value="添加"/>
</form>
</body>
</html>
