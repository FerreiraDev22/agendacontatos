package br.com.cotiinformatica.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.dtos.TipoQuantidadeDto;
import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.repositories.ContatoRepository;

@Controller
public class DashboardController {

	// m�todo para mapear a rota de navega��o
	// para a p�gina /admin/dashboard
	@RequestMapping(value = "/admin/dashboard")
	public ModelAndView dashboard(HttpServletRequest request) {

		// WEB-INF/views/admin/dashboard.jsp
		ModelAndView modelAndView = new ModelAndView("admin/dashboard");
		
		try {
			
			//capturar o usu�rio autenticado na sess�o
			Usuario usuario = (Usuario) request.getSession().getAttribute("auth_usuario");
			
			//Consultando a quantidade de contatos por tipo
			ContatoRepository contatoRepository = new ContatoRepository();
			List<TipoQuantidadeDto> dados = contatoRepository.countByTipo(usuario.getIdUsuario());
			
			//enviando a lista para a p�gina
			modelAndView.addObject("dados", dados);
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem", "Falha ao obter dados: " + e.getMessage());
		}
		
		return modelAndView;
	}
}



