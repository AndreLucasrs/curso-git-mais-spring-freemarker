<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<head>
	<meta charset="UTF-8" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=device-width" />
	<title>Posts</title>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"></link>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading">
			<strong>Posts</strong>
		</div>
		<div class="panel-body">
			<div class="table-responsive">
				<table class="table table-sm table-striped table-hover table-bordered">
					<thead>
						<tr>
							<th>Autor</th>
							<th>T&iacute;tulo</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<#list posts as post>
							<tr>
								<td>${post.autor}</td>
								<td>${post.titulo}</td>
								<td>
									<div class="btn-group pull-right">
							   			<a href="<@spring.url '/editar/${post.id}'/>" class="btn btn-sm btn-primary" value="${post.id}">Editar</a>
							   			<a href="<@spring.url '/postList/${post.id}'/>" class="delete btn btn-sm btn-danger" value="${post.id}">Excluir</a>
							   		</div>
								</td>
							</tr>
						</#list>
					</tbody>
				</table>
			</div>
		</div>
		<div class="panel-footer">
			<a class="btn btn-sm btn-warning" href="<@spring.url '/'/>" >Voltar</a>
			<a class="btn btn-sm btn-success" href="<@spring.url '/add/'/>" >Adicionar</a>
		</div>
	</div>
</body>
</html>