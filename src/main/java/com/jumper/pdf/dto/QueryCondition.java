package com.jumper.pdf.dto;

import java.io.Serializable;

public class QueryCondition implements Serializable {

    private String mobile;
    private String name;
    private String queryTime;
    private String documentName;   //生成文档的标题
    private Object extend; //预留扩展项

    private String recordId;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public QueryCondition(String mobile, String queryTime, String documentName, Object extend) {
        this.mobile = mobile;
        this.queryTime = queryTime;
        this.documentName = documentName;
        this.extend = extend;
    }

    public QueryCondition() {
    }

    public QueryCondition(String recordId) {
        this.recordId = recordId;
    }

    public QueryCondition(String name, String mobile, String queryTime) {
        this.name=name;
        this.mobile = mobile;
        this.queryTime = queryTime;
    }
    public QueryCondition(String mobile, String queryTime) {
        this.mobile = mobile;
        this.queryTime = queryTime;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(String queryTime) {
        this.queryTime = queryTime;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public Object getExtend() {
        return extend;
    }

    public void setExtend(Object extend) {
        this.extend = extend;
    }
}
