package br.com.intelector.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.intelector.api.model.SegMenu;
import br.com.intelector.api.model.enums.SituacaoEnum;
import br.com.intelector.api.repository.SegMenuRepository;
import br.com.intelector.api.service.SegMenuService;

@Service
public class SegMenuServiceImpl implements SegMenuService{

	@Autowired
	private SegMenuRepository menuRepository;
		
	public SegMenu save(SegMenu menu) {
		return menuRepository.save(menu);
	}
	
	public Iterable<SegMenu> saveAll(Iterable<SegMenu> listMenu) {
		return menuRepository.saveAll(listMenu);
	}
	
	public Iterable<SegMenu> findByAtivo() {
		return menuRepository.findBySituacao(SituacaoEnum.Ativo);
	}
}
