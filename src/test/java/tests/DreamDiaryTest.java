package tests;

import common.BaseSetup;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DreamDiaryPage;

public class DreamDiaryTest extends BaseSetup {
    
    @Test
    public void testDreamDiaryPage() {
        DreamDiaryPage diaryPage = new DreamDiaryPage(driver);
        diaryPage.navigateTo();
        
 
        Assert.assertEquals(diaryPage.getDreamEntryCount(), 10, 
            "Mismatch in dream entries count");
   
        Assert.assertTrue(diaryPage.verifyAllDreamTypesValid(),
            "Invalid dream type detected");
        
        
        Assert.assertTrue(diaryPage.verifyAllRowsFilled(),
            "Empty cells found in some rows");
        

        Assert.assertTrue(diaryPage.isRecurringDream("Flying over mountains"),
            "Flying over mountains should be recurring");
        Assert.assertTrue(diaryPage.isRecurringDream("Lost in maze"),
            "Lost in maze should be recurring");
    }
}