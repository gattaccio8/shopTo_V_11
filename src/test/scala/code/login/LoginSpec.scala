package code.login

import org.specs2.mutable.SpecificationWithJUnit
import code.driver.IndexPageDriver

class LoginSpec extends SpecificationWithJUnit with IndexPageDriver {

  "The Home page" should {
    "contain the username and password fields" in {
      assertIsHomePage
      assertUsernameFieldExist
      assertPasswordFieldExist
    }

//    "deny access to unknown user" in notLoggedIn {
//      (page: LoginDriver) =>
//
//      assertHasLoginTextFieldsAndButtons
//
//    }

    "hide the username and password row when logged in" in {
      assertHasLoginTextFieldsAndButtons
    }
  }
}
