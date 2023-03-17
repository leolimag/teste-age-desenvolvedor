package br.com.empresa.projeto.soap;

import java.sql.SQLException;
import java.util.List;

import br.com.empresa.projeto.business.ExameBusiness;
import br.com.empresa.projeto.model.Exame;
import jakarta.jws.WebService;

//SIB (Service Implementation Bean)
@WebService(endpointInterface = "br.com.empresa.projeto.soap.WebServiceExame")
public class WebServiceExameImpl implements WebServiceExame {
	
	private ExameBusiness business;

	public WebServiceExameImpl() {
		this.business = new ExameBusiness();
	}

	@Override
	public Exame buscar(Integer id) {
		Exame exame = null;
		try {
			exame = this.business.getById(id);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return exame;
	}

	@Override
	public List<Exame> buscarTodos() {
		List<Exame> exames = null;
		try {
			exames = this.business.getAll();
		} catch (Exception e) {
			System.out.println(e);
		}
		return exames;
	}

	@Override
	public boolean adicionar(Exame exame) {
		try {
			this.business.insert(exame);
			return true;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean alterar(Exame exame) {
		try {
			this.business.update(exame);
			return true;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean remover(Integer id) {
		Exame exame;
		try {
			exame = this.business.getById(id);
			this.business.delete(exame);
			return true;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	}

}
