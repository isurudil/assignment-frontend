package com.dev.frontend.entity;

import java.math.BigDecimal;

public class Customer extends BaseEntity {

    private String code;
    private String name;
    private String address;
    private String phoneNo1;
    private String phoneNo2;
    private BigDecimal creditLimit;
    private BigDecimal currentCredit;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo1() {
        return phoneNo1;
    }

    public void setPhoneNo1(String phoneNo1) {
        this.phoneNo1 = phoneNo1;
    }

    public String getPhoneNo2() {
        return phoneNo2;
    }

    public void setPhoneNo2(String phoneNo2) {
        this.phoneNo2 = phoneNo2;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getCurrentCredit() {
        return currentCredit;
    }

    public void setCurrentCredit(BigDecimal currentCredit) {
        this.currentCredit = currentCredit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (address != null ? !address.equals(customer.address) : customer.address != null) return false;
        if (code != null ? !code.equals(customer.code) : customer.code != null) return false;
        if (creditLimit != null ? !creditLimit.equals(customer.creditLimit) : customer.creditLimit != null)
            return false;
        if (currentCredit != null ? !currentCredit.equals(customer.currentCredit) : customer.currentCredit != null)
            return false;
        if (phoneNo1 != null ? !phoneNo1.equals(customer.phoneNo1) : customer.phoneNo1 != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNo1='" + phoneNo1 + '\'' +
                ", phoneNo2='" + phoneNo2 + '\'' +
                ", creditLimit=" + creditLimit +
                ", currentCredit=" + currentCredit +
                '}';
    }
}
