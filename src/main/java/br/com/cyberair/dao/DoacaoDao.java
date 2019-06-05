package br.com.cyberair.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.cyberair.model.Doacao;
import br.com.cyberair.utils.JpaUtil;

public class DoacaoDao {
	
	public void adicionarDoacao(Doacao d) {
		EntityManager em = new JpaUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		em.merge(d);	
		
		em.getTransaction().commit();
		
		em.close();
	}
	
	
	
	public Doacao buscarDoacaoPorId(Integer id) {
		EntityManager em = new JpaUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		Doacao d = em.find(Doacao.class, id);
		System.out.println(d);
		
		em.getTransaction().commit();
		em.close();
		
		return d;
	}
	
	public void removerDoacao(Doacao doac) {
		EntityManager em = new JpaUtil().getEntityManager();
		
		em.getTransaction().begin();
		Doacao d = em.merge(doac);
				
		em.remove(d);
		System.out.println(d);
		
		em.getTransaction().commit();
		em.close();
	}

	@SuppressWarnings("unchecked") // suprimir os alertas
	public List<Doacao> listarDoacoes(){
		
		EntityManager em = new JpaUtil().getEntityManager();
		em.getTransaction().begin();
		Query consulta = em.createQuery("select doacao from Doacao doacao");
		List<Doacao> doacoes = consulta.getResultList();
		
//		for (Doacao doacao : doacoes) {
//		System.out.println(doacao.getOng().getNome());
//		}
		
		em.getTransaction().commit();
		em.close();
		
		return doacoes;
	}
	
	public void editarDoacao(Doacao d) {
		EntityManager em = new JpaUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		em.merge(d);	
		
		em.getTransaction().commit();
		
		em.close();
	}	
}
