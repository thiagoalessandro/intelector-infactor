package br.com.intelector.api.model.enums;

import java.util.List;

public interface EnumBasicInterface<E> {
	
	public String getName();
	
	public List<E> list();
	
}
