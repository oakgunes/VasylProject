package com.weborders.pages;

import com.weborders.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public  abstract class BasePage { //
    //explicit wait kullandik butun class larda inherit edilecek ve sadece one time olacak
    //will be used inside every page class
    //since this variable is protected
    //it will not be visible in test classes //diger class da gorunmeyecek ama vazifesini yapacak
    protected WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

    @FindBy(linkText = "View all orders")
    private WebElement viewAllOrders;

    @FindBy(linkText = "View all products")
    private WebElement viewAllProducts;

    @FindBy(linkText = "Order")
    private WebElement order;

    public BasePage() { //we need to create the constructor method
        //we put this line to be able to use @FindBy, @FindBys.. annotations
        PageFactory.initElements(Driver.getDriver(), this);
        //will go the find the webelement from selenium libraries' pagefactory , this is url which url working now
    }
    public void clickOnViewAllOrders(){
        System.out.println("Clicking on 'View All Orders'");
        wait.until(ExpectedConditions.elementToBeClickable(viewAllOrders));
        viewAllOrders.click();
    }

    public void clickOnViewAllProducts(){
        System.out.println("Clicking on 'View All Products'");
        wait.until(ExpectedConditions.elementToBeClickable(viewAllProducts));
        viewAllProducts.click();
    }

    public void clickOnOrder(){
        System.out.println("Clicking on 'Order'");
        wait.until(ExpectedConditions.elementToBeClickable(order)).click();
    }

}
