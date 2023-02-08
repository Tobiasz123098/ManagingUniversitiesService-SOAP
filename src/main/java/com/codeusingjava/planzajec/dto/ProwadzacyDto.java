package com.codeusingjava.planzajec.dto;

import com.codeusingjava.prowadzacy.domena.Tytul;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class ProwadzacyDto {

    private Long id;

    private String imie;

    private String nazwisko;

    private String email;

    @Enumerated(value = EnumType.STRING)
    private Tytul tytul;
}

