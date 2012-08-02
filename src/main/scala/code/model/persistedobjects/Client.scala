package code.model.persistedobjects

import net.liftweb.mapper._
import net.liftweb.util.FieldError
import sun.rmi.rmic.iiop.ValueType

class Client extends LongKeyedMapper[Client] with CreatedUpdated with IdPK {
  def getSingleton = Client

  object forenames extends MappedString(this, 255) {
    override def validations = valMinLen(1, {"Name cannot be empty."}) _ :: valMaxLen(10, {"Name too long."}) _ :: super.validations
    override def defaultValue = "forenames"
  }

  object surname extends MappedString(this, 255) {
    override def validations = valMinLen(1, {"Surname cannot be empty."}) _ :: super.validations
    override def defaultValue = "surname"
  }

  object email extends MappedEmail(this, 255) {
    override def validations = valRegex(MappedEmail.emailPattern, ("Invalid email address")) _ :: super.validations
//    override def setFilter = notNull _ :: toLower _ :: trim _ :: super.setFilter
    override def defaultValue = "email"
  }

  object password extends MappedString(this, 255) {
    override def validations = valMinLen(1, {"Password cannot be empty."}) _ :: valMinLen(4, {"Password too weak, must be 4 alphanumerics"}) _ :: super.validations
    override def defaultValue = "password"
  }

  object password2 extends MappedString(this, 255) {
    override def validations = mustMatch _ :: super.validations
    override def defaultValue = "password2"
    def mustMatch(name : String) = if(!name.equals(password.toString())) List(FieldError(this, "Passwords do not match.")) else List[FieldError]()
  }

  object address extends MappedString(this, 255) {
      override def validations = valMinLen(1, {"Address cannot be empty."}) _ :: super.validations
      override def defaultValue = "addressline1"
    }

  object postCode extends MappedString(this, 255) {
    override def defaultValue = "postCode"
  }

  object country extends MappedString(this, 255) {
    override def defaultValue = "country"
  }


}

object Client extends Client with LongKeyedMetaMapper[Client] {

  def apply(forenames: String, surname: String, email: String, password: String, password2: String,
              address: String, postCode: String, country: String) = {
    Client.create
      .forenames(forenames)
      .surname(surname)
      .email(email)
      .password(password)
      .password2(password2)
      .address(address)
      .postCode(postCode)
      .country(country)
  }
  override def dbTableName = "clients"
}


