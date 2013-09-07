package infrastructure

import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.chrome.ChromeDriver
import com.thoughtworks.selenium.DefaultSelenium
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.Platform

object Browser {

  println("----------------- FIREFOX HAS OPENED -----------------")
//  val firefoxDriver = new FirefoxDriver
//  OnShutDown.execute(() => firefoxDriver.close(), "-------- FIREFOX HAS CLOSED --------")
  val driver = new FirefoxDriver
  OnShutDown.execute(() => driver.close(), "-------- FIREFOX HAS CLOSED --------")

//  println("----------------- CHROME IS STARTING -----------------")
//  val capabilities = DesiredCapabilities.chrome()
//  capabilities.setCapability("chrome.binary", """/Applications/Google\ Chrome.app""")
//  capabilities.setPlatform(Platform.MAC)
//
//  sys.props += ("webdriver.chrome.driver" -> """./tools/chromedriver2_mac32_0.8/chromedriver""")

//  val driver = new ChromeDriver(capabilities)
//  println("----------------- "  + driver + " -----------------")
//  println("----------------- CHROME HAS STARTED -----------------")
//  OnShutDown.execute(() => driver.quit, "-------- CHROME HAS CLOSED --------")
}
