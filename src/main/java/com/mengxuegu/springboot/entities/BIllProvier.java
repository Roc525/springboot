package com.mengxuegu.springboot.entities;

/**
 * 封装新的实体 因为账单要有供应商的名称
 */
public class BIllProvier extends Bill {
    private  String providerName;

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
}
