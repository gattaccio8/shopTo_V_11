package code.snippet

import org.specs2.mutable.SpecificationWithJUnit
import code.driver.IndexPageDriver

class LoginSpec extends SpecificationWithJUnit with IndexPageDriver {

  "The Home page" should {
    "contain the username and password fields" in {
      assertIsHomePage
      assertUsernameFieldExist
      assertPasswordFieldExist
    }
  }
}
