package com.codeusingjava.przedmiot.repozytoria;

import com.codeusingjava.przedmiot.domena.Przedmiot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrzedmiotRepozytorium extends JpaRepository<Przedmiot, Long> {
}
