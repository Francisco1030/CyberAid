package br.com.cyberair.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.com.cyberair.bo.OngBO;
import br.com.cyberair.model.Ong;
import br.com.cyberair.utils.RegraNegocioException;

@ManagedBean
@ViewScoped
public class OngBean implements Serializable {

	private static final long serialVersionUID = -2643401591739123562L;

	private Ong ong = new Ong();

	private OngBO bo = new OngBO();

	private List<Ong> ongs;
	
	@PostConstruct
	public void inti() {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String indice = req.getParameter("id");
		if (indice != null && String.valueOf(indice).matches("\\d+"))
			try {
				ong = bo.pesquisaId(Integer.valueOf(indice));
			} catch (NumberFormatException | RegraNegocioException e) {
				e.printStackTrace();
			}
	}

	public String adicionar() {
		try {
			bo.adicionar(ong);
			FacesContext.getCurrentInstance().addMessage("msgs", new FacesMessage("Ong cadastrada com sucesso"));
			ong = new Ong();
		} catch (RegraNegocioException e) {
			FacesContext.getCurrentInstance().addMessage("msgs",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			return null;
		}
		return "/ong/dadosOng";
	}
	
	public String atualizar() {
		try {
			bo.atualizar(ong);
			FacesContext.getCurrentInstance().addMessage("msgs", new FacesMessage("Ong atualizada com sucesso"));
			ong = new Ong();
		} catch (RegraNegocioException e) {
			FacesContext.getCurrentInstance().addMessage("msgs",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			return null;
		} finally {
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		}
		return "/ong/listaOng.xhtml?faces-redirect=true";
	}

	public String excluir(Ong o) {
		try {
			bo.excluir(o);
			FacesContext.getCurrentInstance().addMessage("msgs", new FacesMessage("Ong removida com sucesso"));
			ong = new Ong();
		} catch (RegraNegocioException e) {
			FacesContext.getCurrentInstance().addMessage("msgs",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			return null;
		}
		return "/ong/listaOng";
	}

	public Ong getOng() {
		return ong;
	}

	public void setOng(Ong ong) {
		this.ong = ong;
	}

	public OngBO getBo() {
		return bo;
	}

	public void setBo(OngBO bo) {
		this.bo = bo;
	}

	public List<Ong> getOngs() {
		if (ongs == null) {
			ongs = bo.listaOngs();
		}
		return ongs;
	}

}
