package code.snippet

import org.specs2.mutable.SpecificationWithJUnit
import infrastructure.WebSpecification

class RegistrationFormSpec extends SpecificationWithJUnit with WebSpecification {

  "The registration form" should {
    "return the appropriate error messages" in {
      driver.get("http://localhost:8080/registrationForm.html")
      driver.findElementById("forenames").sendKeys("anylongname")
      driver.findElementById("surname").sendKeys("")
      driver.findElementById("addressline1").sendKeys("")
      driver.findElementById("addressline2").sendKeys("")
      driver.findElementById("city").sendKeys("")
      driver.findElementById("email").sendKeys("gattaccio8hotmail.com")
      driver.findElementById("password").sendKeys("mon")
      driver.findElementById("password2").sendKeys("banana")
      driver.findElementById("postCode").sendKeys("SW15 P3")
      driver.findElementById("submit").click()
      val start = System.currentTimeMillis()
            var result = false
            while (!result && System.currentTimeMillis() - start < 5000) {
              result = driver.getTitle.equals("App: test Home")
              Thread.sleep(50)
            }
      driver.findElementById("clients_forenames").getText must_== "Name too long."
      driver.findElementById("clients_surname").getText must_== "Surname cannot be empty."
      driver.findElementById("clients_email").getText must_== "Invalid email address."
      driver.findElementById("clients_password").getText must_== "Password too weak, must be 4 alphanumerics"
      driver.findElementById("clients_password2").getText must_== "Passwords do not match."
      driver.findElementById("clients_address").getText must_== "Address cannot be empty."
      driver.findElementById("clients_address2").getText must_== "Address cannot be empty."
      driver.findElementById("clients_city").getText must_== "City cannot be empty."
      driver.findElementById("clients_postCode").getText must_== "Invalid postal code"
    }
  }
}