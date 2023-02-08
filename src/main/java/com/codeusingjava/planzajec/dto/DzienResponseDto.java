package com.codeusingjava.planzajec.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DzienResponseDto {

    private Long id;

    private LocalDate dataDnia;

    private List<PrzedmiotDto> przedmiotDto = new ArrayList<>();
}
