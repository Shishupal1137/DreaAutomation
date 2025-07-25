package tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ThirdTest {

  @Test
  public void testLogin() {
    System.out.println("Executing testLogin - console log");
    Reporter.log("testLogin executed - reported log");
  }

  @Test
  public void testSearchProduct() {
    System.out.println("Executing testSearchProduct - console log");
    Reporter.log("testSearchProduct executed - reported log");
  }

  @Test
  public void testAddToCart() {
    System.out.println("Executing testAddToCart - console log");
    Reporter.log("testAddToCart executed - reported log");
  }

  @Test
  public void testCheckout() {
    System.out.println("Executing testCheckout - console log");
    Reporter.log("testCheckout executed - reported log");

    // Intentional failure for demonstration
    Assert.fail("❌ testCheckout failed due to payment gateway error.");
  }

  @Test
  public void testLogout() {
    System.out.println("Executing testLogout - console log");
    Reporter.log("testLogout executed - reported log");
  }
}
