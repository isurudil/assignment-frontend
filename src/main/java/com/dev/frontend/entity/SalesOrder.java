package com.dev.frontend.entity;

import java.math.BigDecimal;
import java.util.Set;

public class SalesOrder extends ApiEntity{
    private String orderNumber;
    private String customerCode;
    private BigDecimal totalPrice;
    private Set<OrderLine> orderLines;

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Set<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(Set<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalesOrder that = (SalesOrder) o;

        if (orderNumber != null ? !orderNumber.equals(that.orderNumber) : that.orderNumber != null) return false;
        if (totalPrice != null ? !totalPrice.equals(that.totalPrice) : that.totalPrice != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "SalesOrder{" +
                "orderNumber='" + orderNumber + '\'' +
                ", customerCode='" + customerCode + '\'' +
                ", totalPrice=" + totalPrice +
                ", orderLines=" + orderLines.toString() +
                '}';
    }
}
