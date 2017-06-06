package com.zoesap.goodlife.model.bean;

/**
 * Created by maoqi on 2017/6/5.
 */

public class RechargeHistoryBean {
    private String tv_recharge_status;
    private String tv_recharge_num;
    private String tv_recharge_phone;
    private String tv_charge_date;

    public RechargeHistoryBean(String tv_recharge_status, String tv_recharge_num, String tv_recharge_phone, String tv_charge_date) {
        this.tv_recharge_status = tv_recharge_status;
        this.tv_recharge_num = tv_recharge_num;
        this.tv_recharge_phone = tv_recharge_phone;
        this.tv_charge_date = tv_charge_date;
    }

    public String getTv_recharge_status() {
        return tv_recharge_status;
    }

    public void setTv_recharge_status(String tv_recharge_status) {
        this.tv_recharge_status = tv_recharge_status;
    }

    public String getTv_recharge_num() {
        return tv_recharge_num;
    }

    public void setTv_recharge_num(String tv_recharge_num) {
        this.tv_recharge_num = tv_recharge_num;
    }

    public String getTv_recharge_phone() {
        return tv_recharge_phone;
    }

    public void setTv_recharge_phone(String tv_recharge_phone) {
        this.tv_recharge_phone = tv_recharge_phone;
    }

    public String getTv_charge_date() {
        return tv_charge_date;
    }

    public void setTv_charge_date(String tv_charge_date) {
        this.tv_charge_date = tv_charge_date;
    }
}
