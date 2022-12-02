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


import br.com.EduAcao.model.Causa;
import br.com.EduAcao.model.Newsletter;
import br.com.EduAcao.model.UF;
import br.com.EduAcao.repositorios.CausaRepositorio;
import br.com.EduAcao.repositorios.NewsletterRepositorio;
import br.com.EduAcao.utils.SenhaUtils;



@Controller
@RequestMapping("/causas")
public class CausaController {

 
    
    @GetMapping
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("/causas");

        return modelAndView;
    }
 
 @GetMapping ("/cadastrar")
    public ModelAndView cadastrar(Causa causa, Newsletter newsletter) {
       ModelAndView modelAndView = new ModelAndView("/cadastrar");

      return modelAndView;
    }

 @GetMapping("/causasDetalhes")
    public ModelAndView causasDetalhes(Newsletter newsletter) {
        ModelAndView modelAndView = new ModelAndView("/causasDetalhes");


        return modelAndView;
    }

 
 @GetMapping("/login")
    public ModelAndView login(Newsletter newsletter) {
        ModelAndView modelAndView = new ModelAndView("/login");


        return modelAndView;
 
 }


    
   

   

   

    
}
