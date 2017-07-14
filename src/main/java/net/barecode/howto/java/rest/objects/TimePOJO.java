package net.barecode.howto.java.rest.objects;

import java.util.Date;

public class TimePOJO {
	private String qualifier;
	private String time;
	

	public TimePOJO() {
		this.time = new Date().toString();
		this.qualifier = "default";
	}
	
	public TimePOJO(String qualifier) {
		this.time = new Date().toString();
		this.qualifier = qualifier;
	}
	
	public String getTime() {
		return time;
	}
	
	public String getQualifier() {
		return qualifier;
	}
	
}
