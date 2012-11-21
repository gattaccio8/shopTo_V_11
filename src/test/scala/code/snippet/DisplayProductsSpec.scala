package code.snippet

import org.specs2.mutable.SpecificationWithJUnit
import code.driver.IndexPageDriver

class DisplayProductsSpec extends SpecificationWithJUnit with IndexPageDriver {

  "index page" should {
    "display the products list" in {
      assertIsHomePage
      firefoxDriver.findElementByClassName("images").isDisplayed
    }

    "display the items list" in {
      val bool = firefoxDriver.findElementByClassName("gamename").getText.equals("One Piece Gigant Battle")
      println(" result = " + firefoxDriver.findElementByClassName("gamename").getText)
      bool
    }

    "display the item price" in {
      val bool = firefoxDriver.findElementByClassName("price").getText.equals("£35.79 GBP")
      println(" result = " + firefoxDriver.findElementByClassName("price").getText)
      bool
    }
  }
}