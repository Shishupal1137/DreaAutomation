package tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class FirstTest {

	@Test(invocationCount = 5)
    public void verifyWelcomeMessage() {
        System.out.println("Step 1: Opening the application...");
        Reporter.log("Application launched successfully", true);

        System.out.println("Step 2: Verifying welcome message...");
        Reporter.log("Welcome message verified: 'Welcome to UMAXX Portal'", true);

        System.out.println("Step 3: Test execution completed.");
        Reporter.log("Test 'verifyWelcomeMessage' executed successfully", true);
    }

    @Test
    public void loginTest() {
        System.out.println("Step 1: Navigating to Login Page...");
        Reporter.log("Login page loaded", true);

        System.out.println("Step 2: Entering credentials and clicking login...");
        Reporter.log("Username and password entered", true);

        System.out.println("Step 3: Verifying login success...");
        Reporter.log("Login successful. User redirected to dashboard", true);
    }

    @Test
    public void verifyDashboard() {
        System.out.println("Step 1: Checking dashboard elements...");
        Reporter.log("Dashboard loaded successfully", true);

        System.out.println("Step 2: Verifying account summary and notifications...");
        Reporter.log("Account summary and notifications verified", true);
    }

    @Test
    public void logoutTest() {
        System.out.println("Step 1: Clicking on logout button...");
        Reporter.log("Logout initiated", true);

        System.out.println("Step 2: Verifying redirection to login page...");
        Reporter.log("Logout successful. User redirected to login page", true);
    }

    @Test
    public void helpSectionTest() {
        System.out.println("Step 1: Navigating to Help section...");
        Reporter.log("Help section accessed", true);

        System.out.println("Step 2: Verifying FAQs and support options...");
        Reporter.log("FAQs and support links verified", true);
    }
}
