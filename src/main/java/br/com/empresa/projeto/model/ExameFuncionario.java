package br.com.empresa.projeto.model;

import java.time.LocalDate;

public class ExameFuncionario {
	
	private Integer id_exame;
	private Integer id_funcionario;
	private LocalDate data;
	
	public ExameFuncionario() {
	}
	
	public ExameFuncionario(Integer id_exame, Integer id_funcionario, LocalDate data) {
		super();
		this.id_exame = id_exame;
		this.id_funcionario = id_funcionario;
		this.data = data;
	}
	
	public Integer getId_exame() {
		return id_exame;
	}
	
	public void setId_exame(Integer id_exame) {
		this.id_exame = id_exame;
	}
	
	public Integer getId_funcionario() {
		return id_funcionario;
	}
	
	public void setId_funcionario(Integer id_funcionario) {
		this.id_funcionario = id_funcionario;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
}
