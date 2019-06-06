package br.com.cyberair.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.cyberair.model.Doador;
import br.com.cyberair.utils.JpaUtil;

public class DoadorDao {
	
	public void adicionarDoador(Doador doador) {

		EntityManager em = new JpaUtil().getEntityManager();
		em.getTransaction().begin();
		em.merge(doador);
		em.getTransaction().commit();
		em.close();

	}

	public Doador buscarPessoaPorId(Integer id) {
		
		EntityManager em = new JpaUtil().getEntityManager();
		em.getTransaction().begin();
		Doador doador = em.find(Doador.class, id);
		em.getTransaction().commit();
		em.close();

		return doador;
	}

	public void removerDoador(Doador d) {
		
		EntityManager em = new JpaUtil().getEntityManager();
		em.getTransaction().begin();
		Doador dm = em.merge(d);
		em.remove(dm);
		System.out.println(dm);
		em.getTransaction().commit();
		em.close();
		
	}

	@SuppressWarnings("unchecked")
	public List<Doador> listarDoadores() {
		
		EntityManager em = new JpaUtil().getEntityManager();
		em.getTransaction().begin();
		Query consulta = em.createQuery("select doador from Doador doador ");
		List<Doador> doadores = consulta.getResultList();
		em.getTransaction().commit();
		em.close();

		return doadores;

	}

	public void editarDoador(Doador pn) {
		
		EntityManager em = new JpaUtil().getEntityManager();
		em.getTransaction().begin();
		em.merge(pn);
		em.getTransaction().commit();
		em.close();
		
	}
}
