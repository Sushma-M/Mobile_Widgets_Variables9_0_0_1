/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.mobile_widgets_variables.classicmodels;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Payments generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`payments`")
@IdClass(PaymentsId.class)
public class Payments implements Serializable {

    private Integer customerNumber;
    private String checkNumber;
    private Date paymentDate;
    private BigDecimal amount;
    private Customers customersByCustomerNumber;
    private Customers customersByCustomerNumberRelation;

    @Id
    @Column(name = "`customerNumber`", nullable = false, scale = 0, precision = 10)
    public Integer getCustomerNumber() {
        return this.customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Id
    @Column(name = "`checkNumber`", nullable = false, length = 50)
    public String getCheckNumber() {
        return this.checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    @Column(name = "`paymentDate`", nullable = false)
    public Date getPaymentDate() {
        return this.paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Column(name = "`amount`", nullable = false, scale = 9, precision = 22)
    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`customerNumber`", referencedColumnName = "`customerNumber`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`payments_ibfk_1`"))
    public Customers getCustomersByCustomerNumber() {
        return this.customersByCustomerNumber;
    }

    public void setCustomersByCustomerNumber(Customers customersByCustomerNumber) {
        if(customersByCustomerNumber != null) {
            this.customerNumber = customersByCustomerNumber.getCustomerNumber();
        }

        this.customersByCustomerNumber = customersByCustomerNumber;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`customerNumber`", referencedColumnName = "`customerNumber`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FKrca8yd4cwdd9loosac8txb9sg`"))
    public Customers getCustomersByCustomerNumberRelation() {
        return this.customersByCustomerNumberRelation;
    }

    public void setCustomersByCustomerNumberRelation(Customers customersByCustomerNumberRelation) {
        if(customersByCustomerNumberRelation != null) {
            this.customerNumber = customersByCustomerNumberRelation.getCustomerNumber();
        }

        this.customersByCustomerNumberRelation = customersByCustomerNumberRelation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payments)) return false;
        final Payments payments = (Payments) o;
        return Objects.equals(getCustomerNumber(), payments.getCustomerNumber()) &&
                Objects.equals(getCheckNumber(), payments.getCheckNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerNumber(),
                getCheckNumber());
    }
}

