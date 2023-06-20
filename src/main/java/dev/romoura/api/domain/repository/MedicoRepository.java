package dev.romoura.api.domain.repository;

import dev.romoura.api.domain.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
   Page<Medico> findAllByAtivoTrue(Pageable pag);
}