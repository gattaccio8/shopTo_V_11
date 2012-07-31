package model

import org.specs2.mutable.SpecificationWithJUnit
import net.liftweb.mapper._
import code.model.persistedobjects.Client
import code.model.DBConnection
import code.acceptance.infrastructure.WebSpecification

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
      firefoxDriver.get("http://localhost:8080/registrationForm.html")
      firefoxDriver.findElementById("forenames").sendKeys("anyname")
      firefoxDriver.findElementById("surname").sendKeys("anysurname")
      firefoxDriver.findElementById("addressline1").sendKeys("Las Vegas")
      firefoxDriver.findElementById("submit").click()
      val start = System.currentTimeMillis()
      var result = false
      while (!result && System.currentTimeMillis() - start < 5000) {
        result = firefoxDriver.getTitle.equals("App: test Home")
        Thread.sleep(50)
      }

      val clients: List[Client] = Client.findAll
      clients.length must_== 1
    }
  }
}
