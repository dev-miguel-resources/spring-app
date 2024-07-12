package com.course.app_medic.services.impl;

import org.springframework.stereotype.Service;

import com.course.app_medic.models.Consult;
import com.course.app_medic.repositories.IGenericRepo;
import com.course.app_medic.repositories.IConsultRepo;
import com.course.app_medic.services.IConsultService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConsultServiceImpl extends CRUDImpl<Consult, Integer> implements IConsultService {

    private final IConsultRepo repo;

    @Override
    protected IGenericRepo<Consult, Integer> getRepo() {
        return repo;
    }

    // falta implementación de servicios

}

