package com.seu.cose.seu_comp.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

public class UserEntity {
    
    // Global unique identification
    private Integer id;

    // Unique Card Number
    private String cardID;

    // User nickname
    private String nickname;

    // User password for login
    private String password;

    // User mobile phone
    private String mobile;

    // User email
    // Used for account management ( e.g. Find password back, applying for re-activating account, etc.)
    private String email;

    // User-set gender
    // true: male
    // false: female
    private Boolean gender;

    // Account type
    // Administrator or Normal User
    private Boolean isAdmin;
    
    // Activate Status
    // Account may be freezed due to some illegal behaviors
    private Boolean isActivated;

    // User-set birthday
    private Date birthday;

    // User registry date
    private Date regDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer userID) {
        this.id = userID;
    }

    public String getCardid() {
        return cardID;
    }

    public void setCardid(String userCardID) {
        this.cardID = (userCardID == null) ? null : userCardID.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String userNickname) {
        this.nickname = (userNickname == null) ? null : userNickname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String userPwd) {
        this.password = (userPwd == null) ? null : userPwd.trim();
    }

    public String getPhonenum() {
        return mobile;
    }

    public void setPhonenum(String userPhone) {
        this.mobile = (userPhone == null) ? null : userPhone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String userEmail) {
        this.email = (userEmail == null) ? null : userEmail.trim();
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Boolean getAccounttype() {
        return isAdmin;
    }

    public void setAccounttype(Boolean accounttype) {
        this.isAdmin = accounttype;
    }
    
    public Boolean getActivateStatus() {
        return isActivated;
    }

    public void setActivateStatus(Boolean activatestatus) {
        this.isActivated = activatestatus;
    }

	@DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

	@DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public Date getRegisterdate() {
        return regDate;
    }

    public void setRegisterdate(Date registerDate) {
        this.regDate = registerDate;
    }
}