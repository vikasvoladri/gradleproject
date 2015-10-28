import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import spock.lang.Specification
import spock.lang.Timeout

import java.util.concurrent.TimeUnit

/**
 * Created by vikasv on 10/12/2015.
 */
class WebdriverTestGroovy extends Specification{

    def url = "http://www.ascentis.com/"
    def WebDriver driver

    @Timeout(360)
    def "Verify acentis login page with invalid credentials"(){
        given:
        driver = new FirefoxDriver()

        when:
        driver.get(url)
        driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS)
        driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS)

        then:
        driver.findElement(By.id("Image2")).isDisplayed()

        when:
        driver.findElement(By.id("Image2")).click()

        then:
        driver.findElement(By.xpath("//input[@name='Username']")).isDisplayed()

        when:
        driver.findElement(By.xpath("//input[@name='Username']")).sendKeys(username)
        driver.findElement(By.xpath("//input[@name='Password']")).sendKeys(password)

        and:
        driver.findElement(By.xpath("//input[@value='Login']")).click()

        then:
        driver.getPageSource().contains("404 Error: Page Not Found")

        cleanup:
        driver.quit()

        where:
        username|password
        "user1"|"pass1"
        "user2"|"pass2"


    }
}
