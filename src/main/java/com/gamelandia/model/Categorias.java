package com.gamelandia.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Size;



@Entity
@Table(name = "tb_categorias")
	 public class Categorias {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NotBlank(message = "O atributo tipo é Obrigatório!")
		@Size(min = 3, max = 100, message = "O atributo tipo deve conter no mínimo 05 e no máximo 100 caracteres")
		private String tipo;
		
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "categorias", cascade = CascadeType.REMOVE)
		@JsonIgnoreProperties("categorias")
		private List<Produtos> produtos;
		

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		public List<Produtos> getProdutos() {
			return produtos;
		}

		public void setProdutos(List<Produtos> produtos) {
			this.produtos = produtos;
		}
		
		
}
