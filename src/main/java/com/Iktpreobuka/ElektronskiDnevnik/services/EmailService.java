package com.Iktpreobuka.ElektronskiDnevnik.services;

import com.Iktpreobuka.ElektronskiDnevnik.entities.Email;

public interface EmailService {
	void sendMessage(Email e) throws Exception;
}
