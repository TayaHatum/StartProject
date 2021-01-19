package com.telran.tests;


import com.telran.application.DataProvider;
import com.telran.models.ModelBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestExample extends TestBase{

    @Test
    public void testForLogger(){
        logger.info("Hello Wiki");

    }

    @Test
    public void testForScreenshots(){

        String screen = "src/test/screenshots/screen-"+(System.currentTimeMillis()/1000%3600)+".png";
        app.getModelBase().takeScreenshot(screen);
    }
    @Test
    public void testForListener(){
        app.getModelBase().click(By.cssSelector("[type='search']"));
    }
    @Test(dataProvider = "valid", dataProviderClass = DataProvider.class)
    public void testForDataProvider(String fild1, String fild2){
        ModelBase modelBase = new ModelBase();
        app.getModelBase().type(modelBase.withFild1(fild1).withFild2(fild2));
        System.out.println(modelBase.toString());
    }
    @Test(dataProvider = "validFromFile", dataProviderClass = DataProvider.class)
    public void testForDataProviderFromFile(ModelBase modelBase){
        app.getModelBase().type(modelBase);
        System.out.println(modelBase);
    }
}
