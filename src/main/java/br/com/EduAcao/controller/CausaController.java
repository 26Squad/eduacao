package br.com.EduAcao.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.EduAcao.model.Administrador;
import br.com.EduAcao.model.Causa;
import br.com.EduAcao.model.Newsletter;
import br.com.EduAcao.model.UF;
import br.com.EduAcao.repositorios.CausaRepositorio;
import br.com.EduAcao.repositorios.NewsletterRepositorio;
import br.com.EduAcao.utils.SenhaUtils;



@Controller
@RequestMapping("/")
public class CausaController {

    @Autowired
    private CausaRepositorio causaRepositorio;
    
    @Autowired
    private NewsletterRepositorio newsletterRepositorio;
    
    @GetMapping
    public ModelAndView home(Newsletter newsletter) {
        ModelAndView modelAndView = new ModelAndView("/index");

        return modelAndView;
    }
 
 @GetMapping ("/cadastrar")
    public ModelAndView cadastrar(Causa causa, Newsletter newsletter) {
       ModelAndView modelAndView = new ModelAndView("/cadastrar");

      return modelAndView;
    }

 @GetMapping("/sobre")
    public ModelAndView sobre(Newsletter newsletter) {
        ModelAndView modelAndView = new ModelAndView("/sobre");


        return modelAndView;
    }
 
 @GetMapping("/causas")
   public ModelAndView causas(Newsletter newsletter) {
       ModelAndView modelAndView = new ModelAndView("/causas");


       return modelAndView;
   }
 
 @GetMapping("/causasDetalhes")
    public ModelAndView causasDetalhes(Newsletter newsletter) {
        ModelAndView modelAndView = new ModelAndView("/causasDetalhes");


        return modelAndView;
    }
 
 @GetMapping("/contato")
    public ModelAndView contato(Newsletter newsletter) {
        ModelAndView modelAndView = new ModelAndView("/contato");


        return modelAndView;
    }
 
 @GetMapping("/galeria")
    public ModelAndView promocoes(Newsletter newsletter) {
        ModelAndView modelAndView = new ModelAndView("/galeria");


        return modelAndView;
    }
 
 @GetMapping("/login")
    public ModelAndView login(Newsletter newsletter) {
        ModelAndView modelAndView = new ModelAndView("/login");


        return modelAndView;
 
 }

    @GetMapping("/{id}")
    public ModelAndView detalhes(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/causasDetalhes");

        modelAndView.addObject("Causa", causaRepositorio.getOne(id));

        return modelAndView;
    }

	/*
	 * @GetMapping("/cadastrar") public ModelAndView cadastrar() { ModelAndView
	 * modelAndView = new ModelAndView("/cadastrar");
	 * 
	 * modelAndView.addObject("Causa", new Causa()); modelAndView.addObject("ufs",
	 * UF.values());
	 * 
	 * return modelAndView; }
	 */
    

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/cadastrar");

        modelAndView.addObject("Causa", causaRepositorio.getOne(id));
        modelAndView.addObject("ufs", UF.values());

        return modelAndView;
    }
    
    @PostMapping("/")
    public String cadastrar( Newsletter newsletter) {
    	 ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("newsletter", new Newsletter());
        newsletterRepositorio.save(newsletter);

        return "redirect:/";
    }

    @PostMapping("/cadastrar")
	public ModelAndView cadastrarImagem(Causa causa, @RequestParam ("file") MultipartFile file) throws IOException {
    	String senhaEncriptada = SenhaUtils.encode(causa.getSenha());
    	
		try {
			causa.setImagem1(file.getBytes());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView("redirect:/causasDetalhes");
		
		modelAndView.addObject("causa", new Causa());
        modelAndView.addObject("ufs", UF.values());
		causa.setSenha(senhaEncriptada);
        causaRepositorio.save(causa);
		

		return modelAndView;
	}

    @PostMapping("/{id}/editar")
    public String editar(Causa causa, @PathVariable Long id) {
        String senhaAtual = causaRepositorio.getOne(id).getSenha();
        causa.setSenha(senhaAtual);

        causaRepositorio.save(causa);

        return "redirect:/Causa";
    }

    @GetMapping("/imagem1/{id}")
	@ResponseBody
	public byte[] exibirImagen1(@PathVariable("id") Long id) {
		Causa causa = this.causaRepositorio.getOne(id);
		return causa.getImagem1();
		
    }
    @GetMapping("/imagem2/{id}")
	@ResponseBody
	public byte[] exibirImagens(@PathVariable("id") Long id) {
		Causa causa = this.causaRepositorio.getOne(id);
		return causa.getImagem2();
		
    }
    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        causaRepositorio.deleteById(id);

        return "redirect:/Causa";
    }
    
}
