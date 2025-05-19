package com.exemple.taskmanagement.responsible;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponsibleService {

    @Autowired
    private ResponsibleRepository responsibleRepository;

    public Responsible createResponsible(String name){
        Responsible responsible = new Responsible();
        responsible.setName(name);
        responsible.setAtivo(1);

        return responsibleRepository.save(responsible);
    }

    public List<Responsible> listResponsiblesAtivos() {
        return responsibleRepository.findByAtivo(1);
    }

    public List<Responsible> listResponsibles() {
        return responsibleRepository.findAll();
    }

    public void removeResponsibles(Long id) {
        Responsible responsible = responsibleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Responsável não encontrado"));
        responsible.setAtivo(0);
        responsibleRepository.save(responsible);
    }

}
