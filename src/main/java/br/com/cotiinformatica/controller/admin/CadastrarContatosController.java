package br.com.cotiinformatica.controller.admin;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Contato;
import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.enums.TipoContato;
import br.com.cotiinformatica.repositories.ContatoRepository;

@Controller
public class CadastrarContatosController {

	@RequestMapping(value = "/admin/cadastrarcontatos")
	public ModelAndView cadastrarContatos() {

		ModelAndView modelAndView = new ModelAndView("admin/cadastrarcontatos");
		return modelAndView;
	}
	
	@RequestMapping(value = "/admin/cadastrar-contato", method = RequestMethod.POST)
	public ModelAndView cadastrarContato(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("admin/cadastrarcontatos");
		
		try {
			
			//capturar os campos enviados pelo formulário
			Contato contato = new Contato();
			
			contato.setNome(request.getParameter("nome"));
			contato.setEmail(request.getParameter("email"));
			contato.setTelefone(request.getParameter("telefone"));
			contato.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("datanascimento")));
			
			Integer tipo = Integer.parseInt(request.getParameter("tipo"));
			switch(tipo) {
			case 1: contato.setTipo(TipoContato.FAMILIA); break;
			case 2: contato.setTipo(TipoContato.AMIGOS); break;
			case 3: contato.setTipo(TipoContato.TRABALHO); break;
			case 4: contato.setTipo(TipoContato.OUTROS); break;
			}
			
			//capturar o usuário autenticado na sessão
			Usuario usuario = (Usuario) request.getSession().getAttribute("auth_usuario");
			contato.setUsuario(usuario);
			
			//gravar o contato no banco de dados
			ContatoRepository contatoRepository = new ContatoRepository();
			contatoRepository.create(contato);
			
			modelAndView.addObject("mensagem", "Contato " + contato.getNome() + ", cadastrado com sucesso!");
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem", "Falha ao cadastrar contato: " + e.getMessage());
		}
		
		return modelAndView;
	}

}
