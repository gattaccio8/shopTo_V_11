package infrastructure

import org.openqa.selenium.firefox.FirefoxDriver
import code.acceptance.infrastructure.OnShutDown

object Browser {

  println("----------------- FIREFOX HAS OPENED -----------------")
  val firefoxDriver = new FirefoxDriver
  OnShutDown.execute(() => firefoxDriver.close(), "-------- FIREFOX HAS CLOSED --------")

}
