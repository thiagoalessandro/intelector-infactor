package br.com.intelector.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.intelector.api.model.SegFuncionalidade;
import br.com.intelector.api.repository.SegFuncionalidadeRepository;

@Service
public class SegFuncionalidadeServiceImpl {

	@Autowired
	private SegFuncionalidadeRepository funcionalidadeRepository;
		
	public SegFuncionalidade save(SegFuncionalidade funcionalidade) {
		return funcionalidadeRepository.save(funcionalidade);
	}
	
	public Iterable<SegFuncionalidade> saveAll(Iterable<SegFuncionalidade> listFuncionalidade) {
		return funcionalidadeRepository.saveAll(listFuncionalidade);
	}
}
