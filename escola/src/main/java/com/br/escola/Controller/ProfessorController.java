package com.br.escola.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.escola.Model.Estudante;
import com.br.escola.Model.Professor;
import com.br.escola.Repository.EstudanteRepository;
import com.br.escola.Repository.ProfessorRepository;

@Controller
public class ProfessorController {

    @Autowired
    ProfessorRepository pRepository;

    @Autowired
    EstudanteRepository repository;

    @GetMapping("/homeProfessor")
    public ModelAndView homeProfessor() {
        ModelAndView mv = new ModelAndView("homeProfessor");
        ArrayList<Estudante> estudantes = new ArrayList<>();
        estudantes = (ArrayList<Estudante>) repository.findAll();
        mv.addObject("estudantes", estudantes);
        return mv;
    }

    @PostMapping("/homeProfessor")
    public String salvar(Professor professor) {
        pRepository.save(professor);
        return "redirect:/listaProfessor";
    }

    @GetMapping("/listaProfessor")
    public ModelAndView lista() {
        ModelAndView mv = new ModelAndView("listaProfessor");
        ArrayList<Professor> professores = new ArrayList<>();
        professores = (ArrayList<Professor>) pRepository.findAll();
        mv.addObject("professores", professores);
        return mv;
    }

}