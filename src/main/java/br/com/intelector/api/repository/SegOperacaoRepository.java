package br.com.intelector.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.intelector.api.model.SegOperacao;
import br.com.intelector.api.model.enums.SituacaoEnum;

@Repository
public interface SegOperacaoRepository extends JpaRepository<SegOperacao, Long>{
	
	public Page<SegOperacao> findByNomeIgnoreCaseContainingAndSituacaoOrderByIdDesc(String nome, SituacaoEnum situacaoEnum, Pageable pages);
	
}
