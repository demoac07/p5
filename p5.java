package allPro;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class p5 {

	    public static void main(String[] args) {
	       //System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
	        WebDriver driver = new ChromeDriver();
	        
	        
	        String csvFile = "C:\\Users\\shiva\\Desktop\\testdata.csv";
	        
	        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
	            String line;
	           
	            br.readLine(); 
	            while ((line = br.readLine()) != null) {

	                String[] data = line.split(",");
	                String username = data[0];
	                String password = data[1];

	             
	                driver.get("https://www.facebook.com");

	                driver.findElement(By.id("email")).sendKeys(username); 
	                driver.findElement(By.id("pass")).sendKeys(password); 
	                driver.findElement(By.name("login")).click(); 

	        
	                try {
	                 
	                    if (driver.getTitle().contains("Facebook")) {
	                        System.out.println("Login successful for user: " + username);
	                    } else {
	                        System.out.println("Login failed for user: " + username);
	                    }
	                } catch (Exception e) {
	                    System.out.println("Error occurred while checking login: " + e.getMessage());
	                }

	              
	                Thread.sleep(2000); 
	            }
	        } catch (IOException | InterruptedException e) {
	            System.out.println("Error: " + e.getMessage());
	        } finally {
	            
	            driver.quit();
	        }
	    }
	}