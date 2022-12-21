package com.codeusingjava.osiagniecie.repozytoria;

import com.codeusingjava.osiagniecie.domena.Osiagniecie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OsiagniecieRepozytorium extends JpaRepository<Osiagniecie, Long> {
}
