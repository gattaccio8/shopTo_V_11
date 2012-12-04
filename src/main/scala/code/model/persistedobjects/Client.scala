package code.model.persistedobjects

import net.liftweb.mapper._
import net.liftweb.util.FieldError
import java.util.regex.Pattern

class Client extends LongKeyedMapper[Client] with CreatedUpdated with IdPK {
  def getSingleton = Client

  object forenames extends MappedString(this, 255) {
    override def validations = valMinLen(1, {"Name cannot be empty."}) _ :: valMaxLen(10, {"Name too long."}) _ :: super.validations
  }

  object surname extends MappedString(this, 255) {
    override def validations = valMinLen(1, {"Surname cannot be empty."}) _ :: super.validations
  }

  object email extends MappedEmail(this, 255) {
    override def validations = valRegex(MappedEmail.emailPattern, {"Invalid email address."}) _ :: super.validations
    override def setFilter = toLower _ :: trim _ :: super.setFilter
  }

  object password extends MappedString(this, 255) {
    override def validations = valMinLen(1, {"Password cannot be empty."}) _ :: valMinLen(4, {"Password too weak, must be 4 alphanumerics"}) _ :: super.validations
  }

  object password2 extends MappedString(this, 255) {
    override def validations = mustMatch _ :: super.validations
    def mustMatch(name : String) = if(!name.equals(password.toString())) List(FieldError(this, "Passwords do not match.")) else List[FieldError]()
  }

  object address extends MappedString(this, 255) {
      override def validations = valMinLen(1, {"Address cannot be empty."}) _ :: super.validations
    }

  object address2 extends MappedString(this, 255) {
        override def validations = valMinLen(1, {"Address cannot be empty."}) _ :: super.validations
      }

  object city extends MappedString(this, 255) {
        override def validations = valMinLen(1, {"City cannot be empty."}) _ :: super.validations
      }

  object postCode extends MappedString(this, 255) {
    override def setFilter = toUpper _ :: super.setFilter
    override def validations = valRegex(Pattern.compile("(GIR 0AA)|(((A[BL]|B[ABDFHLNRSTX]?|C[ABFHMORTVW]|D[ADEGHLNTY]|E[HNX]?|F[KY]|G[LUY]?|H[ADGPRSUX]|I[GMPV]|JE|K[ATWY]|L[ADELNSU]?|M[EKL]?|N[EGNPRW]?|O[LX]|P[AEHLOR]|R[GHM]|S[AEGKLMNOPRSTY]?|T[ADFNQRSW]|UB|W[ADFNRSV]|YO|ZE)[1-9]?[0-9]|((E|N|NW|SE|SW|W)1|EC[1-4]|WC[12])[A-HJKMNPR-Y]|(SW|W)([2-9]|[1-9][0-9])|EC[1-9][0-9]) [0-9][ABD-HJLNP-UW-Z]{2})"), ("Invalid postal code")) _ :: super.validations
  }

  object country extends MappedString(this, 255) {
  }
}

object Client extends Client with LongKeyedMetaMapper[Client] {

  def apply(forenames: String, surname: String, email: String, password: String, password2: String,
              address: String, address2: String, city: String, postCode: String, country: String) = {
    Client.create
      .forenames(forenames)
      .surname(surname)
      .email(email)
      .password(password)
      .password2(password2)
      .address(address)
      .address2(address2)
      .city(city)
      .postCode(postCode)
      .country(country)
  }
  override def dbTableName = "clients"
}


