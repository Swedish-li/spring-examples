<#ftl encoding='UTF-8'>
<#import "spring.ftl" as spring />

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h1>Hello ${val}!</h1>

<h2>${nowDate?date}</h2>
<h2>${nowDate?datetime}</h2>
<h2>${nowDate?time}</h2>

<@spring.message 'greeting'/>
<hr>
<@spring.messageArgs 'userinfo', ['Jack',18,'1/1'] />
<h1>上海</h1>
</body>
</html>