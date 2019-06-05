package br.com.cyberair.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.cyberair.bo.DoadorBO;
import br.com.cyberair.model.Doador;
import br.com.cyberair.model.TipoPessoa;
import br.com.cyberair.utils.RegraNegocioException;


@ManagedBean
@ViewScoped
public class DoadorBean implements Serializable {

	private static final long serialVersionUID = -2643401591739123562L;
	
	private DoadorBO bo = new DoadorBO();
	
	private Doador doador = new Doador();
		
	private List<Doador> doadores;
	
	public TipoPessoa[] tiposPessoas() {
		return TipoPessoa.values();
	}

	public String adicionar() {
		try {
			bo.adicionar(doador);
			FacesContext.getCurrentInstance().addMessage("msgs", new FacesMessage("Doador cadastrado com sucesso"));
			doador = new Doador();
		}catch(RegraNegocioException e) {
			FacesContext.getCurrentInstance().addMessage("msgs",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			return null;
		}
		return "/doador/dadosDoador";
	}
	
	public String excluir(Doador doador) {
		try {
			bo.excluir(doador);
			FacesContext.getCurrentInstance().addMessage("msgs", new FacesMessage("Doador removido com sucesso"));
			doador = new Doador();
		} catch (RegraNegocioException e) {
			FacesContext.getCurrentInstance().addMessage("msgs",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			return null;
		}
		return "/doador/listaDoador";
	}

	public Doador getDoador() {
		return doador;
	}

	public void setDoador(Doador doador) {
		this.doador = doador;
	}
	
	public List<Doador> getDoadores(){
		if (doadores == null) {
			doadores = bo.listaDoadores();
		}
		return doadores;
	}

}
