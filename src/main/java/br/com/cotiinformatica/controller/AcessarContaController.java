package br.com.cotiinformatica.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.repositories.UsuarioRepository;

@Controller
public class AcessarContaController {

	// m�todo para mapear qual � a p�gina que o controlador
	// ir� abrir / gerenciar no projeto
	@RequestMapping(value = "/") // p�gina raiz do projeto
	public ModelAndView acessarConta() {

		// definir qual � a p�gina que ser� acessada pelo controlador
		// WEB-INF/views/acessarconta.jsp
		ModelAndView modelAndView = new ModelAndView("acessarconta");
		return modelAndView;
	}
	
	// m�todo para capturar a requisi��o SUBMIT do formul�rio
	@RequestMapping(value = "/autenticar_usuario", method = RequestMethod.POST)
	public ModelAndView autenticarUsuario(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("acessarconta");
		
		try {
			
			//capturar os campos enviados pelo formul�rio
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			//consultando o usu�rio no banco de dados atraves do email e da senha
			UsuarioRepository usuarioRepository = new UsuarioRepository();
			Usuario usuario = usuarioRepository.findByEmailAndSenha(email, senha);
			
			//verificar se o usu�rio foi encontrado
			if(usuario != null) {
				
				//salvar os dados do usu�rio em uma sess�o
				request.getSession().setAttribute("auth_usuario", usuario);
				
				//redirecionar o usu�rio para a p�gina inicial da agenda
				modelAndView.setViewName("redirect:admin/dashboard");
			}
			else {
				modelAndView.addObject("mensagem", "Acesso Negado, usu�rio in�lido.");
			}
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem", "Falha ao autenticar: " + e.getMessage());
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request) {
		
		//apagar os dados do usu�rio que foram gravados em sess�o
		request.getSession().removeAttribute("auth_usuario");
		
		//redirecionar para a p�gina de login (/acessarconta)
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/");
		
		return modelAndView;
	}
	
}














