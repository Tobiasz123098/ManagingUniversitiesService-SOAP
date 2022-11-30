package com.codeusingjava.ocena.repozytoria;

import com.codeusingjava.ocena.domena.Ocena;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OcenaRepozytorium extends JpaRepository<Ocena, Long> {
}
