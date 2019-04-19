package com.seu.cose.seu_comp.entity;

import java.util.Date;

public class UserEntity {
    private Integer id;

    private String cardid;

    private String nickname;

    private String password;

    private String phonenum;

    private String email;

    private Boolean gender;

    private Boolean accounttype;

    private Boolean avtivatestatus;

    private Date birthday;

    private Date registerdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid == null ? null : cardid.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum == null ? null : phonenum.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Boolean getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(Boolean accounttype) {
        this.accounttype = accounttype;
    }

    public Boolean getAvtivatestatus() {
        return avtivatestatus;
    }

    public void setAvtivatestatus(Boolean avtivatestatus) {
        this.avtivatestatus = avtivatestatus;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(Date registerdate) {
        this.registerdate = registerdate;
    }
}