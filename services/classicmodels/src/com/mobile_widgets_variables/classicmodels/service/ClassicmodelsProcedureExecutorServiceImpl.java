/*Generated by WaveMaker Studio*/

package com.mobile_widgets_variables.classicmodels.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavemaker.runtime.data.dao.procedure.WMProcedureExecutor;

import com.mobile_widgets_variables.classicmodels.models.procedure.*;

@Service
public class ClassicmodelsProcedureExecutorServiceImpl implements ClassicmodelsProcedureExecutorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClassicmodelsProcedureExecutorServiceImpl.class);

    @Autowired
    @Qualifier("classicmodelsWMProcedureExecutor")
    private WMProcedureExecutor procedureExecutor;

    @Transactional(value = "classicmodelsTransactionManager")
    @Override
    public ProResponse executePro(Integer _count, Integer inc) {
        Map params = new HashMap(2);

        params.put("count", _count);
        params.put("inc", inc);

        return procedureExecutor.executeNamedProcedure("pro", params, ProResponse.class);
    }

}


