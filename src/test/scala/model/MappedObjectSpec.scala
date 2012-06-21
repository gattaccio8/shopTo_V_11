package model

import org.specs2.mutable.SpecificationWithJUnit
import net.liftweb.mapper._
import code.model.{Client, MappedObject}
import code.acceptance.infrastructure.WebSpecification
import infostructure.FirefoxWebDriver

class MappedObjectSpec extends SpecificationWithJUnit with WebSpecification with FirefoxWebDriver {

  "MappedObject object" should {
    "connect to the h2 DB" in {
      MappedObject.init
      DB.use(DefaultConnectionIdentifier) {
        conn => true
      }
    }

    "create a table 'client'" in {
      Client.dbTableName must_== "clients"
    }

    "populate the 'client' DB table" in {
      firefoxDriver.get("http://localhost:8080/registrationForm.html")
      firefoxDriver.findElementById("forenames").sendKeys("anyname")
      firefoxDriver.findElementById("submit").click()
      val start = System.currentTimeMillis()
      var result = false
      while (!result && System.currentTimeMillis() - start < 5000) {
        result = firefoxDriver.getTitle.equals("App: test Home")
        Thread.sleep(50)
      }

      val clients: List[Client] = Client.findAll
//      println("MappObjSpec: " + Client.forenames + " ****************** ")
//      firefoxDriver.close()
      clients.length must_== 1
    }
  }
}
