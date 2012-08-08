package code.snippet

import org.specs2.mutable.SpecificationWithJUnit
import code.driver.HomeDriver

class LoginSpec extends SpecificationWithJUnit with HomeDriver {

  "The Home page" should {
    "contain the username field" in {
      assertIsHomePage
      assertUsernameFieldExist
    }

    "contain the password field" in {
      assertIsHomePage
      assertPasswordFieldExist
    }
  }
}
