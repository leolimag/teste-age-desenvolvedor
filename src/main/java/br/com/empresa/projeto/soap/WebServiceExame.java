package br.com.empresa.projeto.soap;

import java.util.List;

import br.com.empresa.projeto.model.Exame;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;

//SEI (Service Endpoint Interface)
@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface WebServiceExame {

	@WebMethod
	public Exame buscar(Integer id);
	
	@WebMethod
	public List<Exame> buscarTodos();
	
	@WebMethod
	public boolean adicionar(Exame exame);
	
	@WebMethod
	public boolean alterar(Exame exame);
	
	@WebMethod
	public boolean remover(Integer id);
	
}
