package tests;

import common.BaseSetup;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseSetup {

    @Test
    public void testHomePageLoading() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateTo();
        
        // Verify loading animation appears and disappears
        homePage.waitForLoadingToComplete();
        
        // Verify main content and button are visible
        Assert.assertTrue(homePage.isMainContentVisible(), 
            "Main content should be visible after loading");
        Assert.assertTrue(homePage.isMyDreamsButtonVisible(),
            "My Dreams button should be visible");
    }
    
    @Test(dependsOnMethods = "testHomePageLoading")
    public void testMyDreamsButtonOpensTabs() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateTo();
        homePage.waitForLoadingToComplete();
        
        // Click button and verify new tabs
        homePage.clickMyDreamsButton();
        Assert.assertTrue(homePage.verifyNewTabsOpened(),
            "Clicking 'My Dreams' should open dreams-diary.html and dreams-total.html in new tabs");
    }
}