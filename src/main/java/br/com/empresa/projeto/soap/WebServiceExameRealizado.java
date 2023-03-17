package br.com.empresa.projeto.soap;

import java.util.List;

import br.com.empresa.projeto.model.ExameFuncionario;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;

//SEI (Service Endpoint Interface)
@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface WebServiceExameRealizado {

	@WebMethod
	public ExameFuncionario buscar(Integer idExame, Integer idFuncionario, String data);
	
	@WebMethod
	public List<ExameFuncionario> buscarTodos();
	
	@WebMethod
	public boolean adicionar(ExameFuncionario exameFuncionario);
	
	@WebMethod
	public boolean alterar(ExameFuncionario exameFuncionario, String dataAntiga);
	
	@WebMethod
	public boolean remover(Integer idExame, Integer idFuncionario, String data);
	
}
