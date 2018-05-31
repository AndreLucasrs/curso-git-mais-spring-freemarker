package com.example.FreeMarkerEnvers.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.envers.AuditReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FreeMarkerEnvers.dto.PostDTO;
import com.example.FreeMarkerEnvers.model.Post;
import com.example.FreeMarkerEnvers.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	private Post montaPost(PostDTO dto) {
		Post post = new Post();

		post.setAutor(dto.getAutor());
		post.setTexto("Texto");
		post.setTitulo(dto.getTitulo());
		post.setData(new Date());
		
		return post;
		
	}
	
	public List<PostDTO> listaPost(){
		List<Post> dto = repository.listaPost();
		
		List<PostDTO> resultado = new ArrayList<>();
		for (Post post : dto) {
			PostDTO result = new PostDTO();
			result.setId(post.getId());
			result.setAutor(post.getAutor());
			result.setTitulo(post.getTitulo());
			resultado.add(result);
		}
		return resultado;
	}
	@Transactional
	public void salvarPost(PostDTO dto) {
		Post post = montaPost(dto);
		repository.salvar(post);
	}
	@Transactional
	public void removePost(PostDTO dto) {
		Post post = repository.busca(dto.getId());
		repository.excluir(post);
	}
	@Transactional
	public void editaPost(PostDTO dto) {
		Post post = repository.busca(dto.getId());
		post.setAutor(dto.getAutor());
		post.setTitulo(dto.getTitulo());
		repository.update(post);
	}
	
	public PostDTO buscaPost(Long id) {
		Post post = repository.busca(id);
		PostDTO dto = new PostDTO();
		dto.setId(post.getId());
		dto.setAutor(post.getAutor());
		dto.setTitulo(post.getTitulo());
		
		return dto;
	}
}