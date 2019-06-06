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
		daoDoacao.adicionarDoacao(doacao);
	}
	
	public void atualizar(Doacao doacao) throws RegraNegocioException {
		daoDoacao.editarDoacao(doacao);
	}
	
	public void excluir(Doacao doacao) throws RegraNegocioException{
		daoDoacao.removerDoacao(doacao);	
	}
	
	public Doacao pesquisaId(Integer id) throws RegraNegocioException{
		if(id == null) {
			throw new RegraNegocioException("O ID é nulo!");
		}
		return daoDoacao.buscarDoacaoPorId(id);
	}
	
	public List<Doacao> listaDoacoes(){
		return daoDoacao.listarDoacoes();
	}
	
	public List<Doador> listaDoadores(){
		return daoDoador.listarDoadores();
	}
	
	public List<Ong> listaOngs(){
		return daoOng.listarOngs();
	}

}
