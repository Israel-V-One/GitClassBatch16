package HomeWork2;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1 {
    @Test
    public void task1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        Assert.assertTrue(driver.getTitle().equals("Web Orders Login"));

        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");

        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");

        WebElement login = driver.findElement(By.xpath("//input[@value='Login']"));
        login.click();

        Thread.sleep(2000);
        Assert.assertTrue(driver.getTitle().equals("Web Orders"));

        WebElement header = driver.findElement(By.tagName("h2"));
        Assert.assertTrue(BrowserUtils.getText(header).equals("List of All Orders"));

    }

    @Test
    public void task2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        Assert.assertTrue(driver.getTitle().equals("Web Orders Login"));

        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");

        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");

        WebElement login = driver.findElement(By.xpath("//input[@value='Login']"));
        login.click();

        WebElement viewAllProd = driver.findElement(By.linkText("View all products"));
        viewAllProd.click();
        viewAllProd = driver.findElement(By.linkText("View all products"));
        Thread.sleep(2000);
        Assert.assertFalse(viewAllProd.isSelected());

        WebElement header1 = driver.findElement(By.tagName("h2"));
        Assert.assertTrue(BrowserUtils.getText(header1).equals("List of Products"));

        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("Products"));

    }
    @Test
    public void task3(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        Assert.assertTrue(driver.getTitle().equals("Web Orders Login"));

        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");

        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");

        WebElement login = driver.findElement(By.xpath("//input[@value='Login']"));
        login.click();

        List<WebElement> orderLinks = driver.findElements(By.xpath("//ul[@class='menu']//a"));
        List<String> expectedLinks = Arrays.asList("Default.aspx","Products.aspx","Process.aspx");


        for(int i=0; i<orderLinks.size(); i++){
        Assert.assertTrue(orderLinks.get(i).getAttribute("href").contains(expectedLinks.get(i)));
        }

    }
    @Test
    public void task4(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");

        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");

        WebElement login = driver.findElement(By.xpath("//input[@value='Login']"));
        login.click();

        WebElement orderbutton= driver.findElement(By.linkText("Order"));
        orderbutton.click();

        WebElement productdropdown = driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
        Select product = new Select(productdropdown);
        product.selectByVisibleText("ScreenSaver");

        WebElement quantity = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantity.clear();
        quantity.sendKeys("5");

        WebElement customerName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        customerName.sendKeys("CodeFish IT School");

        WebElement street = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
        street.sendKeys("2200 E devon");

        WebElement city = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        city.sendKeys("Des Plaines");

        WebElement state = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
        state.sendKeys("Illinois");

        WebElement zipcode = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
        zipcode.sendKeys("60018");

        WebElement mastercard = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_1']"));
        mastercard.click();

        WebElement cardNum = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        cardNum.sendKeys("444993876233");

        WebElement expire = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        expire.sendKeys("03/24");

        WebElement processbutton = driver.findElement(By.linkText("Process"));
        processbutton.click();

        WebElement newOrderMessage = driver.findElement(By.tagName("strong"));
        Assert.assertTrue(BrowserUtils.getText(newOrderMessage).equals("New order has been successfully added."));

        WebElement viewallOrders = driver.findElement(By.linkText("View all orders"));
        viewallOrders.click();

        List<WebElement> orders = driver.findElements(By.tagName("tr"));
        List<String> codeForder = Arrays.asList("CodeFish IT School","ScreenSaver","5","06/03/2023","2200 E devon","Des Plaines","Illinois","60018","MasterCard","444993876233");


        for (int i=2; i<orders.size();i++){
            Assert.assertTrue (BrowserUtils.getText(orders.get(i)).contains(codeForder.get(i)));

            break;

        }



    }

}
