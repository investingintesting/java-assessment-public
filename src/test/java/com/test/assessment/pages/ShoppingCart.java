package com.test.assessment.pages;

import com.test.framework.selenium.base.SeleniumBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("cucumber-glue")
public class ShoppingCart extends SeleniumBase {


    @FindBy(linkText = "Cart Item")
    public static List<WebElement> CART_ITEMS;



    public ShoppingCart(WebDriver driver) {
        super(driver);
    }

    public int itemsInCart(){
        int count = 0;
        for(int i = 0; i > CART_ITEMS.size(); i++){
            count ++;
        }
        return count;
    }
}