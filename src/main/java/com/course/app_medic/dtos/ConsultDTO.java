package com.course.app_medic.dtos;

import java.time.LocalDateTime;
import java.util.List;

import com.course.app_medic.models.Medic;
import com.course.app_medic.models.Patient;
import com.course.app_medic.models.Specialty;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ConsultDTO {

    @EqualsAndHashCode.Include
    private Integer idConsult;

    @NotNull
    private Patient patient;

    @NotNull
    private Medic medic;

    @NotNull
    private Specialty specialty;

    @NotNull
    private LocalDateTime consultDate;

    @NotNull
    private String numConsult;

    // referencia faltante
    @NotNull
    private List<ConsultDetailDTO> details;

}
