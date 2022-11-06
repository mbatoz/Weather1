import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class mbatoz {
    /*


    /TC_1_1  - Тест кейс:
    //1. Открыть страницу https://openweathermap.org/
    //2. Набрать в строке поиска город Paris
    //3. Нажать пункт меню Search
    //4. Из выпадающего списка выбрать Paris, FR
    //5. Подтвердить, что заголовок изменился на "Paris, FR"
     */

    @Test
    public void testH2TagText_WhenSearchingCityCountry() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        driver.get(url);
        Thread.sleep(5000);

        WebElement searchCityField = driver.findElement(
                By.xpath("//div[@id='weather-widget']//input[@placeholder = 'Search city']"));
        searchCityField.click();
        searchCityField.sendKeys(cityName);

        WebElement searchButton = driver.findElement(
                By.xpath("//div[@id='weather-widget']//button[@type='submit']")
        );
        searchButton.click();

        Thread.sleep(1000);

        WebElement parisFRChoiceInDropdownMenu = driver.findElement(
                By.xpath("//ul[@class=\"search-dropdown-menu\"]//li//span[text() = 'Paris, FR ']")
        );
        parisFRChoiceInDropdownMenu.click();

        WebElement h2CityCountryHeader = driver.findElement(
                By.xpath("//div[@id='weather-widget']//h2")
        );

        Thread.sleep(2000);
        String actualResult = h2CityCountryHeader.getText();

        Assert.assertEquals(actualResult, expectedResult);



        driver.quit();
//        driver.close();

    }
    @Test
    //TC_11_01
    //1.  Открыть базовую ссылку
    //2.  Нажать на пункт меню Guide
    //3.  Подтвердить, что вы перешли на страницу со ссылкой
    // https://openweathermap.org/guide и что title этой
    // страницы OpenWeatherMap API guide - OpenWeatherMap

    public void testCheckTitlePage () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        //String title = "OpenWeatherMap";
        String expectedResult = "OpenWeatherMap API guide - OpenWeatherMap";

        driver.get(url);
        Thread.sleep(4000);
        driver.manage().window().maximize();

        WebElement guideButton = driver.findElement(
                By.xpath("//li/a[@href='/guide']")
        );
        guideButton.click();

        WebElement getTitleGuidePage = driver.findElement(
                By.xpath("//title[text()='OpenWeatherMap API guide - OpenWeatherMap']")
        );

        //Thread.sleep(2000);
        String actualResult = getTitleGuidePage.getText();
        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
//        driver.close();

    }

    //TC_11_02
    //1.  Открыть базовую ссылку
    //2.  Нажать на единицы измерения Imperial: °F, mph
    //3.  Подтвердить, что температура для города показана в Фарингейтах

    @Test
    public void testCheckFarenheit() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult = "°F, mph";
        String fTempSymbol = "°F, mph";

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(4000);

        WebElement menuImperial = driver.findElement(
                By.xpath("//div[@class='switch-container']/div[@class='option']/following-sibling::div"));

        menuImperial.click();

        WebElement tempF = driver.findElement(By.xpath(
                "//div[@class='current-temp']/span"));

        String tempInF = tempF.getText();

        String actualResult = tempInF.substring((tempInF.length()-2));
        Boolean isTemperatureInFahrenheit = tempF.getText().contains("F");

        Assert.assertTrue(isTemperatureInFahrenheit);

        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }

    //TC_11_03
    //1.  Открыть базовую ссылку
    //2. Подтвердить, что внизу страницы есть панель с текстом “We use cookies which are essential for the site to work.
    // We also use non-essential cookies to help us improve our services. Any data collected is anonymised.
    // You can allow all cookies or manage them individually.”
    //3. Подтвердить, что на панели внизу страницы есть 2 кнопки “Allow all” и “Manage cookies”
    //
    //


    @Test
    public void testApproveTwoButtons() {

    }

    //TC_11_04
    //1.  Открыть базовую ссылку
    //2.  Подтвердить, что в меню Support есть 3 подменю с названиями “FAQ”,
    // “How to start” и “Ask a question”

    //TC_11_05
    //1. Открыть базовую ссылку
    //2. Нажать пункт меню Support → Ask a question
    //3. Заполнить поля Email, Subject, Message
    //4. Не подтвердив CAPTCHA, нажать кнопку Submit
    //5. Подтвердить, что пользователю будет показана
    // ошибка “reCAPTCHA verification failed, please try again.”


   // TC_11_06
    // 1.  Открыть базовую ссылку
    // 2.  Нажать пункт меню Support → Ask a question
    // 3.  Оставить значение по умолчанию в checkbox Are you an OpenWeather user?
    // 4. Оставить пустым поле Email
    // 5. Заполнить поля  Subject, Message
    // 6. Подтвердить CAPTCHA
    // 7. Нажать кнопку Submit
    // 8. Подтвердить, что в поле Email пользователю будет показана ошибка “can't be blank”













}


