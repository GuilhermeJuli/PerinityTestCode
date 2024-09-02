package com.api.perinitytestcode.repository;

import com.api.perinitytestcode.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
