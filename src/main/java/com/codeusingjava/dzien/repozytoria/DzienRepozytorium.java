package com.codeusingjava.dzien.repozytoria;

import com.codeusingjava.dzien.domena.Dzien;
import com.codeusingjava.przedmiot.domena.Przedmiot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DzienRepozytorium extends JpaRepository<Dzien, Long> {

    List<Dzien> findByPlanZajecId(Long id);

}
