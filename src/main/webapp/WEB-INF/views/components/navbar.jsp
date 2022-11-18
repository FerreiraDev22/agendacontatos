<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Agenda de Contatos</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/projetoweb01/admin/dashboard">Dashboard</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/projetoweb01/admin/minhaconta">Minha conta</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Gerenciar Contatos
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/projetoweb01/admin/cadastrarcontatos">Cadastrar Contatos</a></li>
            <li><a class="dropdown-item" href="/projetoweb01/admin/consultarcontatos">Consultar Contatos</a></li>
          </ul>
        </li>
      </ul>
      
      <div class="d-flex">
		<div class="text-white">
				
		<strong>${auth_usuario.nome}</strong> (${auth_usuario.email})					
		&nbsp;&nbsp;
					
		<a href="/projetoweb01/logout" class="btn btn-outline-light btn-sm"
			onclick="return confirm('Deseja realmente sair da agenda?');">
			Sair da Agenda 
		</a>
					
		</div>
	 </div>
      
    </div>
  </div>
</nav>


