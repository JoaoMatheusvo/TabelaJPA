package br.edu.univille.poo.jpa.controller;

import br.edu.univille.poo.JPA.Entity.Tarefa;
import br.edu.univille.poo.JPA.Tarefa.TarefaTarefa;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"api/tarefa"})
public class TarefaRestController {
   @Autowired
   private TarefaTarefa tarefaTarefa;

   @GetMapping
   public List<Tarefa> obterTodos() {
      return this.tarefaTarefa.obterTodos();
   }

   @GetMapping({"/{id}"})
   public ResponseEntity<Tarefa> obterPeloId(@PathVariable Long id) {
      Optional<Tarefa> opt = this.tarefaTarefa.obterPeloId(id);
      return (ResponseEntity)opt.map((tarefa) -> {
         return new ResponseEntity(tarefa, HttpStatus.OK);
      }).orElseGet(() -> {
         return new ResponseEntity(HttpStatus.NOT_FOUND);
      });
   }

   @PostMapping
   public ResponseEntity<?> incluir(@RequestBody Tarefa tarefa) {
      try {
         tarefa = this.tarefaTarefa.incluir(tarefa);
         return new ResponseEntity(tarefa, HttpStatus.CREATED);
      } catch (Exception var3) {
         return new ResponseEntity(var3.getMessage(), HttpStatus.BAD_REQUEST);
      }
   }

   @PutMapping
   public ResponseEntity<?> atualizar(@RequestBody Tarefa tarefa) {
      try {
         tarefa = this.tarefaTarefa.atualizar(tarefa);
         return new ResponseEntity(tarefa, HttpStatus.OK);
      } catch (Exception var3) {
         return new ResponseEntity(var3.getMessage(), HttpStatus.BAD_REQUEST);
      }
   }

   @DeleteMapping
   public ResponseEntity<?> excluir(@RequestBody Tarefa tarefa) {
      try {
         this.tarefaTarefa.excluir(tarefa);
         return new ResponseEntity(HttpStatus.OK);
      } catch (Exception var3) {
         return new ResponseEntity(var3.getMessage(), HttpStatus.BAD_REQUEST);
      }
   }
}
