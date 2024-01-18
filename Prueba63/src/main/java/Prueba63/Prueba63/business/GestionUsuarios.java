package Prueba63.Prueba63.business;

import java.util.List;

import Prueba63.Prueba63.dao.UsuarioDAO;
import Prueba63.Prueba63.model.Usuario;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionUsuarios {
	
	@Inject
	private UsuarioDAO daoUsuario;

	public void guardarUsuarios(Usuario usuario) {
		Usuario cli = daoUsuario.read(usuario.getCodigo());
		if (cli != null){
			daoUsuario.update(usuario);
		}else {
			daoUsuario.insert(usuario);
		}
	}
	
	public void actualizarUsuario(Usuario usuario) throws Exception {
		Usuario cli = daoUsuario.read(usuario.getCodigo());
		if (cli != null){
			daoUsuario.update(usuario);
		}else {
			throw new Exception("Usuario no existe");
		}
	}
	
	public Usuario getUsuarioPorCedula(String cedula) throws Exception{
		
		if(cedula.length()!=10)
			throw new Exception("Cedula incorrecta");
			
		return daoUsuario.getUsuarioPorCedula(cedula);
	}
	
	public void borrarUsuario(int codigo){
		
		daoUsuario.remove(codigo);
	}
	
	public List<Usuario> getUsuarios(){
		return daoUsuario.getAll();
	}
}