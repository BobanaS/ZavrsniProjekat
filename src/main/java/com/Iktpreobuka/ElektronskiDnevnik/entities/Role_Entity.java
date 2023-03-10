package com.Iktpreobuka.ElektronskiDnevnik.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

	@Entity
	@Table(name="role")
	@JsonIgnoreProperties({"handler", "hibernateLazyInializer"})
	public class Role_Entity {
		@Id
		@GeneratedValue
		@Column(name="role_id")
		private Integer id;
		@Column(name="role_name")
		private String name;
		@JsonIgnore
		@OneToMany(mappedBy="role", fetch=FetchType.LAZY, cascade=CascadeType.REFRESH)
		private List<Korisnik> korisnici = new ArrayList<>();
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public List<Korisnik> getKorisnik() {
			return korisnici;
		}
		public void setKorisnik(List<Korisnik> korisnici) {
			this.korisnici = korisnici;
		}
		public Role_Entity() {
			super();
		}
		public Role_Entity(Integer id, String name, List<Korisnik> korisnici) {
			super();
			this.id = id;
			this.name = name;
			this.korisnici=korisnici;
		}
		
	}

	

