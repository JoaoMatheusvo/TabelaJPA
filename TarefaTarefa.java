package br.edu.univille.poo.jpa.tarefa;

import br.edu.univille.poo.JPA.Entity.Tarefa;
import br.edu.univille.poo.JPA.Repository.TarefaRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Tarefa;

@Tarefa
public class TarefaTarefa {
   @Autowired
   private TarefaRepository tarefaRepository;

   public List<Tarefa> obterTodos() {
      return this.tarefaRepository.findAll();
   }

   public Optional<Tarefa> obterPeloId(Long id) {
      return this.tarefaRepository.findById(id);
   }

   public Tarefa incluir(Tarefa tarefa) {
      tarefa.setId(0L);
      if (Strings.isBlank(tarefa.getId())) {
         throw new RuntimeException("Id não informado.");
      } else if (Strings.isBlank(tarefa.getNome())) {
         throw new RuntimeException("Nome não informado.");
      } else if (!this.pessoaRepository.findAllById(tarefa.getId()).isEmpty()) {
         throw new RuntimeException("Id já está cadastrado.");
      } else if (!this.pessoaRepository.findAllByNomeContaining(tarefa.getNome()).isEmpty()) {
         throw new RuntimeException("Nome já está cadastrado.");
      } else {
         tarefa = (Tarefa)this.tarefaRepository.save(tarefa);
         return tarefa;
      }
   }

   public Tarefa atualizar(Tarefa tarefa) {
      Tarefa antigo = (Tarefa)this.tarefaRepository.findById(tarefa.getId()).orElse((Object)null);
      if (antigo == null) {
         throw new RuntimeException("Tarefa não foi encontrada.");
      } else {
         antigo.setId(tarefa.getId());
         antigo.setNome(tarefa.getId());
         antigo.setDescricao(tarefa.getDescricao());
         if (Strings.isBlank(tarefa.getId())) {
            throw new RuntimeException("Id não informado.");
         } else if (Strings.isBlank(tarefa.getNome())) {
            throw new RuntimeException("Nome não informado.");
         } else {
            Iterator var3 = this.tarefaRepository.findAllById(tarefa.getId()).iterator();

            Tarefa t;
            do {
               if (!var3.hasNext()) {
                  var3 = this.tarefaRepository.findAllByNomeContaining(tarefa.getNome()).iterator();

                  do {
                     if (!var3.hasNext()) {
                        return (Tarefa)this.tarefaRepository.save(antigo);
                     }

                     p = (Tarefa)var3.next();
                  } while(antigo.getId() == p.getId());

                  throw new RuntimeException("Id já está cadastrado.");
               }

               p = (Tarefa)var3.next();
            } while(antigo.getId() == p.getId());

            throw new RuntimeException("Nome já está cadastrado.");
         }
      }
   }

   public void excluir(Tarefa tarefa) {
      Tarefa antigo = (Tarefa)this.tarefaRepository.findById(tarefa.getId()).orElse((Object)null);
      if (antigo == null) {
         throw new RuntimeException("Tarefa não encontrada.");
      } else {
         this.tarefaRepository.delete(antigo);
      }
   }
}
