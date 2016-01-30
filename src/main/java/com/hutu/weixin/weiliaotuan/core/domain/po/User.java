package com.hutu.weixin.weiliaotuan.core.domain.po;

import java.util.Date;

public class User {
    private Integer id;

    private String useraccount;

    private String userpassword;

    private String userpasswordflag;

    private Date useraccountcreatedate;

    private Date useraccountexpiredate;

    private Date userpasswordexpiredate;

    private Date useraccountlockdate;

    private String useraccountenable;

    private Long usedbalance;

    private Integer largessepoint;

    private Integer availablepoint;
    
    private String userimageurl;
    
    private String nickname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUseraccount() {
        return useraccount;
    }

    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount == null ? null : useraccount.trim();
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword == null ? null : userpassword.trim();
    }

    public String getUserpasswordflag() {
        return userpasswordflag;
    }

    public void setUserpasswordflag(String userpasswordflag) {
        this.userpasswordflag = userpasswordflag == null ? null : userpasswordflag.trim();
    }

    public Date getUseraccountcreatedate() {
        return useraccountcreatedate;
    }

    public void setUseraccountcreatedate(Date useraccountcreatedate) {
        this.useraccountcreatedate = useraccountcreatedate;
    }

    public Date getUseraccountexpiredate() {
        return useraccountexpiredate;
    }

    public void setUseraccountexpiredate(Date useraccountexpiredate) {
        this.useraccountexpiredate = useraccountexpiredate;
    }

    public Date getUserpasswordexpiredate() {
        return userpasswordexpiredate;
    }

    public void setUserpasswordexpiredate(Date userpasswordexpiredate) {
        this.userpasswordexpiredate = userpasswordexpiredate;
    }

    public Date getUseraccountlockdate() {
        return useraccountlockdate;
    }

    public void setUseraccountlockdate(Date useraccountlockdate) {
        this.useraccountlockdate = useraccountlockdate;
    }

    public String getUseraccountenable() {
        return useraccountenable;
    }

    public void setUseraccountenable(String useraccountenable) {
        this.useraccountenable = useraccountenable == null ? null : useraccountenable.trim();
    }

    public Long getUsedbalance() {
        return usedbalance;
    }

    public void setUsedbalance(Long usedbalance) {
        this.usedbalance = usedbalance;
    }

    public Integer getLargessepoint() {
        return largessepoint;
    }

    public void setLargessepoint(Integer largessepoint) {
        this.largessepoint = largessepoint;
    }

    public Integer getAvailablepoint() {
        return availablepoint;
    }

    public void setAvailablepoint(Integer availablepoint) {
        this.availablepoint = availablepoint;
    }

	public String getUserimageurl() {
		return userimageurl;
	}

	public void setUserimageurl(String userimageurl) {
		this.userimageurl = userimageurl;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}