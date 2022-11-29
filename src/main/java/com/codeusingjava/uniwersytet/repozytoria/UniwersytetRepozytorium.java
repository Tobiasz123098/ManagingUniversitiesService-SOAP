package com.codeusingjava.uniwersytet.repozytoria;

import com.codeusingjava.uniwersytet.domena.Uniwersytet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniwersytetRepozytorium extends JpaRepository<Uniwersytet, Long> {
}
