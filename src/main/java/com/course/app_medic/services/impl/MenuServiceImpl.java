package com.course.app_medic.services.impl;

import org.springframework.stereotype.Service;

import com.course.app_medic.models.Menu;
import com.course.app_medic.repositories.IGenericRepo;
import com.course.app_medic.repositories.IMenuRepo;
import com.course.app_medic.services.IMenuService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl extends CRUDImpl<Menu, Integer> implements IMenuService {

    private final IMenuRepo repo;

    @Override
    protected IGenericRepo<Menu, Integer> getRepo() {
        return repo;
    }

    // pendiente la implementación de un servicio

}
