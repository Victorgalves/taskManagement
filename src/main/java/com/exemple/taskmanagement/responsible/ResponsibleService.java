package com.exemple.taskmanagement.responsible;

import com.exemple.taskmanagement.category.Category;
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

        return responsibleRepository.save(responsible);
    }

    public List<Responsible> listResponsibles() {
        return responsibleRepository.findAll();
    }

    public boolean removeResponsibles(Long id) {
        if (responsibleRepository.existsById(id)) {
            responsibleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
