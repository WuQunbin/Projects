package com.gs.bean;

import java.io.Serializable;

/**
 * @author:伍群斌
 * @description:
 * @date:2018/5/19 12:05
 */
public class City implements Serializable{
    private Long cityId;
    private Long provinceId;
    private String cityName;

    public City(Long cityId, Long provinceId, String cityName) {
        this.cityId = cityId;
        this.provinceId = provinceId;
        this.cityName = cityName;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", provinceId=" + provinceId +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
