package com.codeusingjava.osiagniecie.repozytoria;

import com.codeusingjava.osiagniecie.domena.Osiagniecie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OsiagniecieRepozytorium extends JpaRepository<Osiagniecie, Long> {

    List<Osiagniecie> findByStudentId(Long id);

}
