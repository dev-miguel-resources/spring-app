package com.course.app_medic.repositories;

import com.course.app_medic.models.Consult;

public interface IConsultRepo extends IGenericRepo<Consult, Integer> {

    // 1. una query de búsqueda de consultas mediante dni y fullname del paciente
    // 2. lista de consultas mediante un rango de fechas
    // 3. devolver el detalle de consultas mediante procedimientos almacenados para un reporte: nativeFunction
    // 4. devolver el detalle de consultas mediante procedimientos almacenados para un reporte: projection

}

