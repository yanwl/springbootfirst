package com.wlong.annotation;

import com.wlong.util.DateFormatUtil;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

@Component
public class Org {
    private String orgId;
    private String orgName;
    private String orgCode;
    private String parentCode;
    private Date updTime;
    private String updTimeStr;

    public Org(){

    }
    public Org(String orgId, String orgName, String orgCode, String parentCode) {
        this.orgId = orgId;
        this.orgName = orgName;
        this.orgCode = orgCode;
        this.parentCode = parentCode;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
        this.updTimeStr = DateFormatUtil.dateToStr(updTime);
    }

    public String getUpdTimeStr() {
        return DateFormatUtil.dateToStr(updTime);
    }

    public String getUpdTimeStrByFormat(String format) {
        return DateFormatUtil.dateToStrByFormat(updTime,format);
    }

    public void setUpdTimeStr(String updTimeStr) {
        this.updTimeStr = updTimeStr;
        this.updTime=DateFormatUtil.strToDate(updTimeStr);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Org org = (Org) o;
        return orgId.equals(org.orgId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orgId);
    }

    @Override
    public String toString() {
        return "Org{" +
                "orgId='" + orgId + '\'' +
                ", orgName='" + orgName + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", parentCode='" + parentCode + '\'' +
                ", updTime=" + updTime +
                ", updTimeStr='" + updTimeStr + '\'' +
                '}';
    }
}
