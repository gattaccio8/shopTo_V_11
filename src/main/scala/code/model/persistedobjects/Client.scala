package code.model.persistedobjects

import net.liftweb.mapper._

class Client extends LongKeyedMapper[Client] with CreatedUpdated with IdPK {
  def getSingleton = Client

  object forenames extends MappedString(this, 255) {
    override def validations = valMinLen(1, {"Name too short, dude!"}) _ :: super.validations
    override def defaultValue = "forenames"
  }

  object surname extends MappedString(this, 255) {
    override def validations = valMinLen(1, {"surname too short, dude!"}) _ :: super.validations
    override def defaultValue = "surname"
  }

  object email extends MappedString(this, 255)
  object password extends MappedString(this, 255)

  object address extends MappedString(this, 255) {
//      override def validations = valMinLen(1, {"address too short, dude!"}) _ :: super.validations
//      override def defaultValue = "address"
    }

  object postCode extends MappedString(this, 255)
  object country extends MappedString(this, 255)
}

object Client extends Client with LongKeyedMetaMapper[Client] {

  def apply(forenames: String, surname: String, email: String, password: String,
              address: String, postCode: String, country: String) = {
    Client.create
      .forenames(forenames)
      .surname(surname)
      .email(email)
      .password(password)
      .address(address)
      .postCode(postCode)
      .country(country)
  }
  override def dbTableName = "clients"
}


