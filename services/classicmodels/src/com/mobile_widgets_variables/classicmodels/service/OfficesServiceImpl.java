/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.mobile_widgets_variables.classicmodels.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.mobile_widgets_variables.classicmodels.Employees;
import com.mobile_widgets_variables.classicmodels.Offices;


/**
 * ServiceImpl object for domain model class Offices.
 *
 * @see Offices
 */
@Service("classicmodels.OfficesService")
@Validated
public class OfficesServiceImpl implements OfficesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OfficesServiceImpl.class);

    @Lazy
    @Autowired
	@Qualifier("classicmodels.EmployeesService")
	private EmployeesService employeesService;

    @Autowired
    @Qualifier("classicmodels.OfficesDao")
    private WMGenericDao<Offices, String> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Offices, String> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "classicmodelsTransactionManager")
    @Override
	public Offices create(Offices offices) {
        LOGGER.debug("Creating a new Offices with information: {}", offices);
        Offices officesCreated = this.wmGenericDao.create(offices);
        if(officesCreated.getEmployeesesForOfficeCode() != null) {
            for(Employees employeesesForOfficeCode : officesCreated.getEmployeesesForOfficeCode()) {
                employeesesForOfficeCode.setOfficesByOfficeCode(officesCreated);
                LOGGER.debug("Creating a new child Employees with information: {}", employeesesForOfficeCode);
                employeesService.create(employeesesForOfficeCode);
            }
        }

        if(officesCreated.getEmployeesesForOfficeCodeRelation() != null) {
            for(Employees employeesesForOfficeCodeRelation : officesCreated.getEmployeesesForOfficeCodeRelation()) {
                employeesesForOfficeCodeRelation.setOfficesByOfficeCodeRelation(officesCreated);
                LOGGER.debug("Creating a new child Employees with information: {}", employeesesForOfficeCodeRelation);
                employeesService.create(employeesesForOfficeCodeRelation);
            }
        }
        return officesCreated;
    }

	@Transactional(readOnly = true, value = "classicmodelsTransactionManager")
	@Override
	public Offices getById(String officesId) throws EntityNotFoundException {
        LOGGER.debug("Finding Offices by id: {}", officesId);
        Offices offices = this.wmGenericDao.findById(officesId);
        if (offices == null){
            LOGGER.debug("No Offices found with id: {}", officesId);
            throw new EntityNotFoundException(String.valueOf(officesId));
        }
        return offices;
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
	@Override
	public Offices findById(String officesId) {
        LOGGER.debug("Finding Offices by id: {}", officesId);
        return this.wmGenericDao.findById(officesId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "classicmodelsTransactionManager")
	@Override
	public Offices update(Offices offices) throws EntityNotFoundException {
        LOGGER.debug("Updating Offices with information: {}", offices);
        this.wmGenericDao.update(offices);

        String officesId = offices.getOfficeCode();

        return this.wmGenericDao.findById(officesId);
    }

    @Transactional(value = "classicmodelsTransactionManager")
	@Override
	public Offices delete(String officesId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Offices with id: {}", officesId);
        Offices deleted = this.wmGenericDao.findById(officesId);
        if (deleted == null) {
            LOGGER.debug("No Offices found with id: {}", officesId);
            throw new EntityNotFoundException(String.valueOf(officesId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "classicmodelsTransactionManager")
	@Override
	public Page<Offices> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Offices");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Page<Offices> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Offices");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service classicmodels for table Offices to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "classicmodelsTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Page<Employees> findAssociatedEmployeesesForOfficeCode(String officeCode, Pageable pageable) {
        LOGGER.debug("Fetching all associated employeesesForOfficeCode");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("officesByOfficeCode.officeCode = '" + officeCode + "'");

        return employeesService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Page<Employees> findAssociatedEmployeesesForOfficeCodeRelation(String officeCode, Pageable pageable) {
        LOGGER.debug("Fetching all associated employeesesForOfficeCodeRelation");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("officesByOfficeCodeRelation.officeCode = '" + officeCode + "'");

        return employeesService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service EmployeesService instance
	 */
	protected void setEmployeesService(EmployeesService service) {
        this.employeesService = service;
    }

}

