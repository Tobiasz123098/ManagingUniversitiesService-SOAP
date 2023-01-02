package com.codeusingjava.stypendium.repozytoria;

import com.codeusingjava.stypendium.domena.Stypendium;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StypendiumRepozytorium extends JpaRepository<Stypendium, Long> {

    List<Stypendium> findByStudentId(Long id);

}
