package code.snippet

import net.liftweb.http.SHtml._
import net.liftweb.util.Helpers._
import code.model.persistedobjects.Client
import net.liftweb.http.S
import net.liftweb.http.js.JsCmds
import xml.Text
import scala.collection.mutable.Map
import net.liftweb.util.FieldError

object RegistrationForm {
  def render = {
    var forenames = ""
    var surname = ""
    var email = ""
    var password = ""
    var address = ""
    var postCode = ""
    var country = ""

    def process() = {
      val client = Client(forenames, surname, email, password, address, postCode, country)
      client.validate match {
        case Nil => client.save(); S.redirectTo("/index.html")
        case error: List[FieldError] => JsCmds.SetHtml("forenamesError", Text("llllllll"))
      }
    }

    "#forenames" #> text(forenames, forenames = _ , "id" -> "forenames") &
    "#surname" #> text(surname, surname = _ , "id" -> "surname") &
    "#email" #> text(email, email = _ , "id" -> "email") &
    "#password" #> text(password, password = _ , "id" -> "password") &
    "#addressline1" #> text(address, address = _ , "id" -> "addressline1") &
    "#postCode" #> text(postCode, postCode = _ , "id" -> "postCode") &
    "#country" #> text(country, country = _ , "id" -> "country") &
    "#submit" #>  ajaxSubmit("Register", () => {
      process()
    })
  }
}

