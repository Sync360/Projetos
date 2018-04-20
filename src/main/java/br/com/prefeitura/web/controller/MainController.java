package br.com.prefeitura.web.controller;

import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.prefeitura.web.model.CalendarioEventos;
import br.com.prefeitura.web.model.Noticia;
import br.com.prefeitura.web.service.CalendarioEventosService;
import br.com.prefeitura.web.service.NoticiaService;

@Controller
public class MainController {

	private static final Logger LOGGER = 
		      Logger.getLogger(MainController.class); 
	
	@Autowired
	private CalendarioEventosService calendarioEventosService;
	
	@Autowired
	private NoticiaService noticiaService;
	
	/***
	 * ESSE MÉTODO CARREGA A PÁGINA (index.html) DE LOGIN DA NOSSA APLICAÇÃO
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		
		return "index";
	}
	
	/***
	 * ESSE MÉTODO CARREGA A PÁGINA (index.html) DE LOGIN DA NOSSA APLICAÇÃO
	 * 
	 * @return
	 */
	@RequestMapping(value = "/acessoNegado2", method = RequestMethod.GET)
	public String index2() {
		return "acessoNegado2";
	}
	
	/***
	 * ESSE MÉTODO CARREGA A PÁGINA (index.html) DE LOGIN DA NOSSA APLICAÇÃO
	 * 
	 * @return
	 */
	@RequestMapping(value = "/paginaTeste", method = RequestMethod.GET)
	public String paginaTeste( Model model) {
		System.out.println(model);
		return "paginaTeste";
	}

	/***
	 * CARREGA À PÁGINA INICIAL DA APLICAÇÃO APÓS EFETUARMOS O LOGIN
	 * 
	 * @return
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) {

		LOGGER.info("[LOG-INFO] "+ MainController.class.getSimpleName()+" - HOME.");
		
		List<CalendarioEventos> eventos = this.calendarioEventosService.findallEvents();
		List<Noticia> noticias = this.noticiaService.findLastThreeNews();
		
		model.addAttribute("calendario", eventos);
		model.addAttribute("noticias", noticias);
//		model.addAttribute("oldNews", isOldNews);
		
		return "home";
	}
	
	/***
	 * CARREGA À PÁGINA NOTÍCIA
	 * 
	 * @return
	 */
	@RequestMapping(value = "/noticia", method = RequestMethod.GET)
	public String noticia() {

		return "noticia";
	}
	
	/***
	 * CARREGA À PÁGINA LICITAÇÃO.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/licitacao", method = RequestMethod.GET)
	public String licitacao(Locale locale) {
		LOGGER.info("essa é a linguagem" + locale);
		return "licitacao";
	}
	
	/***
	 * CARREGA À PÁGINA CONTRATOS.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/contratos", method = RequestMethod.GET)
	public String contratos(Locale locale) {
		LOGGER.info("essa é a linguagem" + locale);
		return "contratos";
	}

	/***
	 * MOSTRA UM PÁGINA COM A MENSAGEM DE ACESSO NEGADO QUANDO O USUÁRIO NÃO
	 * TIVER PERMISSÃO DE ACESSAR UMA DETERMINADA FUNÇÃO DO SISTEMA
	 * 
	 * @return
	 */
	@RequestMapping(value = "/acessoNegado", method = RequestMethod.GET)
	public String acessoNegado() {

		return "acessoNegado";
	}

}