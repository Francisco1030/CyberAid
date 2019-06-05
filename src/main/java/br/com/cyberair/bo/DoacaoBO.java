package br.com.cyberair.bo;

import java.util.List;

import br.com.cyberair.dao.DoacaoDao;
import br.com.cyberair.dao.DoadorDao;
import br.com.cyberair.dao.OngDao;
import br.com.cyberair.model.Doacao;
import br.com.cyberair.model.Doador;
import br.com.cyberair.model.Ong;
import br.com.cyberair.utils.RegraNegocioException;

public class DoacaoBO {
	
	private DoacaoDao daoDoacao = new DoacaoDao();
	
	private DoadorDao daoDoador = new DoadorDao();
	
	private OngDao daoOng = new OngDao();
	
	public void adicionar(Doacao doacao) throws RegraNegocioException {
		if(doacao.getDoador().getId().equals("") || doacao.getOng().getId().equals("")) {
			throw new RegraNegocioException("Objetos não podem ser nulos!");
		}
		//Double.parseDouble(doacao.getValor());
		daoDoacao.adicionarDoacao(doacao);
	}
	
	public List<Doador> listaDoadores(){
		return daoDoador.listarDoadores();
	}
	
	public List<Ong> listaOngs(){
		return daoOng.listarOngs();
	}

}
