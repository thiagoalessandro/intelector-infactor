package br.com.intelector.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.intelector.api.model.SegUsuario;

@Repository
public interface SegUserRepository extends JpaRepository<SegUsuario, Long>{
	Page<SegUsuario> findAll(Pageable pageable);
}
