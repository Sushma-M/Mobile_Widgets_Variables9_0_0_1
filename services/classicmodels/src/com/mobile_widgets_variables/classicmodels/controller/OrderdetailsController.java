/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.mobile_widgets_variables.classicmodels.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.mobile_widgets_variables.classicmodels.Orderdetails;
import com.mobile_widgets_variables.classicmodels.OrderdetailsId;
import com.mobile_widgets_variables.classicmodels.service.OrderdetailsService;


/**
 * Controller object for domain model class Orderdetails.
 * @see Orderdetails
 */
@RestController("classicmodels.OrderdetailsController")
@Api(value = "OrderdetailsController", description = "Exposes APIs to work with Orderdetails resource.")
@RequestMapping("/classicmodels/Orderdetails")
public class OrderdetailsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderdetailsController.class);

    @Autowired
	@Qualifier("classicmodels.OrderdetailsService")
	private OrderdetailsService orderdetailsService;

	@ApiOperation(value = "Creates a new Orderdetails instance.")
@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public Orderdetails createOrderdetails(@RequestBody Orderdetails orderdetails) {
		LOGGER.debug("Create Orderdetails with information: {}" , orderdetails);

		orderdetails = orderdetailsService.create(orderdetails);
		LOGGER.debug("Created Orderdetails with information: {}" , orderdetails);

	    return orderdetails;
	}

@ApiOperation(value = "Returns the Orderdetails instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Orderdetails getOrderdetails(@RequestParam("orderNumber") Integer orderNumber,@RequestParam("productCode") String productCode) throws EntityNotFoundException {

        OrderdetailsId orderdetailsId = new OrderdetailsId();
        orderdetailsId.setOrderNumber(orderNumber);
        orderdetailsId.setProductCode(productCode);

        LOGGER.debug("Getting Orderdetails with id: {}" , orderdetailsId);
        Orderdetails orderdetails = orderdetailsService.getById(orderdetailsId);
        LOGGER.debug("Orderdetails details with id: {}" , orderdetails);

        return orderdetails;
    }



    @ApiOperation(value = "Updates the Orderdetails instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Orderdetails editOrderdetails(@RequestParam("orderNumber") Integer orderNumber,@RequestParam("productCode") String productCode, @RequestBody Orderdetails orderdetails) throws EntityNotFoundException {

        orderdetails.setOrderNumber(orderNumber);
        orderdetails.setProductCode(productCode);

        LOGGER.debug("Orderdetails details with id is updated with: {}" , orderdetails);

        return orderdetailsService.update(orderdetails);
    }


    @ApiOperation(value = "Deletes the Orderdetails instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteOrderdetails(@RequestParam("orderNumber") Integer orderNumber,@RequestParam("productCode") String productCode) throws EntityNotFoundException {

        OrderdetailsId orderdetailsId = new OrderdetailsId();
        orderdetailsId.setOrderNumber(orderNumber);
        orderdetailsId.setProductCode(productCode);

        LOGGER.debug("Deleting Orderdetails with id: {}" , orderdetailsId);
        Orderdetails orderdetails = orderdetailsService.delete(orderdetailsId);

        return orderdetails != null;
    }


    /**
     * @deprecated Use {@link #findOrderdetails(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Orderdetails instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Orderdetails> searchOrderdetailsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Orderdetails list");
        return orderdetailsService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Orderdetails instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Orderdetails> findOrderdetails(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Orderdetails list");
        return orderdetailsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Orderdetails instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Orderdetails> filterOrderdetails(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Orderdetails list");
        return orderdetailsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportOrderdetails(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return orderdetailsService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Orderdetails instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countOrderdetails( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Orderdetails");
		return orderdetailsService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getOrderdetailsAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return orderdetailsService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service OrderdetailsService instance
	 */
	protected void setOrderdetailsService(OrderdetailsService service) {
		this.orderdetailsService = service;
	}

}

