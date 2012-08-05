package code.snippet

import net.liftweb.http.SHtml._
import net.liftweb.util.Helpers._
import code.model.persistedobjects.Client
import net.liftweb.http.S
import net.liftweb.http.js.JsCmds
import net.liftweb.util.FieldError

object RegistrationForm {
  def render = {
    var forenames = ""
    var surname = ""
    var email = ""
    var password = ""
    var password2 = ""
    var address = ""
    var address2 = ""
    var city = ""
    var postCode = ""
    var country = ""

    def process() = {
      val client = Client(forenames, surname, email, password, password2, address, address2, city, postCode, country)
      client.validate match {
        case Nil => client.save(); JsCmds.Alert("Success registration")
        case error: List[FieldError] => error.map(e => JsCmds.SetHtml(e.field.uniqueFieldId.get, e.msg)).fold(JsCmds.Noop)((acc, n) => acc & n)
      }
    }

    "#forenames" #> text(forenames, forenames = _ , "id" -> "forenames") &
    "#surname" #> text(surname, surname = _ , "id" -> "surname") &
    "#email" #> text(email, email = _ , "id" -> "email") &
    "#password" #> text(password, password = _ , "id" -> "password") &
    "#password2" #> text(password2, password2 = _ , "id" -> "password2") &
    "#addressline1" #> text(address, address = _ , "id" -> "addressline1") &
    "#addressline2" #> text(address2, address2 = _ , "id" -> "addressline2") &
    "#city" #> text(city, city = _ , "id" -> "city") &
    "#postCode" #> text(postCode, postCode = _ , "id" -> "postCode") &
    "#country" #> text(country, country = _ , "id" -> "country") &
    "#submit" #>  ajaxSubmit("Register", () => {
      process()
    })
  }
}

