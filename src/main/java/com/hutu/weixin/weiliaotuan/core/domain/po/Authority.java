package com.hutu.weixin.weiliaotuan.core.domain.po;

import java.util.Date;

public class Authority {
    private Integer id;

    private String authorityname;

    private String authoritycode;

    private String enabled;

    private Date createdate;

    private String creator;

    private Integer creatorid;

    private Date modifydate;

    private String modifer;

    private Integer modiferid;

    private String authorityurl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthorityname() {
        return authorityname;
    }

    public void setAuthorityname(String authorityname) {
        this.authorityname = authorityname == null ? null : authorityname.trim();
    }

    public String getAuthoritycode() {
        return authoritycode;
    }

    public void setAuthoritycode(String authoritycode) {
        this.authoritycode = authoritycode == null ? null : authoritycode.trim();
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled == null ? null : enabled.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Integer getCreatorid() {
        return creatorid;
    }

    public void setCreatorid(Integer creatorid) {
        this.creatorid = creatorid;
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    public String getModifer() {
        return modifer;
    }

    public void setModifer(String modifer) {
        this.modifer = modifer == null ? null : modifer.trim();
    }

    public Integer getModiferid() {
        return modiferid;
    }

    public void setModiferid(Integer modiferid) {
        this.modiferid = modiferid;
    }

    public String getAuthorityurl() {
        return authorityurl;
    }

    public void setAuthorityurl(String authorityurl) {
        this.authorityurl = authorityurl == null ? null : authorityurl.trim();
    }
}