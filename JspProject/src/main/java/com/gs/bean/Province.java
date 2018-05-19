package com.gs.bean;

import java.io.Serializable;

/**
 * @author:伍群斌
 * @description:
 * @date:2018/5/19 12:05
 */
public class Province implements Serializable{
    private Long provinceId;
    private String provinceName;

    public Province(Long provinceId, String provinceName) {
        this.provinceId = provinceId;
        this.provinceName = provinceName;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    @Override
    public String toString() {
        return "Province{" +
                "provinceId=" + provinceId +
                ", provinceName='" + provinceName + '\'' +
                '}';
    }
}
