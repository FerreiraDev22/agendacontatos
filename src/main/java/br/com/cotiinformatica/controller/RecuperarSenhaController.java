package br.com.cotiinformatica.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.github.javafaker.Faker;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.messages.EmailMessage;
import br.com.cotiinformatica.repositories.UsuarioRepository;

@Controller
public class RecuperarSenhaController {

	@RequestMapping(value = "/recuperarsenha") // URL da página
	public ModelAndView recuperarSenha() {

		// WEB-INF/views/recuperarsenha.jsp
		ModelAndView modelAndView = new ModelAndView("recuperarsenha");
		return modelAndView;
	}
	
	@RequestMapping(value = "recuperar-senha", method = RequestMethod.POST)
	public ModelAndView recuperarSenha(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("recuperarsenha");
		
		try {
			
			//capturar o conteudo do campo email enviado para o controlador
			String email = request.getParameter("email");
			
			//consultar o usuário no banco de dados através do email
			UsuarioRepository usuarioRepository = new UsuarioRepository();
			Usuario usuario = usuarioRepository.findByEmail(email);
			
			//verificar se o usuário foi encontrado
			if(usuario != null) {

				//gerar uma nova senha para o usuário
				Faker faker = new Faker();
				String novaSenha = faker.internet().password(8, 10);
				
				//escrevendo o email
				String assunto = "Recuperação de senha de acesso - Agenda de Contatos";
				String mensagem = "Olá, " + usuario.getNome()
								+ "\n\nUma nova senha de acesso foi gerada com sucesso."
								+ "\nUtilize a senha: " + novaSenha
								+ "\nAcesse o sistema com esta senha e depois se preferir vá no menu 'Minha Conta' e altere a senha."
								+ "\n\nAtt"
								+ "\nEquipe Agenda de Contatos";
				
				//enviando o email
				EmailMessage emailMessage = new EmailMessage();
				emailMessage.send(usuario.getEmail(), assunto, mensagem);
				
				//atualizando a senha do usuário no banco de dados
				usuarioRepository.update(usuario.getIdUsuario(), novaSenha);
				
				modelAndView.addObject("mensagem", "Foi gerado uma nova senha e enviado com sucesso para o email: " + usuario.getEmail());
			}
			else {
				modelAndView.addObject("mensagem", "Usuário não encontrado. Verifique o email informado.");
			}
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem", "Falha ao recuperar senha: " + e.getMessage());
		}
		
		return modelAndView;
	}
}


