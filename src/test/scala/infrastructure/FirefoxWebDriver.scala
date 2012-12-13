package infrastructure

import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.chrome.{ChromeDriverService, ChromeDriver}

object Browser {

  println("----------------- FIREFOX HAS OPENED -----------------")
  val firefoxDriver = new FirefoxDriver
  OnShutDown.execute(() => firefoxDriver.close(), "-------- FIREFOX HAS CLOSED --------")

//  println("----------------- CHROME IS STARTING -----------------")
//  val s = ChromeDriverService.createDefaultService()
//  println("----------------- "  + s + " -----------------")
//  val chromeDriver = new ChromeDriver(s)
//  println("----------------- "  + chromeDriver + " -----------------")
//  println("----------------- CHROME HAS STARTED -----------------")
//  OnShutDown.execute(() => chromeDriver.close(), "-------- CHROME HAS CLOSED --------")
}
