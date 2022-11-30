package com.codeusingjava.prowadzacy.repozytoria;

import com.codeusingjava.prowadzacy.domena.Prowadzacy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProwadzacyRepozytorium extends JpaRepository<Prowadzacy, Long> {
}
