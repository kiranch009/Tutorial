package com.test;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.beans.User;
import com.beans.UserAddress;
import com.services.LoginService;
import com.services.UserService;

@ContextConfiguration("classpath:spring-core-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest
{
    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    //    @Test
    public void saveUserAddressTest()
    {
        UserAddress address = new UserAddress();
        address.setAddress1("220C Blueberry Ln");
        address.setCity("Chantilly");
        address.setState("VA");
        address.setZip("22033");

        userService.saveUserAddress(address);


    }

    //    @Test
    public void getUserAddressByIdTest()
    {
        UserAddress address = userService.getUserAddress(1);
        System.out.println(address.getAddress1());

    }

    @Test
    public void saveUserAndUserAddressSeperately()
    {

        User user = new User();
        user.setUserName("Test User");
        user.setLoginId("admin");
        user.setLoginPassword("admin");
        user.setMobile("2022153534");
        user.setQualification("Post graduation");
        user.setDob(new Date(System.currentTimeMillis()));
        user.setEmailId("test@testmail.com");


        UserAddress address = new UserAddress();
        address.setAddress1("220C Blueberry Ln");
        address.setCity("Chantilly");
        address.setState("VA");
        address.setZip("22033");

        userService.saveUserAddress(address);

        user.setUserAddressByMailingAddress(address);

        user.setUserAddressByPermanentAddress(address);

        userService.saveUser(user);

    }

    //    @Test
    public void saveUserAndUserAddressAtOnce()
    {

        User user = new User();
        user.setUserName("Test User1");
        user.setLoginId("admin1");
        user.setLoginPassword("admin1");
        user.setMobile("2022153534");
        user.setQualification("Post graduation");
        user.setDob(new Date(System.currentTimeMillis()));
        user.setEmailId("test@testmail.com");

        UserAddress mailingAddress = new UserAddress();
        mailingAddress.setAddress1("220C Blueberry Ln");
        mailingAddress.setCity("Chantilly");
        mailingAddress.setState("VA");
        mailingAddress.setZip("22033");
        //        userService.saveUserAddress(mailingAddress);
        user.setUserAddressByMailingAddress(mailingAddress);

        UserAddress permanentAddress = new UserAddress();
        permanentAddress.setAddress1("220C Blueberry Ln");
        permanentAddress.setCity("Chantilly");
        permanentAddress.setState("VA");
        permanentAddress.setZip("20151");
        //        userService.saveUserAddress(permanentAddress);
        user.setUserAddressByPermanentAddress(permanentAddress);

        userService.saveUser(user);
        System.out.println(user.getUserName());

    }

    //    @Test
    public void getUserTest()
    {
        List<User> list = userService.getUser("admin", "admin");
        for (User user : list)
        {
            System.out.println(user.getUserName());
        }
    }


}
