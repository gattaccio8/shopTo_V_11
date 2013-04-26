package model

import org.specs2.mutable.SpecificationWithJUnit
import net.liftweb.mapper._
import code.model.persistedobjects.Client
import code.model.DBConnection
import infrastructure.WebSpecification

class ClientSpec extends SpecificationWithJUnit with WebSpecification {

  "DBConnection object" should {
    "connect to the h2 DB" in {
      DBConnection.init
      DB.use(DefaultConnectionIdentifier) {
        conn => true
      }
    }

    "create a table 'client'" in {
      Client.dbTableName must_== "clients"
    }

    "persist the 'client' into DB table" in {
      driver.get("http://localhost:8080/registrationForm.html")
      driver.findElementById("forenames").sendKeys("anyname")
      driver.findElementById("surname").sendKeys("anysurname")
      driver.findElementById("addressline1").sendKeys("high street")
      driver.findElementById("addressline2").sendKeys("kingston")
      driver.findElementById("city").sendKeys("london")
      driver.findElementById("email").sendKeys("gattaccio8@hotmail.com")
      driver.findElementById("password").sendKeys("monkey")
      driver.findElementById("password2").sendKeys("monkey")
      driver.findElementById("postCode").sendKeys("sw15 3pl")
      driver.findElementById("submit").click()
      val start = System.currentTimeMillis()
      var result = false
      while (!result && System.currentTimeMillis() - start < 5000) {
        result = driver.getTitle.equals("App: test Home")
        Thread.sleep(50)
      }
      val clients: List[Client] = Client.findAll
      clients.length must_== 1
    }
  }
}
