package code.snippet

import code.acceptance.infrastructure.WebSpecification
import org.specs2.mutable.SpecificationWithJUnit

class LoginSpec extends SpecificationWithJUnit with WebSpecification {

  "The Login username should be viewable" should {
    "from the home page" in {
      goToHomepage
      assertHasUsernameField
    }
  }

    def goToHomepage = firefoxDriver.get("http://localhost:8080/")
    def assertHasUsernameField = firefoxDriver.findElementById("username").isDisplayed
}
