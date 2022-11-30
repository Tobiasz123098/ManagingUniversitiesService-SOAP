package com.codeusingjava.grupa.repozytoria;

import com.codeusingjava.grupa.domena.Grupa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrupaRepozytorium extends JpaRepository<Grupa, Long> {
}
