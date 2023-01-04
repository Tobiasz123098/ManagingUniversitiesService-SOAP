package com.codeusingjava.prowadzacy.repozytoria;

import com.codeusingjava.prowadzacy.domena.Prowadzacy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProwadzacyRepozytorium extends JpaRepository<Prowadzacy, Long> {

    List<Prowadzacy> findByUniwersytetId(Long id);
}
