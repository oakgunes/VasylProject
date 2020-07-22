package com.weborders.tests;

import com.weborders.pages.LoginPage;
import org.testng.annotations.Test;

public class LookAllProduct extends LoginPage {

       @Test
    public void lookingAllProduct(){
           clickOnViewAllProducts();
       }
}
