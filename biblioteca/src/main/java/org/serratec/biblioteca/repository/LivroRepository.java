package org.serratec.biblioteca.repository;

import org.serratec.biblioteca.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository <Livro, Long>{

}
