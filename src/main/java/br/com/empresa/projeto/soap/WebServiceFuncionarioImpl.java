package br.com.empresa.projeto.soap;

import java.sql.SQLException;
import java.util.List;

import br.com.empresa.projeto.business.FuncionarioBusiness;
import br.com.empresa.projeto.model.Funcionario;
import jakarta.jws.WebService;

//SIB (Service Implementation Bean)
@WebService(endpointInterface = "br.com.empresa.projeto.soap.WebServiceFuncionario")
public class WebServiceFuncionarioImpl implements WebServiceFuncionario {
	
	private FuncionarioBusiness business;

	public WebServiceFuncionarioImpl() {
		this.business = new FuncionarioBusiness();
	}

	@Override
	public Funcionario buscar(Integer id) {
		Funcionario funcionario = null;
		try {
			funcionario = this.business.getById(id);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return funcionario;
	}

	@Override
	public List<Funcionario> buscarTodos() {
		List<Funcionario> funcionarios = null;
		try {
			funcionarios = this.business.getAll();
		} catch (Exception e) {
			System.out.println(e);
		}
		return funcionarios;
	}

	@Override
	public boolean adicionar(Funcionario exame) {
		try {
			this.business.insert(exame);
			return true;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean alterar(Funcionario funcionario) {
		try {
			this.business.update(funcionario);
			return true;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean remover(Integer id) {
		Funcionario funcionario;
		try {
			funcionario = this.business.getById(id);
			this.business.delete(funcionario);
			return true;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	}

}
