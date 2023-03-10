package com.Iktpreobuka.ElektronskiDnevnik.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Iktpreobuka.ElektronskiDnevnik.DTO.RazredDTO;
import com.Iktpreobuka.ElektronskiDnevnik.Util.RESTError;
import com.Iktpreobuka.ElektronskiDnevnik.entities.Predmet_Entity;
import com.Iktpreobuka.ElektronskiDnevnik.entities.Razred_Entity;
import com.Iktpreobuka.ElektronskiDnevnik.entities.SkolskaGodina_Entity;
import com.Iktpreobuka.ElektronskiDnevnik.entities.Ucenik_Entity;
import com.Iktpreobuka.ElektronskiDnevnik.security.Views;
import com.Iktpreobuka.ElektronskiDnevnik.services.PredmetService;
import com.Iktpreobuka.ElektronskiDnevnik.services.RazredService;
import com.Iktpreobuka.ElektronskiDnevnik.services.SkolskaGodinaService;
import com.Iktpreobuka.ElektronskiDnevnik.services.UcenikService;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping(path = "/api/v1/razred")
public class RazredControllors {
	@Autowired
	private PredmetService PredmetService;

	@Autowired
	private SkolskaGodinaService SkolskaService;

	@Autowired
	private RazredService RazredService;

	@Autowired
	private UcenikService UcenikService;

	@Secured({ "Nastavnik", "Ucenik" })
	@RequestMapping(method = RequestMethod.GET, value = "/private")
	@JsonView(Views.Private.class)
	public ResponseEntity<List<RazredDTO>> getAllRazredeForPrivate() {
		List<RazredDTO> razredDTO = new ArrayList<>();
		List<Razred_Entity> razred = RazredService.getAllRazrede();

		return new ResponseEntity<>(razredDTO, HttpStatus.OK);
	}

	// GET ALL FOR ADMIN
	@Secured("Admin")
	@RequestMapping(method = RequestMethod.GET, value = "/admin")
	@JsonView(Views.Admin.class)
	public ResponseEntity<List<RazredDTO>> getAllClassesForAdmin() {
		List<RazredDTO> RazredDTO = new ArrayList<>();
		List<Razred_Entity> razred = RazredService.getAllRazrede();

		return new ResponseEntity<>(RazredDTO, HttpStatus.OK);
	}

	// GET BY ID
	@Secured({ "Nastavnik", "Admin" })
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<?> getClassById(@PathVariable int id) {

		try {
			Razred_Entity c = RazredService.findRazredById(id);
			RazredDTO dto = new RazredDTO();
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RESTError>(new RESTError("Class not found!"), HttpStatus.NOT_FOUND);
		}
	}

	/*@Secured("ADMIN")
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<?> editRazred(@Valid @RequestBody RazredDTO RazredDTO, BindingResult result,
			@PathVariable("id") int id) {

		if (result.hasErrors()) {
			return new ResponseEntity<>(RESTError.createErrorMessage(result), HttpStatus.BAD_REQUEST);
		} else {
			try {
				SkolskaGodina_Entity sk = SkolskaGodinaService.findGodinaById(RazredDTO.getSchoolYearID());
				if (sk == null) {
					return new ResponseEntity<>(("School year doesn't exist!"), HttpStatus.BAD_REQUEST);

					ArrayList<Predmet_Entity> predmeti = PredmetService.getAllPredmeteByID(RazredDTO.getPredmet_ID());
					if (predmeti == null) {
						return new ResponseEntity<>(("Error has occured! Subjects not found!"), HttpStatus.BAD_REQUEST);
					}

					ArrayList<Ucenik_Entity> ucenici = UcenikService.getAllUcenikeByID(RazredDTO.getUcenici_ID());
					if (ucenici == null) {
						return new ResponseEntity<>(("Error has occured! Student not found!"), HttpStatus.BAD_REQUEST);
					}

					Razred_Entity c = new Razred_Entity(RazredDTO, sk, predmeti, ucenici);
					Razred_Entity cls = RazredService.editRazred(c, id, ucenici);
					RazredDTO newRazred = new RazredDTO(cls);

					return new ResponseEntity<>(newRazred, HttpStatus.CREATED);
				}
			} catch (Exception e) {
				return new ResponseEntity<>(("Razred alredy exists!"), HttpStatus.BAD_REQUEST);
			}
		}
	}
*/
	// DELETE
	@Secured("Admin")
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> deleteClass(@PathVariable int id) {
		try {
			if (RazredService.removeRazred(id)) {
				return new ResponseEntity<RESTError>(new RESTError("Delete successfully!"), HttpStatus.OK);
			} else {
				return new ResponseEntity<RESTError>(new RESTError("Class not found!"), HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<RESTError>(new RESTError("Can't delete that class"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
