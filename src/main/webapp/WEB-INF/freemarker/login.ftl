<html lang="en-US">
<head>
    <meta charset="UTF-8">
    <title>登录界面</title>
</head>
<body>
<p> 欢迎光临本网站</p>
<form method="post" action="${base}/user/info" enctype="multipart/form-data">
    ${msg!}<br>
    用户名：<input type="text" name="userName"><br>
    密码：<input type="password" name="passWord"><br>
    <#--判断是否是从登录页过来-->
     <input type="hidden" name="isLogin" VALUE="isLogin"><br>
     <input type="submit" value="登录">
</form>
</body>
</html>