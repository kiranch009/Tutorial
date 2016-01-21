package com.beans;

import java.sql.Date;

public class User implements java.io.Serializable
{

    private Integer userId;
    private UserAddress userAddressByMailingAddress;
    private UserAddress userAddressByPermanentAddress;
    private String userName;
    private String loginId;
    private String loginPassword;
    private String qualification;
    private String emailId;
    private String mobile;
    private Date dob;

    public Integer getUserId()
    {
        return this.userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public UserAddress getUserAddressByMailingAddress()
    {
        return this.userAddressByMailingAddress;
    }

    public void setUserAddressByMailingAddress(UserAddress userAddressByMailingAddress)
    {
        this.userAddressByMailingAddress = userAddressByMailingAddress;
    }

    public UserAddress getUserAddressByPermanentAddress()
    {
        return this.userAddressByPermanentAddress;
    }

    public void setUserAddressByPermanentAddress(UserAddress userAddressByPermanentAddress)
    {
        this.userAddressByPermanentAddress = userAddressByPermanentAddress;
    }

    public String getUserName()
    {
        return this.userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getLoginId()
    {
        return this.loginId;
    }

    public void setLoginId(String loginId)
    {
        this.loginId = loginId;
    }

    public String getLoginPassword()
    {
        return this.loginPassword;
    }

    public void setLoginPassword(String loginPassword)
    {
        this.loginPassword = loginPassword;
    }

    public String getQualification()
    {
        return this.qualification;
    }

    public void setQualification(String qualification)
    {
        this.qualification = qualification;
    }

    public String getEmailId()
    {
        return this.emailId;
    }

    public void setEmailId(String emailId)
    {
        this.emailId = emailId;
    }

    public String getMobile()
    {
        return this.mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public Date getDob()
    {
        return dob;
    }

    public void setDob(Date dob)
    {
        this.dob = dob;
    }

}
