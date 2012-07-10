package model

import org.specs2.mutable.SpecificationWithJUnit
import net.liftweb.mapper._
import code.model.persistedobjects.PersistedClient
import code.model.DBConnection
import code.acceptance.infrastructure.WebSpecification

class PersistedClientSpec extends SpecificationWithJUnit with WebSpecification {

  "DBConnection object" should {
    "connect to the h2 DB" in {
      DBConnection.init
      DB.use(DefaultConnectionIdentifier) {
        conn => true
      }
    }

    "create a table 'client'" in {
      PersistedClient.dbTableName must_== "clients"
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

      val clients: List[PersistedClient] = PersistedClient.findAll
      clients.length must_== 1
    }
  }
}
