package model

import org.specs2.mutable.SpecificationWithJUnit
import code.model.persistedobjects.Supplier

class SupplierSpec extends SpecificationWithJUnit {

  "Supplier DB table" should {
    "be created when the app is started" in {
      Supplier.dbTableName must_== "suppliers"
    }
  }

}