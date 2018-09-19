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
import com.mobile_widgets_variables.classicmodels.Orders;
import com.mobile_widgets_variables.classicmodels.service.OrdersService;


/**
 * Controller object for domain model class Orders.
 * @see Orders
 */
@RestController("classicmodels.OrdersController")
@Api(value = "OrdersController", description = "Exposes APIs to work with Orders resource.")
@RequestMapping("/classicmodels/Orders")
public class OrdersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrdersController.class);

    @Autowired
	@Qualifier("classicmodels.OrdersService")
	private OrdersService ordersService;

	@ApiOperation(value = "Creates a new Orders instance.")
@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public Orders createOrders(@RequestBody Orders orders) {
		LOGGER.debug("Create Orders with information: {}" , orders);

		orders = ordersService.create(orders);
		LOGGER.debug("Created Orders with information: {}" , orders);

	    return orders;
	}

    @ApiOperation(value = "Returns the Orders instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Orders getOrders(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Orders with id: {}" , id);

        Orders foundOrders = ordersService.getById(id);
        LOGGER.debug("Orders details with id: {}" , foundOrders);

        return foundOrders;
    }

    @ApiOperation(value = "Updates the Orders instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Orders editOrders(@PathVariable("id") Integer id, @RequestBody Orders orders) throws EntityNotFoundException {
        LOGGER.debug("Editing Orders with id: {}" , orders.getOrderNumber());

        orders.setOrderNumber(id);
        orders = ordersService.update(orders);
        LOGGER.debug("Orders details with id: {}" , orders);

        return orders;
    }

    @ApiOperation(value = "Deletes the Orders instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteOrders(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Orders with id: {}" , id);

        Orders deletedOrders = ordersService.delete(id);

        return deletedOrders != null;
    }

    /**
     * @deprecated Use {@link #findOrders(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Orders instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Orders> searchOrdersByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Orders list");
        return ordersService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Orders instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Orders> findOrders(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Orders list");
        return ordersService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Orders instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Orders> filterOrders(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Orders list");
        return ordersService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportOrders(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return ordersService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Orders instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countOrders( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Orders");
		return ordersService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getOrdersAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return ordersService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/orderdetailsesForOrderNumber", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the orderdetailsesForOrderNumber instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Orderdetails> findAssociatedOrderdetailsesForOrderNumber(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated orderdetailsesForOrderNumber");
        return ordersService.findAssociatedOrderdetailsesForOrderNumber(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/orderdetailsesForOrderNumberRelation", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the orderdetailsesForOrderNumberRelation instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Orderdetails> findAssociatedOrderdetailsesForOrderNumberRelation(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated orderdetailsesForOrderNumberRelation");
        return ordersService.findAssociatedOrderdetailsesForOrderNumberRelation(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service OrdersService instance
	 */
	protected void setOrdersService(OrdersService service) {
		this.ordersService = service;
	}

}

