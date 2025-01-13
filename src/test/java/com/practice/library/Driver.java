package com.practice.library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class Driver {
    private Driver(){}

    private static InheritableThreadLocal<WebDriver> driverpool=new InheritableThreadLocal<>();

    public static WebDriver getDriver(){

        String browser = System.getProperty("browser") != null ? System.getProperty("browser") : ConfigurationReader.getProperty("browser");

        if (driverpool.get() == null) {
            switch (browser) {
                case "chrome":
                    driverpool.set(new ChromeDriver());

                    break;
                case "edge":
                    driverpool.set(new EdgeDriver());
                    break;
                case "firefox":
                    driverpool.set(new FirefoxDriver());
                    break;

                case "remote-chrome":
                    try {
                        String gridAddress = "100.27.0.96";
                        URL url = new URL("http://" + gridAddress + ":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driverpool.set(new RemoteWebDriver(url, desiredCapabilities));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
        return driverpool.get();
    }

    public static void closeDriver(){
        if (driverpool.get() != null){
            driverpool.get().quit();
            driverpool.remove();
        }
    }

}
