package br.com.EduAcao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.EduAcao.model.Doador;
import br.com.EduAcao.model.UF;
import br.com.EduAcao.repositorios.DoadorRepositorio;
import br.com.EduAcao.utils.SenhaUtils;







@Controller
@RequestMapping("/doador")
public class DoadorController {

	  @Autowired
	    private DoadorRepositorio doadorRepositorio;

	    @GetMapping
	    public ModelAndView home() {
	        ModelAndView modelAndView = new ModelAndView("cliente/home");

	        modelAndView.addObject("doadores", doadorRepositorio.findAll());

	        return modelAndView;
	    }
	    
	    @GetMapping("/home")
	    public ModelAndView List() {
	        ModelAndView modelAndView = new ModelAndView("doador/home");
	        
	        modelAndView.addObject("doadors", doadorRepositorio.findAll());

	        return modelAndView;
	    }

	    @GetMapping("/{id}")
	    public ModelAndView detalhes(@PathVariable Long id) {
	        ModelAndView modelAndView = new ModelAndView("doador/detalhes");

	        modelAndView.addObject("doador", doadorRepositorio.getOne(id));

	        return modelAndView;
	    }

	    @GetMapping("/cadastrar")
	    public ModelAndView cadastrar() {
	        ModelAndView modelAndView = new ModelAndView("doador/formulario");

	        modelAndView.addObject("doador", new Doador());
	        modelAndView.addObject("ufs", UF.values());

	        return modelAndView;
	    }

	    @GetMapping("/{id}/editar")
	    public ModelAndView editar(@PathVariable Long id) {
	        ModelAndView modelAndView = new ModelAndView("doador/formulario");

	        modelAndView.addObject("doador", doadorRepositorio.getOne(id));
	        modelAndView.addObject("ufs", UF.values());

	        return modelAndView;
	    }

	    @PostMapping("/cadastrar")
	    public String cadastrar(Doador doador) {
	        String senhaEncriptada = SenhaUtils.encode(doador.getSenha());

	        doador.setSenha(senhaEncriptada);
	        doadorRepositorio.save(doador);

	        return "redirect:/doadors";
	    }

	    @PostMapping("/{id}/editar")
	    public String editar(Doador doador, @PathVariable Long id) {
	        String senhaAtual = doadorRepositorio.getOne(id).getSenha();
	        doador.setSenha(senhaAtual);

	        doadorRepositorio.save(doador);

	        return "redirect:/doadors";
	    }

	    @GetMapping("/{id}/excluir")
	    public String excluir(@PathVariable Long id) {
	        doadorRepositorio.deleteById(id);

	        return "redirect:/doadores";
	    }
	
	    }
	    
