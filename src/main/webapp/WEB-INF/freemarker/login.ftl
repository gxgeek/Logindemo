<html lang="en-US">
<head>
    <meta charset="UTF-8">
    <title>登录界面</title>
</head>
<body>
<p> 欢迎光临本网站</p>
<form method="post" action="${base}/user/verification" enctype="multipart/form-data">
    ${RequestParameters["msg"]!}<br>
    用户名：<input type="text" name="userName"><br>
    密码：<input type="password" name="passWord"><br>
     <input type="submit" value="登录">
</form>
</body>
</html>