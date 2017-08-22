package br.com.techgold.tg.util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.techgold.tg.modelo.Funcionario;

public class Autorizador implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent evento) {
		FacesContext context = evento.getFacesContext();
		String nomePagina = context.getViewRoot().getViewId();
		
		System.out.println(nomePagina);
		
		if("/login.xhtml".equals(nomePagina)){
			return;
		}
		
		Funcionario funcionarioLogado = (Funcionario) context.getExternalContext().getSessionMap().get("funcionarioLogado");
		
		if(funcionarioLogado != null){
			return;
		}
		
		NavigationHandler handler = context.getApplication().getNavigationHandler();
		handler.handleNavigation(context, null, "/login.xhtml?faces-redirect=true");
		context.renderResponse();
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
