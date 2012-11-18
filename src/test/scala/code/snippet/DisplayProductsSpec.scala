package code.snippet

import org.specs2.mutable.SpecificationWithJUnit
import code.driver.IndexPageDriver

class DisplayProductsSpec extends SpecificationWithJUnit with IndexPageDriver {

  "index page" should {
    "display the products list" in {
      assertIsHomePage
      firefoxDriver.findElementByClassName("products").isDisplayed
    }

    "display the items list" in {
      val bool = firefoxDriver.findElementByClassName("td2").getText.equals("One Piece Gigant Battle")
      println(" result = " + firefoxDriver.findElementByClassName("td2").getText)
      bool
    }

    "display the item price" in {
      val bool = firefoxDriver.findElementByClassName("td3").getText.equals("£35.79 GBP")
      println(" result = " + firefoxDriver.findElementByClassName("td3").getText)
      bool
    }
  }
}