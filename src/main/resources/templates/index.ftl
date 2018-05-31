<#import "/spring.ftl" as spring/>
 
<!DOCTYPE HTML>
<html>
   <head>
   		<meta charset="UTF-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta name="viewport" content="width=device-width" />
		<title>Posts</title>
		<link rel="stylesheet" type="text/css" href="<@spring.url '/css/style.css'/>"/>
		<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"></link>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   </head>
    
   <body>
      <h1>CRUD</h1>
      <h2>Sistema feito para testa freemarker e hibernate envers</h2>
      <p>Person List, apenas adiciona e Lista pessoas, guardando apenas em memoria.</p>
      <p>Post List, CRUD completa usando o banco de dados.</h2>    
      <br/><br/>
      <a href="<@spring.url '/personList'/>" class="btn btn-sm btn-info">Person List</a>  
      <a href="<@spring.url '/postList'/>" class="btn btn-sm btn-primary">Post List</a>
       
   </body>
    
</html>