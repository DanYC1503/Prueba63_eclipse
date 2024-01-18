package Prueba63.Prueba63.dao;

import java.util.List;

import Prueba63.Prueba63.model.Deuda;
import Prueba63.Prueba63.model.DetalleDeuda;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class DeudaDAO {

	@PersistenceContext
	private EntityManager em;
	
	
	public void insert(Deuda deuda) {
		em.persist(deuda);
	}
	
	public void update(Deuda deuda) {
		em.merge(deuda);
	}
	
	public void remove(int codigo) {
		Deuda deuda = em.find(Deuda.class, codigo);
		em.refresh(deuda);
	}
	
	public Deuda read(int codigo) {
		Deuda deuda = em.find(Deuda.class, codigo);
		return deuda;
	}
	
	@SuppressWarnings("unchecked")
	public List<Deuda> getAll(){
		String jpql = "SELECT b FROM Deuda b";
		Query q = em.createQuery(jpql, Deuda.class);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Deuda> getDeudaPorCedula(String cedula) {
	    String jpql = "SELECT d FROM Deuda d WHERE d.cedula = :cedula";
	    Query q = em.createQuery(jpql, Deuda.class);
	    q.setParameter("cedula", cedula);
	    return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<DetalleDeuda> detGetAll(){
		String jpql = "SELECT b FROM DetalleDeuda b";
		Query q = em.createQuery(jpql, Deuda.class);
		return q.getResultList();
	}
}
