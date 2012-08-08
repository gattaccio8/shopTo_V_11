package code.snippet

import org.specs2.mutable.SpecificationWithJUnit
import code.driver.HomeDriver

class LoginSpec extends SpecificationWithJUnit with HomeDriver {

  "The Login username should be viewable" should {
    "from the home page" in {
      assertHasUsernameField
    }
  }

    def assertHasUsernameField = firefoxDriver.findElementById("username").isDisplayed
}
