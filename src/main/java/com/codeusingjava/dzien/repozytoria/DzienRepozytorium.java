package com.codeusingjava.dzien.repozytoria;

import com.codeusingjava.dzien.domena.Dzien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DzienRepozytorium extends JpaRepository<Dzien, Long> {
}
