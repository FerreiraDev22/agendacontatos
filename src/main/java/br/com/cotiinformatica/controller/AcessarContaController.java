package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

}
