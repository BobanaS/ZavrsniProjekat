package com.Iktpreobuka.ElektronskiDnevnik.services;


import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.Iktpreobuka.ElektronskiDnevnik.entities.Email;

@Service
public class EmailServiceImpl implements EmailService {
	@Autowired
	public JavaMailSender emailSender;
	@Override
		public void sendMessage(Email e) throws Exception {
			MimeMessage mail = emailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mail, true);
			helper.setTo(e.getRoditelj_email());
			helper.setSubject("Ocena");
			String text = "<html><body>Poštovani, Vaše dete, " + e.getIme_Ucenika() + " "
					+ e.getPrezime_Ucenika() + ", dobio/la je ocenu " + e.getOcena() + " iz predmeta "
					+ e.getImePredmeta() +" (" + e.getTip_ocene()+ ") , koji predaje " + e.getImeNastavnika()+ " "
					+ e.getPrezimeNastavnika() + "! <br><br> Srdacan pozdrav <br> Skola </body></html>";

			helper.setText(text, true);
			emailSender.send(mail);

		}

	}

