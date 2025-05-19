package com.exemple.taskmanagement.responsible;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResponsibleRepository extends JpaRepository<Responsible, Long> {
    List<Responsible> findByAtivo(int ativo);
}
