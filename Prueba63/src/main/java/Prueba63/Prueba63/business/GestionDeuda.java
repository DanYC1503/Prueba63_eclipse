package Prueba63.Prueba63.business;

import java.util.Date;
import java.util.List;

import Prueba63.Prueba63.dao.UsuarioDAO;
import Prueba63.Prueba63.dao.DeudaDAO;
import Prueba63.Prueba63.model.Usuario;
import Prueba63.Prueba63.model.DetalleDeuda;
import Prueba63.Prueba63.model.Deuda;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
@Singleton
@Startup
public class GestionDeuda {

	@Inject
	private UsuarioDAO daoUsuario;
	
	@Inject
	private DeudaDAO daoDeuda;
	
	@PostConstruct
	public void init() {
		System.out.println("iniciando");
		
		Usuario usuario = new Usuario();
		usuario.setCodigo(1);
		usuario.setNombre("Daniel Brian");;
		usuario.setApellido("Yanza Caceres");
		usuario.setCedula("1752773521");;
		
		daoUsuario.insert(usuario);
		Deuda deuda = new Deuda();
		deuda.setCedula("1752773521");
		deuda.setNumero("001-001-00000001");
		deuda.setFechaEmision(new Date());
		deuda.setTotal(41.00);
		deuda.setTitulo("Empresa Electrica");
		
		
		
		DetalleDeuda det = new DetalleDeuda();
		det.setNombre("Mes Abril");
		det.setPrecio(27.85);
		
		deuda.addDetalle(det);
		
		det = new DetalleDeuda();
		det.setNombre("Mes Junio");
		det.setPrecio(13.15);
		
		deuda.addDetalle(det);
		
		
		daoDeuda.insert(deuda);
		
		
		usuario = new Usuario();
		usuario.setCodigo(2);
		usuario.setNombre("John Doe");
		usuario.setApellido("Stevenson Peterson");
		usuario.setCedula("0150525921");
		
		daoUsuario.insert(usuario);
		
		Deuda deuda2 = new Deuda();
		deuda2.setCedula("0150525921");
		deuda2.setNumero("002-002-00000002");
		deuda2.setFechaEmision(new Date());
		deuda2.setTotal(76.5);
		deuda2.setTitulo("Internet");;
		
		
		
		
		
		DetalleDeuda det2 = new DetalleDeuda();
		det2.setNombre("Mes Enero");
		det2.setPrecio(6.50);
		
		deuda2.addDetalle(det2);
		
		det2 = new DetalleDeuda();
		det2.setNombre("Mes Febrero");
		det2.setPrecio(60.00);
		
		deuda2.addDetalle(det2);
		
		
		daoDeuda.insert(deuda2);
		
		
		/*System.out.println("\n------------- Usuarios");
		List<Usuario> list = daoUsuario.getAll();
		for (Usuario cli: list) {
			System.out.println(cli.getCodigo() + "\t" + cli.getNombre());
		}*/
		System.out.println("\n------------- Deudas Number 2");
		List<Deuda> list2 = daoDeuda.getAll();
		for (Deuda fac: list2) {
			System.out.println(fac);
		}
		
		
		Deuda deuda3 = new Deuda();
		deuda3.setCedula("1752773521");
		deuda3.setNumero("003-003-00000003");
		deuda3.setFechaEmision(new Date());
		deuda3.setTotal(90.50);
		deuda3.setTitulo("Servicio Medico");
		
		DetalleDeuda det3 = new DetalleDeuda();
		det3.setNombre("Mes Enero");
		det3.setPrecio(6.50);
		
		deuda3.addDetalle(det3);
		
		daoDeuda.insert(deuda3);
		
		System.out.println("\n------------- Deudas Number 3");
		List<Deuda> list3 = daoDeuda.getAll();
		for (Deuda fac: list3) {
			System.out.println(fac);
		}
		
	}
	public List<DetalleDeuda> getDeudas(){
		return daoDeuda.detGetAll();
	}
	public List<Deuda> getDeudasPorCedula(String cedula){
		return daoDeuda.getDeudaPorCedula(cedula);
	}
}