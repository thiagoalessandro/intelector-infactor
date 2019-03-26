package br.com.intelector.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import br.com.intelector.api.model.SegOperacao;

public interface SegOperacaoService {

	public SegOperacao save(SegOperacao operacao);
	
	public Iterable<SegOperacao> saveAll(Iterable<SegOperacao> listOperacao);
	
	public Page<SegOperacao> findByNome(String nome, int page, int count);
	
	public Optional<SegOperacao> findById(Long id);
	
	public void deleteLogical(SegOperacao operacao);
	
}
