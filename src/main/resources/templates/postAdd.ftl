<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<head>
	<meta charset="UTF-8" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=device-width" />
	<title>Cadastro de Posts</title>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"></link>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading">
			<strong>Cadastro de Posts</strong>
		</div>
		<div class="panel-body">
			<form name="postForm" action="" method="POST" class="form-horizontal" style="margin: 10px">
               Autor: <@spring.formInput "postForm.autor" "" "text"/>    <br/><br/>
               Titulo: <@spring.formInput "postForm.titulo" "" "text"/>    <br/><br/>
               <div class="form-group row">
					<a href="<@spring.url '/postList'/>" class="btn btn-sm btn-warning">Voltar</a>
					<button type="submit" class="btn btn-sm btn-info">Salvar</button>  
				</div>
            </form>
		</div>
	</div>
</body>
</html>