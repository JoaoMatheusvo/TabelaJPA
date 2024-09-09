package br.edu.univille.poo.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.Generated;

@Entity
public class Tarefa {
   @Id
   @GeneratedValue
   private long id;
   @Column(
      nullable = false
   )
   private String nome;
   @Column(
      nullable = false
   )
   private String descricao;

   @Generated
   public long getId() {
      return this.id;
   }

   @Generated
   public String getNome() {
      return this.nome;
   }

   @Generated
   public String getDescricao() {
      return this.descricao;
   }

   @Generated
   public void setId(final long id) {
      this.id = id;
   }

   @Generated
   public void setNome(final String nome) {
      this.nome = nome;
   }

   @Generated
   public void setDescricao(final String descricao) {
      this.descricao = descricao;
   }

   @Generated
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof Tarefa)) {
         return false;
      } else {
         Tarefa other = (Tarefa)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.getId() != other.getId()) {
            return false;
         } else {
            label49: {
               Object this$nome = this.getNome();
               Object other$nome = other.getNome();
               if (this$nome == null) {
                  if (other$nome == null) {
                     break label49;
                  }
               } else if (this$nome.equals(other$nome)) {
                  break label49;
               }

               return false;
            }

            Object this$descricao = this.getDescricao();
            Object other$descricao = other.getDescricao();
            if (this$descricao == null) {
               if (other$descricao != null) {
                  return false;
               }
            } else if (!this$descricao.equals(other$descricao)) {
               return false;
            }
         }
      }
   }

   @Generated
   protected boolean canEqual(final Object other) {
      return other instanceof Tarefa;
   }

   @Generated
   public int hashCode() {
      int PRIME = true;
      int result = 1;
      long $id = this.getId();
      int result = result * 59 + (int)($id >>> 32 ^ $id);
      Object $nome = this.getNome();
      result = result * 59 + ($nome == null ? 43 : $nome.hashCode());
      Object $descricao = this.getDescricao();
      result = result * 59 + ($descricao == null ? 43 : $descricao.hashCode());
      return result;
   }

   @Generated
   public String toString() {
      long var10000 = this.getId();
      return "Tarefa(id=" + var10000 + ", nome=" + this.getNome() + ", descricao=" + this.getDescricao();
   }
}
