package com.example.FreeMarkerEnvers.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.FreeMarkerEnvers.model.Post;


@Repository
public class PostRepository {
	
    @PersistenceContext
    protected EntityManager entityManager;
	
	public List<Post> listaPost(){
		StringBuilder hql = new StringBuilder();

        hql.append(" SELECT posts FROM tbl_post posts ");

        Query query = entityManager.createQuery(hql.toString());
        List<Post> resultado = query.getResultList();
        return resultado;
	}
	
	public void salvar(Post post){
		entityManager.persist(post);
	}
	
	public void excluir(Post post){
		entityManager.remove(post);
	}
	
	public void update(Post post) {
		entityManager.merge(post);
	}
	
	public Post busca(Long id) {
		return entityManager.find(Post.class, id);
	}
}
