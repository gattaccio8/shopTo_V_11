package snippet

import org.specs2.mutable.SpecificationWithJUnit
import code.acceptance.infrastructure.WebSpecification

class DisplayProductsSpec extends SpecificationWithJUnit with WebSpecification {

  firefoxDriver.get("http://localhost:8080/")

  "index page" should {
    "display the products list" in {
      firefoxDriver.getTitle.equals("App: test Home")
      firefoxDriver.findElementByClassName("products").isDisplayed
    }

    "display the items list" in {
      val bool = firefoxDriver.findElementByClassName("td2").getText.equals("One Piece Gigant Battle")
      println(" result = " + firefoxDriver.findElementByClassName("td2").getText)
//      fireFoxDriver.close()
      bool
    }

    "display the item price" in {
      val bool = firefoxDriver.findElementByClassName("td3").getText.equals("£35.79 GBP")
      println(" result = " + firefoxDriver.findElementByClassName("td3").getText)
//      firefoxDriver.close()
      bool
    }
  }
}