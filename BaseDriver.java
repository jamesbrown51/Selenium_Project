package Utility;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {

    public static WebDriver driver;

    static{


       // closeRemainingBrowsers();
        Logger logger= Logger.getLogger("");//bütün loglara ulaştım
        logger.setLevel(Level.SEVERE);//sadece hataları göster
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");//chrome ana logları kaldırdı
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(2000,0));//2. ekrana atma
        driver.manage().window().maximize();//tam ekran
        driver.manage().deleteAllCookies();//sitenin senin bilgisayarı fişlemesini engelliyor

        Duration duration=Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(duration);//sayfanın kodlarının yüklenmesi için bekleme
        //bu eklenmezse selenyum sayfa yüklenene kadar bekler
        //eklendiğinde 30saniye bekler yüklenmezse hata verir.
        //yükleme 2 saniye sürerse devam eder 30 saniye beklemez

        driver.manage().timeouts().implicitlyWait(duration);//bütün webelementlerin elemente özel işlem yapılmadan önce
        //hazır hale gelmesi için verilen süre


    }

    public static void justWait(int seconds){
        MyFunction.wait(seconds);
    }
    public static void waitAndClose(){

        MyFunction.wait(5);

        driver.quit();

    }
    public static void closeRemainingBrowsers() {

        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (Exception ignored) {

        }
    }

}
