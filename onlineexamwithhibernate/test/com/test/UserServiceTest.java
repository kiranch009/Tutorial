package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.beans.UserAddress;
import com.services.UserService;

@ContextConfiguration("classpath:spring-core-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest
{
    @Autowired
    private UserService userService;

    @Test
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
        UserAddress address = userService.getUserAddress(6);
        System.out.println(address.getAddress1());

    }

}
