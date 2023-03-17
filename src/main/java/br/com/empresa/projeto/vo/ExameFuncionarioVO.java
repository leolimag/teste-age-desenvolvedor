package br.com.empresa.projeto.vo;

public class ExameFuncionarioVO {

	private Integer idExame;
	private Integer quantidade;
	private String nomeExame;
	
	public ExameFuncionarioVO(Integer idExame, Integer quantidade, String nomeExame) {
		this.idExame = idExame;
		this.quantidade = quantidade;
		this.nomeExame = nomeExame;
	}

	public Integer getIdExame() {
		return idExame;
	}

	public void setIdExame(Integer idExame) {
		this.idExame = idExame;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getNomeExame() {
		return nomeExame;
	}

	public void setNomeExame(String nomeExame) {
		this.nomeExame = nomeExame;
	}
	
}
