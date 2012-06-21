package code.model

import net.liftweb.mapper._

class PersistedClient extends LongKeyedMapper[PersistedClient] with CreatedUpdated with IdPK {

  def getSingleton = PersistedClient

  object forenames extends MappedString(this, 255)
  object surname extends MappedString(this, 255)
  object email extends MappedString(this, 255)
  object password extends MappedString(this, 255)
  object securityAnswer extends MappedString(this, 255)
  object address extends MappedString(this, 255)
  object postCode extends MappedString(this, 255)
  object country extends MappedString(this, 255)
  object heardAboutUs extends MappedString(this, 255)

}

object PersistedClient extends PersistedClient with LongKeyedMetaMapper[PersistedClient] {

  def apply(forenames: String, surname: String, email: String, password: String,
            securityAnswer: String, address: String, postCode: String, country: String, heardAboutUs: String) = {
    PersistedClient.create
      .forenames(forenames)
      .surname(surname)
      .email(email)
      .password(password)
      .securityAnswer(securityAnswer)
      .address(address)
      .postCode(postCode)
      .country(country)
      .heardAboutUs(heardAboutUs)
  }
  override def dbTableName = "clients"
}


