package com.codeusingjava.sala.repozytoria;

import com.codeusingjava.sala.domena.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepozytorium extends JpaRepository<Sala, Long> {
}
