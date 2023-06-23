package com.br.escola.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.escola.Model.Aula;
import com.br.escola.Model.Estudante;
import com.br.escola.Model.Professor;
import com.br.escola.Repository.AulaRepository;
import com.br.escola.Repository.EstudanteRepository;
import com.br.escola.Repository.ProfessorRepository;

@Controller
public class EstudanteController {

    @Autowired
    EstudanteRepository repository;

    @Autowired
    AulaRepository aRepository;

    @Autowired
    ProfessorRepository pRepository;

    @GetMapping("/homeEstudante")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("homeEstudante");
        ArrayList<Aula> aulas = new ArrayList<>();
        aulas = (ArrayList<Aula>) aRepository.findAll();
        mv.addObject("aulas", aulas);

        ArrayList<Professor> professores = new ArrayList<>();
        professores = (ArrayList<Professor>) pRepository.findAll();
        mv.addObject("professores", professores);

        return mv;
    }

    @PostMapping("/homeEstudante")
    public String salvar(Estudante estudante) {
        repository.save(estudante);
        return "redirect:/listaEstudante";
    }

    @GetMapping("/listaEstudante")
    public ModelAndView lista() {
        ModelAndView mv = new ModelAndView("listaEstudante");
        ArrayList<Estudante> estudantes = new ArrayList<>();
        estudantes = (ArrayList<Estudante>) repository.findAll();
        mv.addObject("estudantes", estudantes);
        return mv;
    }

}