package model

import org.specs2.mutable.SpecificationWithJUnit
import code.model.persistedobjects.PersistedSupplier

class PersistedSupplierSpec extends SpecificationWithJUnit {

  "Supplier DB table" should {
    "be created when the app is started" in {
      PersistedSupplier.dbTableName must_== "suppliers"
    }
  }

}