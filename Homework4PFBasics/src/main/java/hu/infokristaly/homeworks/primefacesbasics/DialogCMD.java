package hu.infokristaly.homeworks.primefacesbasics;

import java.io.Serializable;

public class DialogCMD implements Serializable{

	private static final long serialVersionUID = 3552907208259300452L;

	private Long id;
	private String value;
	private IDAO dao;
	private String oncomplete;
	private String update;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getOncomplete() {
		return oncomplete;
	}
	public void setOncomplete(String oncomplete) {
		this.oncomplete = oncomplete;
	}
	public String getUpdate() {
		return update;
	}
	public void setUpdate(String update) {
		this.update = update;
	}
	public IDAO getDao() {
		return dao;
	}
	public void setDao(IDAO dao) {
		this.dao = dao;
	}
}
