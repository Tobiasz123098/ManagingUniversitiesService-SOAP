package com.codeusingjava.stypendium.repozytoria;

import com.codeusingjava.stypendium.domena.Stypendium;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StypendiumRepozytorium extends JpaRepository<Stypendium, Long> {
}
