package tests;

import common.BaseSetup;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DreamTotalPage;

public class DreamTotalTest extends BaseSetup {
    
    @Test
    public void testDreamTotalPage() {
        driver.get("https://arifindam.github.io/mvDreams/dreams-total.html");
        
        
        DreamTotalPage totalPage = new DreamTotalPage(driver);
        
           }
}