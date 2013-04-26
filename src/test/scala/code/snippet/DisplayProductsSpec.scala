package code.snippet

import org.specs2.mutable.SpecificationWithJUnit
import code.driver.IndexPageDriver

class DisplayProductsSpec extends SpecificationWithJUnit with IndexPageDriver {

  "index page" should {
    "display the products list" in {
      assertIsHomePage
      driver.findElementByClassName("images").isDisplayed
    }

    "display the items list" in {
      val bool = driver.findElementByClassName("gamename").getText.equals("One Piece Gigant Battle")
      println(" result = " + driver.findElementByClassName("gamename").getText)
      bool
    }

    "display the item price" in {
      val bool = driver.findElementByClassName("price").getText.equals("£35.79 GBP")
      println(" result = " + driver.findElementByClassName("price").getText)
      bool
    }
  }
}