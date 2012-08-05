package code.snippet

import org.specs2.mutable.SpecificationWithJUnit
import code.acceptance.infrastructure.WebSpecification

class RegistrationFormSpec extends SpecificationWithJUnit with WebSpecification {

  "The registration form" should {
    "return the appropriate error messages" in {
      firefoxDriver.get("http://localhost:8080/registrationForm.html")
      firefoxDriver.findElementById("forenames").sendKeys("anylongname")
      firefoxDriver.findElementById("surname").sendKeys("")
      firefoxDriver.findElementById("addressline1").sendKeys("")
      firefoxDriver.findElementById("addressline2").sendKeys("")
      firefoxDriver.findElementById("city").sendKeys("")
      firefoxDriver.findElementById("email").sendKeys("gattaccio8hotmail.com")
      firefoxDriver.findElementById("password").sendKeys("mon")
      firefoxDriver.findElementById("password2").sendKeys("banana")
      firefoxDriver.findElementById("postCode").sendKeys("SW15 P3")
      firefoxDriver.findElementById("submit").click()
      val start = System.currentTimeMillis()
            var result = false
            while (!result && System.currentTimeMillis() - start < 5000) {
              result = firefoxDriver.getTitle.equals("App: test Home")
              Thread.sleep(50)
            }
      firefoxDriver.findElementById("clients_forenames").getText must_== "Name too long."
      firefoxDriver.findElementById("clients_surname").getText must_== "Surname cannot be empty."
      firefoxDriver.findElementById("clients_email").getText must_== "Invalid email address."
      firefoxDriver.findElementById("clients_password").getText must_== "Password too weak, must be 4 alphanumerics"
      firefoxDriver.findElementById("clients_password2").getText must_== "Passwords do not match."
      firefoxDriver.findElementById("clients_address").getText must_== "Address cannot be empty."
      firefoxDriver.findElementById("clients_address2").getText must_== "Address cannot be empty."
      firefoxDriver.findElementById("clients_city").getText must_== "City cannot be empty."
      firefoxDriver.findElementById("clients_postCode").getText must_== "Invalid postal code"
    }
  }
}