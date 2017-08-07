package br.com.techgold.tg.bean;

import javax.faces.bean.ManagedBean;

import br.com.techgold.tg.dao.DAO;
import br.com.techgold.tg.modelo.Usuario;

@ManagedBean
public class UsuarioBean {

	private Usuario usuario = new Usuario();
	
	public Usuario getUsuario(){
		return usuario;
	}

	public void gravar() {
		System.out.println("Gravando usuario " + this.usuario.nome);
		
		if (usuario.getNome().isEmpty()) {
			throw new RuntimeException("Usuario deve ter pelomenos nome");
		}

		new DAO<Usuario>(Usuario.class).adiciona(this.usuario);
		
		this.usuario = new Usuario();
		
	}
}
