package com.planit.selenium.factory.abstractFactory;

import com.planit.selenium.constants.DriverType;
import com.planit.selenium.factory.ChromeDriverManager;
import com.planit.selenium.factory.DriverManager;
import com.planit.selenium.factory.FirefoxDriverManager;

public class DriverManagerFactoryAbstract {

    public static DriverManagerAbstract getManager(DriverType driverType){
        switch (driverType){
            case CHROME -> {
                return new ChromeDriverManagerAbstract();
            }
            case FIREFOX -> {
                return new FirefoxDriverManagerAbstract();
            }
            default -> throw new IllegalStateException("Unexpected value: " + driverType);
        }
    }
}
