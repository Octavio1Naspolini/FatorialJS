package com.br.escola.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.escola.Model.Aula;
import com.br.escola.Model.Estudante;
import com.br.escola.Repository.AulaRepository;
import com.br.escola.Repository.EstudanteRepository;

@Controller
public class AulaController {

    @Autowired
    AulaRepository aRepository;

    @Autowired
    EstudanteRepository repository;

    @GetMapping("/homeAula")
    public ModelAndView homeAula() {
        ModelAndView mv = new ModelAndView("homeAula");
        ArrayList<Estudante> estudantes = new ArrayList<>();
        estudantes = (ArrayList<Estudante>) repository.findAll();
        mv.addObject("estudantes", estudantes);
        return mv;
    }

    @PostMapping("/homeAula")
    public String salvar(Aula aula) {
        aRepository.save(aula);
        return "redirect:/listaAula";
    }

    @GetMapping("/listaAula")
    public ModelAndView lista() {
        ModelAndView mv = new ModelAndView("listaAula");
        ArrayList<Aula> aulas = new ArrayList<>();
        aulas = (ArrayList<Aula>) aRepository.findAll();
        mv.addObject("aulas", aulas);
        return mv;
    }

}