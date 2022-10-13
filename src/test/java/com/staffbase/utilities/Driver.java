package com.staffbase.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){

    }


    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    public static WebDriver getDriver() {  //Singleton Design Pattern

        if(driverPool.get() == null){
            String browserType = ConfigurationReader.getProperty("browser");


            switch (browserType){

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                // cases for other browser types can be added here as necessary
            }
        }

        return driverPool.get();

    }


    public static void closeDriver(){
        if(driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.set(null);
        }
    }

}
