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

	// método para mapear qual é a página que o controlador
	// irá abrir / gerenciar no projeto
	@RequestMapping(value = "/") // página raiz do projeto
	public ModelAndView acessarConta() {

		// definir qual é a página que será acessada pelo controlador
		// WEB-INF/views/acessarconta.jsp
		ModelAndView modelAndView = new ModelAndView("acessarconta");
		return modelAndView;
	}
	
	// método para capturar a requisição SUBMIT do formulário
	@RequestMapping(value = "/autenticar_usuario", method = RequestMethod.POST)
	public ModelAndView autenticarUsuario(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("acessarconta");
		
		try {
			
			//capturar os campos enviados pelo formulário
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			//consultando o usuário no banco de dados atraves do email e da senha
			UsuarioRepository usuarioRepository = new UsuarioRepository();
			Usuario usuario = usuarioRepository.findByEmailAndSenha(email, senha);
			
			//verificar se o usuário foi encontrado
			if(usuario != null) {
				
				//salvar os dados do usuário em uma sessão
				request.getSession().setAttribute("auth_usuario", usuario);
				
				//redirecionar o usuário para a página inicial da agenda
				modelAndView.setViewName("redirect:admin/dashboard");
			}
			else {
				modelAndView.addObject("mensagem", "Acesso Negado, usuário inálido.");
			}
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem", "Falha ao autenticar: " + e.getMessage());
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request) {
		
		//apagar os dados do usuário que foram gravados em sessão
		request.getSession().removeAttribute("auth_usuario");
		
		//redirecionar para a página de login (/acessarconta)
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/");
		
		return modelAndView;
	}
	
}














