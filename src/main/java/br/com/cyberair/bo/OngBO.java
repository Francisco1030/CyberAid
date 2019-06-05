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
	
	public List<Ong> listaOngs(){
		return dao.listarOngs();
	}
	
	public void excluir(Ong o) throws RegraNegocioException{
		dao.removerOng(o);	
	}

}
