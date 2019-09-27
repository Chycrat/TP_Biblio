package fr.cesi.bibliotheque.entity;

public class User {
	private Long id;
	private String login;
	private String mdp;
	
	public User(Long id, String login, String mdp) {
		super();
		this.id = id;
		this.login = login;
		this.mdp = mdp;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
}
