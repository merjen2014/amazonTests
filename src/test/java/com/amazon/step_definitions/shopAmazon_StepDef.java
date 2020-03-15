package com.amazon.step_definitions;

import com.amazon.utilities.BrowserFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class shopAmazon_StepDef {
    WebDriver driver;
    @Given("I am on the main page of Amazon.com")
    public void i_am_on_the_main_page_of_Amazon_com() {
        
        //create a webdriver object, to work with a browser
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
    }

    @When("I search for the book Ender's Game by Orson Scott Card")
    public void i_search_for_the_book_Ender_s_Game_by_Orson_Scott_Card() {

        WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.sendKeys("Ender's Game by Orson Scott Card");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.partialLinkText("Ender's Game: Special 20th Anniversary Edition")).click();
    }


    @Then("Click on the book from the search, add the book to my cart")
    public void click_on_the_book_from_the_search_add_the_book_to_my_cart() {
        WebElement item=driver.findElement(By.partialLinkText("Hardcover"));
        item.click();
        WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
        addToCart.click();
    }

    @Then("Navigate to my cart and verify the book is there")
    public void navigate_to_my_cart_and_verify_the_book_is_there() {
        WebElement cart = driver.findElement(By.xpath("//*[@id='nav-cart-count']"));
        cart.click();
    }

    @Then("Delete the book from the cart and verify that it is no longer present")
    public void delete_the_book_from_the_cart_and_verify_that_it_is_no_longer_present() {
        System.out.println("hhh");
    }
public void teardown(){
    System.out.println("Test completed");
}
}


