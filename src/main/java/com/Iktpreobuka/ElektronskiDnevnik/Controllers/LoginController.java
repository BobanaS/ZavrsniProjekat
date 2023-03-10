package com.Iktpreobuka.ElektronskiDnevnik.Controllers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Iktpreobuka.ElektronskiDnevnik.DTO.KorisnikDTO;
import com.Iktpreobuka.ElektronskiDnevnik.Util.Encryption;
import com.Iktpreobuka.ElektronskiDnevnik.entities.Korisnik;
import com.Iktpreobuka.ElektronskiDnevnik.repositories.Korisnik_Repository;



import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.InvalidKeyException;


@RestController
public class LoginController {
	@Autowired
	private Korisnik_Repository KorisnikRepository;
	@Value("${spring.security.token-duration}")
	private Integer tokenDuration;
	@Autowired
	private SecretKey secretKey;
	private String token;
	private Korisnik korisnici;
	
	

	private String getJWTToken(Korisnik korisnik) {
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList(korisnik.getRole().getName());
		String token =Jwts.builder().setId("softtekJWT").setSubject(korisnik.getKorisnicko_ime()).
				claim("authorities", grantedAuthorities.stream().map(GrantedAuthority::getAuthority).
						collect(Collectors.toList())).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + this.tokenDuration)).signWith(this.secretKey).compact();
		return "Bearer " + token;
	}
	

	@RequestMapping(path = "api/v1/login", method = RequestMethod.POST)
	
	public ResponseEntity<?> login(@RequestParam String korisnicko_ime, @RequestParam String sifra) {
		Korisnik korisnici = KorisnikRepository.findByKorisnickoime(korisnicko_ime);
		if (korisnici != null && Encryption.validatePassword(sifra, korisnici.getSifra())) {
			// TODO 1 create the token
			String token = getJWTToken(korisnici);			
			// TODO 2 create response with UserDTO
			KorisnikDTO retVal = new KorisnikDTO(korisnicko_ime, token);
			return new ResponseEntity<KorisnikDTO>(retVal, HttpStatus.OK);
		}
		return new ResponseEntity<>("Wrong credentials", HttpStatus.UNAUTHORIZED);
	}
	}

