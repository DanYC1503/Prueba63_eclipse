package Prueba63.Prueba63.services;

import java.util.List;

import Prueba63.Prueba63.business.GestionDeuda;
import Prueba63.Prueba63.model.Deuda;
import Prueba63.Prueba63.model.Usuario;
import Prueba63.Prueba63.services.ErrorMessage;
import Prueba63.Prueba63.model.DetalleDeuda;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("deudas")
public class DeudaServices {
	
	@Inject
	private GestionDeuda gDatos;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getDeudas(){
		List<DetalleDeuda> deuda = gDatos.getDeudas();
		if(deuda.size()>0)
			return Response.ok(deuda).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran deuda");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}
	@GET
	@Path("{cedula}")
	@Produces(MediaType.APPLICATION_JSON)
	//@Produces("application/json")
	public Response leer2(@PathParam("cedula") String cedula) {
		try{
			System.out.println("cedula " +  cedula );
			List <Deuda> deu = gDatos.getDeudasPorCedula(cedula);
			return Response.ok(deu).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(4, "Usuario no existe");
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}

}
