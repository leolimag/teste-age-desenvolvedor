package br.com.empresa.projeto.action;

import org.apache.struts2.convention.annotation.Action;

@Action("/hello")
public class HelloAction {

	private String name;

	public String execute() {
		System.out.println("acessei");
		return "success";
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
