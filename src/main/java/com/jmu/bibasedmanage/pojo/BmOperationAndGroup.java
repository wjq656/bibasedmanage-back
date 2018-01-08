package com.jmu.bibasedmanage.pojo;

/**
 * Created by WJQ on 2018/1/8.
 */
public class BmOperationAndGroup {
    //操作名
    private String id;
    //操作组ID
    private String operationGroupId;
    //操作名
    private String name;
    //入口链接
    private String enterUrl;
    //操作状态
    private String status;
    //操作顺序
    private Integer ln;
    //操作备注
    private String remark;
    //操作组状态
    private String gstatus;
    //操作组排序
    private Integer gln;
    //操作组名称
    private String gname;
    //操作组备注
    private String gremark;

    public String getId() {
        return id;
    }

    public BmOperationAndGroup setId(String id) {
        this.id = id;
        return this;
    }

    public String getOperationGroupId() {
        return operationGroupId;
    }

    public BmOperationAndGroup setOperationGroupId(String operationGroupId) {
        this.operationGroupId = operationGroupId;
        return this;
    }

    public String getName() {
        return name;
    }

    public BmOperationAndGroup setName(String name) {
        this.name = name;
        return this;
    }

    public String getEnterUrl() {
        return enterUrl;
    }

    public BmOperationAndGroup setEnterUrl(String enterUrl) {
        this.enterUrl = enterUrl;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public BmOperationAndGroup setStatus(String status) {
        this.status = status;
        return this;
    }

    public Integer getLn() {
        return ln;
    }

    public BmOperationAndGroup setLn(Integer ln) {
        this.ln = ln;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public BmOperationAndGroup setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getGstatus() {
        return gstatus;
    }

    public BmOperationAndGroup setGstatus(String gstatus) {
        this.gstatus = gstatus;
        return this;
    }

    public Integer getGln() {
        return gln;
    }

    public BmOperationAndGroup setGln(Integer gln) {
        this.gln = gln;
        return this;
    }

    public String getGname() {
        return gname;
    }

    public BmOperationAndGroup setGname(String gname) {
        this.gname = gname;
        return this;
    }

    public String getGremark() {
        return gremark;
    }

    public BmOperationAndGroup setGremark(String gremark) {
        this.gremark = gremark;
        return this;
    }
}
