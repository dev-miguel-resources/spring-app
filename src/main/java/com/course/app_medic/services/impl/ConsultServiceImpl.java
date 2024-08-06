package com.course.app_medic.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.course.app_medic.dtos.ConsultProcDTO;
import com.course.app_medic.dtos.IConsultProcDTO;
import com.course.app_medic.models.Consult;
import com.course.app_medic.models.Exam;
import com.course.app_medic.repositories.IGenericRepo;
import com.course.app_medic.repositories.IConsultExamRepo;
import com.course.app_medic.repositories.IConsultRepo;
import com.course.app_medic.services.IConsultService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConsultServiceImpl extends CRUDImpl<Consult, Integer> implements IConsultService {

    private final IConsultRepo consultRepo;
    private final IConsultExamRepo ceRepo;

    @Override
    protected IGenericRepo<Consult, Integer> getRepo() {
        return consultRepo;
    }

    // transacción entre 3 entes
    @Transactional
    @Override
    public Consult saveTransactional(Consult consult, List<Exam> exams) {
        // insertamos las consultas con su lista de exámenes
        consultRepo.save(consult);
        // list exams
        exams.forEach(ex -> ceRepo.saveExam(consult.getIdConsult(), ex.getIdExam()));

        return consult;
    }

    @Override
    public List<Consult> search(String dni, String fullname) {
        return consultRepo.search(dni, fullname);
    }

    @Override
    public List<Consult> searchByDates(LocalDateTime date1, LocalDateTime date2) {
        final int OFFSET_DAYS = 1;
        return consultRepo.searchByDates(date1, date2.plusDays(OFFSET_DAYS));
    }

    @Override
    public List<ConsultProcDTO> callProcedureOrFunctionNative() {
        List<ConsultProcDTO> lst = new ArrayList<>();

        // [3, "02/09/2024"],
        // [4, "03/09/2024"],

        consultRepo.callProcedureOrFunctionNative().forEach(e -> {
            ConsultProcDTO dto = new ConsultProcDTO();
            dto.setQuantity((Integer) e[0]);
            dto.setConsultdate((String) e[1]);

            lst.add(dto);
        });

        return lst;
    }

    @Override
    public List<IConsultProcDTO> callProcedureOrFunctionProjection() {
        return consultRepo.callProcedureOrFunctionProjection();
    }

    @Override
    public byte[] generateReport() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateReport'");
    }

}
