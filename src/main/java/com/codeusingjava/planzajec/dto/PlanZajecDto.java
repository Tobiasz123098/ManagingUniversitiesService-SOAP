package com.codeusingjava.planzajec.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlanZajecDto {

    private Long id;

    private LocalDate dzienOd;

    private LocalDate dzienDo;

    private List<DzienResponseDto> listaDni = new ArrayList<>();


}
