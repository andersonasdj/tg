package br.com.techgold.tg.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.techgold.tg.dao.FuncionarioDao;
import br.com.techgold.tg.modelo.Funcionario;

@ManagedBean
@ViewScoped
public class LoginBean {
	
	private Funcionario funcionario = new Funcionario();
	
	public Funcionario getUsuario() {
		return funcionario;
	}

	public String efetuarLogin(){
		boolean existe = new FuncionarioDao().existe(this.funcionario);
		FacesContext context = FacesContext.getCurrentInstance();
		if(existe){
			context.getExternalContext().getSessionMap().put("funcionarioLogado", this.funcionario);
			
			return "solicitacoes?faces-redirect=true";
		}
		
		context.getExternalContext().getFlash().setKeepMessages(true);
		// /\ a mensagem é mantida por duas requisições, sem ela a mensagem nem aparece
		context.addMessage(null, new FacesMessage("Usuário não encontrado!"));
		
		return "login?faces-redirect=true";
	}
	
	public String deslogar(){
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("funcionarioLogado");
		
		
		return "login?faces-redirect=true";
	}
}
