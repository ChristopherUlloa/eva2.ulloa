package eva2.ulloa.service;

import eva2.ulloa.model.Persona;

public interface LoginService {
	
	public boolean loginX(String user, String password);
	
	public Persona login(String usuario, String password);

}
