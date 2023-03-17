package br.com.empresa.projeto.soap;

import java.util.List;

import br.com.empresa.projeto.model.Funcionario;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;

//SEI (Service Endpoint Interface)
@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface WebServiceFuncionario {

	@WebMethod
	public Funcionario buscar(Integer id);
	
	@WebMethod
	public List<Funcionario> buscarTodos();
	
	@WebMethod
	public boolean adicionar(Funcionario funcionario);
	
	@WebMethod
	public boolean alterar(Funcionario funcionario);
	
	@WebMethod
	public boolean remover(Integer id);
	
}
