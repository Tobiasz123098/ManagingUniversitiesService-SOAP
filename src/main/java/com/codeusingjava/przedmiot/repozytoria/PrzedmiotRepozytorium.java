package com.codeusingjava.przedmiot.repozytoria;

import com.codeusingjava.przedmiot.domena.Przedmiot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrzedmiotRepozytorium extends JpaRepository<Przedmiot, Long> {

    List<Przedmiot> findByProwadzacyId(Long id);
}
