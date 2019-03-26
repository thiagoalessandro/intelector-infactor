package br.com.intelector.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.intelector.api.model.SegUsuario;
import br.com.intelector.api.repository.SegUserRepository;

@Service
public class SegUserServiceImpl {
	
	@Autowired
	private SegUserRepository userRepository;
	
	public SegUsuario save(SegUsuario user) {
		return userRepository.save(user);
	}
	
	public Iterable<SegUsuario> saveAll(Iterable<SegUsuario> listUsuario) {
		return userRepository.saveAll(listUsuario);
	}
	
}
