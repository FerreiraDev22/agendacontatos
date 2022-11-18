package br.com.cotiinformatica.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Contato;
import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.repositories.ContatoRepository;

@Controller
public class ConsultarContatosController {

	@RequestMapping(value = "/admin/consultarcontatos")
	public ModelAndView consultarContatos(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("admin/consultarcontatos");
		
		try {
			
			//capturar o usuário autenticado na sessão
			Usuario usuario = (Usuario) request.getSession().getAttribute("auth_usuario");
			
			//consultando os contatos do usuário no banco de dados
			ContatoRepository contatoRepository = new ContatoRepository();
			List<Contato> contatos = contatoRepository.findByUsuario(usuario.getIdUsuario());
			
			//enviando a lista para a página..
			modelAndView.addObject("contatos", contatos);
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem", "Falha ao consulta contatos: " + e.getMessage());
		}
		
		return modelAndView;
	}
	
}
