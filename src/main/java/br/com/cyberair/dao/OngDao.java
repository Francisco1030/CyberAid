package br.com.cyberair.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.cyberair.model.Ong;
import br.com.cyberair.utils.JpaUtil;


public class OngDao {

	public void adicionarOng(Ong pn) {
		
		EntityManager em = new JpaUtil().getEntityManager();	
		em.getTransaction().begin();
		em.merge(pn);	
		em.getTransaction().commit();
		em.close();
		
	}

	public Ong buscarOngPorId(Integer id) {
		
		EntityManager em = new JpaUtil().getEntityManager();
		em.getTransaction().begin();		
		Ong p = em.find(Ong.class, id);
		//System.out.println(p);
		em.getTransaction().commit();
		em.close();
		return p;
	}
	
	public void removerOng(Ong ong) {
		
		EntityManager em = new JpaUtil().getEntityManager();		
		em.getTransaction().begin();
		Ong o = em.merge(ong);				
		em.remove(o);
		System.out.println(o);		
		em.getTransaction().commit();
		em.close();
	}

	@SuppressWarnings("unchecked") // suprimir os alertas
	public List<Ong> listarOngs(){
		
		EntityManager em = new JpaUtil().getEntityManager();
		em.getTransaction().begin();	
		Query consulta = em.createQuery("select ong from Ong ong");
		List<Ong> ongs = consulta.getResultList();
		em.getTransaction().commit();
		em.close();
		
		return ongs;
	}
	
	
	
	public void editarOng(Ong pn) {
		
		EntityManager em = new JpaUtil().getEntityManager();
		em.getTransaction().begin();
		em.merge(pn);	
		em.getTransaction().commit();	
		em.close();
		
	}
	
	@SuppressWarnings("unchecked") // suprimir os alertas
	public List<Ong> listarOngsOrdenadas(){
		EntityManager em = new JpaUtil().getEntityManager();
		em.getTransaction().begin();
		
		Query consulta = em.createQuery("select ong from Ong ong "+ "order by id ");
		
		List<Ong> ongs = consulta.getResultList();
		
		for (Ong ong : ongs) {
			System.out.println(ong.getId()+" - "+ ong.getNome());
		}
		em.getTransaction().commit();
		em.close();
		
		return ongs;
	
}
}
