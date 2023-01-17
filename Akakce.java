package Projeler._01_Proje;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Akakce extends BaseDriver {
    @Test
    public void AkakceTest(){
        driver.get("https://www.akakce.com/");

        WebElement checkPage=driver.findElement(By.linkText("Akakce.com"));
        Assert.assertTrue(checkPage.getText().contains("Akakce.com"));
        //open account
        WebElement openAccount= driver.findElement(By.linkText("Hesap Aç"));
        openAccount.click();justWait(1);
        WebElement name= driver.findElement(By.xpath("//label[text()='Ad *']//following::input[1]"));
        name.sendKeys("Test");justWait(1);
        WebElement surName= driver.findElement(By.xpath("//label[text()='Ad *']//following::input[2]"));
        surName.sendKeys("Test");justWait(1);
        WebElement mail= driver.findElement(By.xpath("//label[text()='Ad *']//following::input[3]"));
        mail.sendKeys("testj@gmail.com");justWait(1);
        WebElement remail= driver.findElement(By.xpath("//label[text()='Ad *']//following::input[4]"));
        remail.sendKeys("testj@gmail.com");justWait(1);
        WebElement pass= driver.findElement(By.xpath("//label[text()='Ad *']//following::input[5]"));
        pass.sendKeys("Test1234");justWait(1);
        WebElement repass= driver.findElement(By.xpath("//label[text()='Ad *']//following::input[6]"));
        repass.sendKeys("Test1234");justWait(1);
        WebElement man= driver.findElement(By.xpath("//label[text()='Ad *']//following::input[8]"));
        man.click();justWait(1);

        WebElement providanceMenu= driver.findElement(By.name("locpr"));
        Select locationProvidance=new Select(providanceMenu);
        locationProvidance.selectByValue("35");justWait(1);
        WebElement districtMenu= driver.findElement(By.name("locds"));
        Select locationDistrict=new Select(districtMenu);
        locationDistrict.selectByVisibleText("Balçova");justWait(1);

        WebElement birthDate= driver.findElement(By.name("bd"));
        Select date=new Select(birthDate);
        date.selectByVisibleText("1");justWait(1);
        WebElement birthMonth= driver.findElement(By.name("bm"));
        Select month=new Select(birthMonth);
        month.selectByVisibleText("1");justWait(1);
        WebElement birthYear= driver.findElement(By.name("by"));
        Select year=new Select(birthYear);
        year.selectByVisibleText("2000");justWait(1);

        WebElement checkbBox=driver.findElement(By.xpath("//span[@class='chbx_v8']/label/input"));
        checkbBox.click();justWait(1);
        WebElement submitNewAccount= driver.findElement(By.xpath("//input[@type='submit' and @value='Hesap aç']"));
        submitNewAccount.click();justWait(1);

        //accout check
        WebElement nameCheck= driver.findElement(By.xpath("//a[@href='/akakcem/' and @rel='nofollow' and text()='Test']"));
        Assert.assertTrue(nameCheck.getText().contains("Test"));
        nameCheck.click();justWait(1);
        //order check
        WebElement myOrders= driver.findElement(By.linkText("Siparişlerim"));
        myOrders.click();justWait(1);
        WebElement noOrderCheck= driver.findElement(By.xpath("//*[@id='user-order-info']"));
        Assert.assertTrue(noOrderCheck.getText().contains("Kayıtlı siparişiniz bulunmuyor."));
        WebElement nameCheck1= driver.findElement(By.xpath("//a[@href='/akakcem/' and @rel='nofollow' and text()='Test']"));
        nameCheck1.click();justWait(1);
        //message check
        WebElement myMessages= driver.findElement(By.linkText("Mesajlarım"));
        myMessages.click();justWait(1);
        WebElement noMessage= driver.findElement(By.xpath("//*[text()='Listelenecek mesaj bulunamadı.']"));
        Assert.assertTrue(noMessage.getText().contains("istelenecek mesaj bulunamadı"));
        WebElement nameCheck2= driver.findElement(By.xpath("//a[@href='/akakcem/' and @rel='nofollow' and text()='Test']"));
        nameCheck2.click();justWait(1);
        //delete account
        WebElement deleteAccount= driver.findElement(By.xpath("//*[text()='Hesabımı Sil']"));
        deleteAccount.click();justWait(1);
        WebElement deletePass= driver.findElement(By.xpath("//*[@onfocusout='ControlPassword();']"));
        deletePass.sendKeys("Test1234");justWait(1);
        WebElement delete= driver.findElement(By.xpath("//*[@value='Hesabımı sil']"));
        delete.click();justWait(1);
        WebElement accountDeleted= driver.findElement(By.xpath("//*[text()='Hesabın silindi.']"));
        Assert.assertTrue(accountDeleted.getText().contains("silindi"));justWait(1);


        waitAndClose();


    }
}
