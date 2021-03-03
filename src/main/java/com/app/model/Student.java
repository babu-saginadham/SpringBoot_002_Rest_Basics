package com.app.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {

	int sno;
	String sname;
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	
}
