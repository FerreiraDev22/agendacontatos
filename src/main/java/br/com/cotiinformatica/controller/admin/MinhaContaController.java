package br.com.cotiinformatica.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.repositories.UsuarioRepository;

@Controller
public class MinhaContaController {

	// m�todo para gerar a rota de navega�ao da
	// p�gina: /WEB-INF/views/admin/minhaconta.jsp
	@RequestMapping(value = "/admin/minhaconta")
	public ModelAndView minhaConta() {

		ModelAndView modelAndView = new ModelAndView("admin/minhaconta");
		return modelAndView;
	}
	
	//m�todo para capturar o submit (POST) do formul�rio
	@RequestMapping(value = "/admin/atualizar_senha", method = RequestMethod.POST)
	public ModelAndView atualizarSenha(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("admin/minhaconta");
		
		try {
			
			//capturar a nova senha enviada pelo formul�rio
			String novaSenha = request.getParameter("novaSenha");			
			//capturando o usu�rio salvo na sess�o
			Usuario usuario = (Usuario) request.getSession().getAttribute("auth_usuario");
			
			//atualizar a senha no banco de dados
			UsuarioRepository usuarioRepository = new UsuarioRepository();
			usuarioRepository.update(usuario.getIdUsuario(), novaSenha);
			
			modelAndView.addObject("mensagem", "Sua senha foi atualizada com sucesso.");
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem", "Falha ao atualizar senha: " + e.getMessage());
		}
		
		return modelAndView;		
	}

}
