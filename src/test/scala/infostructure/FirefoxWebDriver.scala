package infostructure

import org.openqa.selenium.firefox.FirefoxDriver
import code.acceptance.infrastructure.OnShutDown

trait FirefoxWebDriver {
  Browser
}

object Browser {
  println("----------------- firefox has opened -----------------")
  val firefoxDriver = new FirefoxDriver
  OnShutDown.execute(() => firefoxDriver.close(), "-------- fireFoxDriver is closed --------")

}
