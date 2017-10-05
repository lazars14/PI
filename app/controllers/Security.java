package controllers;

import models.Radnik;

public class Security extends Secure.Security {
	
	static boolean authenticate(String username, String password) {
		Radnik radnik = Radnik.find("byKorisnickoIme", username).first();
        return radnik != null && radnik.lozinka.equals(password);
    }
}
