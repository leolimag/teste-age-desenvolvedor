package br.com.empresa.projeto.soap;

import java.sql.SQLException;
import java.util.List;

import br.com.empresa.projeto.business.ExameFuncionarioBusiness;
import br.com.empresa.projeto.model.ExameFuncionario;
import jakarta.jws.WebService;

//SIB (Service Implementation Bean)
@WebService(endpointInterface = "br.com.empresa.projeto.soap.WebServiceExame")
public class WebServiceExameRealizadoImpl implements WebServiceExameRealizado {
	
	private ExameFuncionarioBusiness business;

	public WebServiceExameRealizadoImpl() {
		this.business = new ExameFuncionarioBusiness();
	}

	@Override
	public ExameFuncionario buscar(Integer idExame, Integer idFuncionario, String data) {
		ExameFuncionario exameFuncionario = null;
		try {
			exameFuncionario = this.business.getById(idExame, idFuncionario, data);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return exameFuncionario;
	}

	@Override
	public List<ExameFuncionario> buscarTodos() {
		List<ExameFuncionario> exameFuncionarios = null;
		try {
			exameFuncionarios = this.business.getAll();
		} catch (Exception e) {
			System.out.println(e);
		}
		return exameFuncionarios;
	}

	@Override
	public boolean adicionar(ExameFuncionario exameFuncionario) {
		try {
			this.business.insert(exameFuncionario);
			return true;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean alterar(ExameFuncionario exameFuncionario, String dataAntiga) {
		try {
			this.business.update(exameFuncionario, dataAntiga);
			return true;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean remover(Integer idExame, Integer idFuncionario, String data) {
		ExameFuncionario exameFuncionario;
		try {
			exameFuncionario = this.business.getById(idExame, idFuncionario, data);
			this.business.delete(exameFuncionario);
			return true;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	}

}
