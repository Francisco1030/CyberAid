package br.com.cyberair.bo;

import br.com.cyberair.model.Ong;
import br.com.cyberair.utils.RegraNegocioException;

import java.util.List;

import br.com.cyberair.dao.OngDao;

public class OngBO {

	private OngDao dao = new OngDao();
	
	public void adicionar(Ong ong) throws RegraNegocioException{
		dao.adicionarOng(ong);
	}
	
	public void atualizar(Ong ong) throws RegraNegocioException {
		dao.editarOng(ong);
	}
	
	public List<Ong> listaOngs(){
		return dao.listarOngs();
	}
	
	public void excluir(Ong o) throws RegraNegocioException{
		dao.removerOng(o);	
	}
	
	public Ong pesquisaId(Integer id) throws RegraNegocioException{
		if(id == null) {
			throw new RegraNegocioException("O ID é nulo!");
		}
		return dao.buscarOngPorId(id);
	}

}
