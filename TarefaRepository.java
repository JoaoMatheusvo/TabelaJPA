package br.edu.univille.poo.jpa.repository;

import br.edu.univille.poo.JPA.Entity.Tarefa;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
   List<Tarefa> findAllByIdContaining(Long id);

   List<Tarefa> findAllByNome(String Nome);
}
