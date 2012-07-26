package code.snippet

import net.liftweb.http.SHtml._
import net.liftweb.util.Helpers._
import code.model.persistedobjects.Client
import net.liftweb.http.S
import net.liftweb.http.js.JsCmds
import xml.Text
import scala.collection.mutable.Map

object RegistrationForm {
  def render = {
    var forenames = ""
    var surname = ""
    var email = ""
    var password = ""
    var securityAnswer = ""
    var address = ""
    var postCode = ""
    var country = ""
    var heardAboutUs = ""
    var fieldsValidation: Map[String, Seq[((String) => Boolean, String)]] = Map()

    val cannotBeEmpty = (empty _, "Cannot be empty")
    val cannotBeTooShort = (validateLength _, "must be minimum 2 characters long")
    val passLength = (passwordLength _, "Password must be minimum 4 characters long")
    val emailForm = (emailFormat _, "The email is not the right format")

    fields.map(f =>
      f match {
        case "email" => fieldsValidation += ("email" -> Seq(cannotBeEmpty, cannotBeTooShort, emailForm))
        case "password" => fieldsValidation += ("password" -> Seq(passLength, cannotBeEmpty))
        case "forenames" => fieldsValidation += ("forenames" -> Seq(cannotBeEmpty))
        case field: String => fieldsValidation += (field  -> Seq(cannotBeEmpty))
      })

    def generateErrorMsg(field: String) = JsCmds.SetHtml("forenamesError", Text(field + " error"))

    def process() = {
      if (forenames.equals("")) {
        JsCmds.SetHtml("forenamesError", Text(" error"))
//      var bool: Boolean = false
//      var field: String = ""
//      fieldsValidation.keys.map(f => fieldsValidation.values.map(x => x.map(y => if (y._1(f)) {
//        bool = true; field = f
//      })))
//      if (bool) {
//        generateErrorMsg(field)
      } else {
        val client = Client(forenames, surname, email, password, securityAnswer, address, postCode, country, heardAboutUs)
        client.save()
        S.redirectTo("/index.html")
      }
    }

    "#forenames" #> text(forenames, forenames = _ , "id" -> "forenames") &
    "#surname" #> text(surname, surname = _ , "id" -> "surname") &
    "#email" #> text(email, email = _ , "id" -> "email") &
    "#password" #> text(password, password = _ , "id" -> "password") &
    "#securityAnswer" #> text(securityAnswer, securityAnswer = _ , "id" -> "securityAnswer") &
    "#address" #> text(address, address = _ , "id" -> "address") &
    "#postCode" #> text(postCode, postCode = _ , "id" -> "postCode") &
    "#country" #> text(country, country = _ , "id" -> "country") &
    "#heardAboutUs" #> text(heardAboutUs, heardAboutUs = _ , "id" -> "heardAboutUs") &
    "#submit" #>  ajaxSubmit("Register", () => {
      process()
    })
  }

  private def empty(field: String) = field.length == 0
  private def validateLength(field: String) = field.length < 2
  private def passwordLength(password: String) = password.length < 4
  private def emailFormat(email: String) = !email.contains("@")


  val fields = List("forenames", "surname", "email", "password", "securityAnswer", "address", "postCode", "country", "hearAboutUs")
}

