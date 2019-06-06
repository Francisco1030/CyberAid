package br.com.cyberair.bo;

import java.util.List;

import br.com.cyberair.dao.DoadorDao;
import br.com.cyberair.model.Doador;
import br.com.cyberair.utils.RegraNegocioException;


public class DoadorBO {

	private DoadorDao dao = new DoadorDao();

	public void adicionar(Doador doador) throws RegraNegocioException {
		dao.adicionarDoador(doador);
	}
	
	public void atualizar(Doador doador) throws RegraNegocioException {
		dao.editarDoador(doador);
	}
	
	public List<Doador> listaDoadores(){
		return dao.listarDoadores();
	}
	
	public void excluir(Doador doador) throws RegraNegocioException{
		if(doador == null){
			throw new RegraNegocioException("O doador é nulo!");
		}
		dao.removerDoador(doador);
	}
	
	public Doador pesquisaId(Integer id) throws RegraNegocioException{
		if(id == null) {
			throw new RegraNegocioException("O ID é nulo!");
		}
		return dao.buscarPessoaPorId(id);
	}

}
