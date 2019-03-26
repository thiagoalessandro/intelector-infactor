package br.com.intelector.api.service.impl;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.intelector.api.controller.utils.StringUtils;
import br.com.intelector.api.model.SegOperacao;
import br.com.intelector.api.model.enums.SituacaoEnum;
import br.com.intelector.api.repository.SegOperacaoRepository;
import br.com.intelector.api.service.SegOperacaoService;

@Service
public class SegOperacaoServiceImpl implements SegOperacaoService{

	@Autowired
	private SegOperacaoRepository operacaoRepository;
		
	public SegOperacao save(SegOperacao operacao) {
		return operacaoRepository.save(operacao);
	}
	
	public Iterable<SegOperacao> saveAll(Iterable<SegOperacao> listOperacao) {
		return operacaoRepository.saveAll(listOperacao);
	}
	
	public Page<SegOperacao> findByNome(String nome, int page, int count) {
		Pageable pages = PageRequest.of(page, count);
		return operacaoRepository.findByNomeIgnoreCaseContainingAndSituacaoOrderByIdDesc(StringUtils.noNull(nome), SituacaoEnum.Ativo, pages);
	}
	
	public Optional<SegOperacao> findById(Long id) {
		return operacaoRepository.findById(id);
	}
	
	public void deleteLogical(SegOperacao operacao) {
		operacao.setSituacao(SituacaoEnum.Excluido);
		operacaoRepository.save(operacao);
	}

}
