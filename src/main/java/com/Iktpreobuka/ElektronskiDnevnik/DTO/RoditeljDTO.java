package com.Iktpreobuka.ElektronskiDnevnik.DTO;

import java.util.ArrayList;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.Iktpreobuka.ElektronskiDnevnik.entities.User_role;
import com.Iktpreobuka.ElektronskiDnevnik.security.Views;
import com.fasterxml.jackson.annotation.JsonView;

public class RoditeljDTO {
	@JsonView(Views.Private.class)
	private int id_rod;
	@JsonView (Views.Private.class)
	@NotNull(message = "Ime mora biti ubaceno!")
	@Size(min = 2, max = 20, message = "Ime mora imati {min} i {max} karaktera!")
	private String ime;
	@JsonView (Views.Private.class)
	@NotNull(message = "Prezime mora biti ubaceno!")
	@Size(min = 2, max = 20, message = "Prezime mora imati {min} i {max} karaktera!")
	private String prezime;
	@JsonView (Views.Admin.class)
	@NotNull(message = "Email must be provided!")
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Email is not valid!")
	private String email;
	@JsonView(Views.Admin.class)
	private User_role role;
	@JsonView (Views.Private.class)
	private ArrayList<Long> students;
	public int getId_rod() {
		return id_rod;
	}
	public void setId_rod(int id_rod) {
		this.id_rod = id_rod;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User_role getRole() {
		return role;
	}
	public void setRole(User_role role) {
		this.role = role;
	}
	public ArrayList<Long> getStudents() {
		return students;
	}
	public void setStudents(ArrayList<Long> students) {
		this.students = students;
	}
	public RoditeljDTO() {
		super();
	}
	public RoditeljDTO(int id_rod,
			@NotNull(message = "Ime mora biti ubaceno!") @Size(min = 2, max = 20, message = "Ime mora imati {min} i {max} karaktera!") String ime,
			@NotNull(message = "Prezime mora biti ubaceno!") @Size(min = 2, max = 20, message = "Prezime mora imati {min} i {max} karaktera!") String prezime,
			@NotNull(message = "Email must be provided!") @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Email is not valid!") String email,
			User_role role, ArrayList<Long> students) {
		super();
		this.id_rod = id_rod;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.role = role;
		this.students = students;
	}

}

