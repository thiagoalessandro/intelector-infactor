package br.com.intelector.api.service;

import br.com.intelector.api.model.SegMenu;

public interface SegMenuService{
			
	public SegMenu save(SegMenu menu);
	
	public Iterable<SegMenu> saveAll(Iterable<SegMenu> listMenu);
	
	public Iterable<SegMenu> findByAtivo();
}
