package com.test.quickstart;	

import org.junit.runner.RunWith;		
import cucumber.api.CucumberOptions;		
import cucumber.api.junit.Cucumber;		

@RunWith(Cucumber.class)

@CucumberOptions(features="Features",glue={"StepDefn"})

public class Runner {
public static void main(String[] args) {
	System.out.println("inside runner");
}
}
