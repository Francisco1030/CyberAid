package br.com.cyberair.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.com.cyberair.bo.DoacaoBO;
import br.com.cyberair.model.Doacao;
import br.com.cyberair.model.Doador;
import br.com.cyberair.model.Ong;
import br.com.cyberair.utils.RegraNegocioException;

@ManagedBean
@ViewScoped
public class DoacaoBean implements Serializable {

	private static final long serialVersionUID = -2643401591739123562L;
	
	private Doacao doacao = new Doacao();
	
	private DoacaoBO bo = new DoacaoBO();
	
	private List<Doacao> doacoes;
	
	@PostConstruct
	public void inti() {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String indice = req.getParameter("id");
		if (indice != null && String.valueOf(indice).matches("\\d+"))
			try {
				doacao = bo.pesquisaId(Integer.valueOf(indice));
			} catch (NumberFormatException | RegraNegocioException e) {
				e.printStackTrace();
			}
	}
	
	public String adicionar() {
		try {
			bo.adicionar(doacao);
			FacesContext.getCurrentInstance().addMessage("msgs", new FacesMessage("Doação cadastrada com sucesso"));
			doacao = new Doacao();
		} catch (RegraNegocioException e) {
			FacesContext.getCurrentInstance().addMessage("msgs",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			return null;
		}
		return "/doacao/dadosDoacao.";
	}
	
	public String atualizar() {
		try {
			bo.atualizar(doacao);
			FacesContext.getCurrentInstance().addMessage("msgs", new FacesMessage("Doação atualizada com sucesso"));
			doacao = new Doacao();
		} catch (RegraNegocioException e) {
			FacesContext.getCurrentInstance().addMessage("msgs",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			return null;
		} finally {
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		}
		return "/doacao/listaDoacao.xhtml?faces-redirect=true";
	}
	
	public String excluir(Doacao doacao) {
		try {
			bo.excluir(doacao);
			FacesContext.getCurrentInstance().addMessage("msgs", new FacesMessage("Doação removida com sucesso"));
			doacao = new Doacao();
		} catch (RegraNegocioException e) {
			FacesContext.getCurrentInstance().addMessage("msgs",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			return null;
		}
		return "/doacao/listaDoacao";
	}
	
	public List<Doador> getDoadores(){
		return bo.listaDoadores();
	}
	
	public List<Ong> getOgns(){
		return bo.listaOngs();
	}
	
	public Doacao getDoacao() {
		return doacao;
	}

	public void setDoacao(Doacao doacao) {
		this.doacao = doacao;
	}

	public DoacaoBO getBo() {
		return bo;
	}

	public void setBo(DoacaoBO bo) {
		this.bo = bo;
	}
	
	public List<Doacao> getDoacoes() {
		if (doacoes == null) {
			doacoes = bo.listaDoacoes();
		}
		return doacoes;
	}
	
}
