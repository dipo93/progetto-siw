package it.uniroma3.controller;

import it.uniroma3.model.AdminFacade;
import it.uniroma3.model.Administrator;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SessionAdminController  {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String eMail;
	private String password;
	private String loginError;
	private Administrator currentAdmin;
	@EJB
	private AdminFacade adminFacade;

	
	
	public SessionAdminController() {
		
	}

	public String logAdmin() {
		Administrator admin = this.adminFacade.getAdmin(this.eMail);
		String nextPage = "admin_login";

		if (admin==null) 
			this.loginError = "Non esiste un amministratore con questa mail!";
		else {
			boolean passwordCorretta = admin.checkPassword(this.password);
			if (!passwordCorretta)
				this.loginError = "password sbagliata";
			else {
				this.currentAdmin = admin;
				nextPage="admin_home_page";
			}
		}
		return nextPage;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String geteMail() {
		return eMail;
	}


	public void seteMail(String eMail) {
		this.eMail = eMail;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getLoginError() {
		return loginError;
	}


	public void setLoginError(String loginError) {
		this.loginError = loginError;
	}


	public Administrator getCurrentAdmin() {
		return currentAdmin;
	}


	public void setCurrentAdmin(Administrator currentAdmin) {
		this.currentAdmin = currentAdmin;
	}


	public AdminFacade getAdminFacade() {
		return adminFacade;
	}


	public void setAdminFacade(AdminFacade adminFacade) {
		this.adminFacade = adminFacade;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}