package com.codeusingjava.planzajec.repozytoria;

import com.codeusingjava.planzajec.domena.PlanZajec;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanZajecRepozytorium extends JpaRepository<PlanZajec, Long> {
}
