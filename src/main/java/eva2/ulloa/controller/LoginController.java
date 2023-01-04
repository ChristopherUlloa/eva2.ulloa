package eva2.ulloa.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import eva2.ulloa.constantes.Constantes;
import eva2.ulloa.model.Persona;
import eva2.ulloa.service.LoginService;
import eva2.ulloa.util.SessionUtil;

import java.util.Objects;


@RequestScoped
@Named(value = "login")
public class LoginController {

	private String pwd;
	private String msg;
	private String user;

	@Inject
	private LoginService loginService;

	public String ingresar() {
		
		loginService.loginX(user,pwd);
		Persona persona = loginService.login(user, pwd);
		
		if(Objects.nonNull(persona)) {
			HttpSession session = SessionUtil.obtenerSesion();
			session.setAttribute("username", user);
			session.setAttribute(Constantes.PERSONA, persona);
			this.msg = Constantes.OK;
			return "login";
		} else{
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Usuario o password incorrectos",
							"Reingresar informaacion"));
			this.msg = Constantes.NOK;
			return "login";
		}
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
	
}
