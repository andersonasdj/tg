package br.com.techgold.tg.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class UsuarioBean {

	private Usuario usuario = new Usuario();
	
	public Usuario getUsuario(){
		return usuario;
	}

	public void gravar() {
		System.out.println("Gravando usuario " + this.usuario.nome);
	}
}
