/*Generated by WaveMaker Studio*/

package com.mobile_widgets_variables.classicmodels.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.file.model.Downloadable;

import com.mobile_widgets_variables.classicmodels.models.query.*;

public interface ClassicmodelsQueryExecutorService {

    Page<EmpResponse> executeEmp(Pageable pageable);

    Downloadable exportEmp(ExportType exportType, Pageable pageable);

}


