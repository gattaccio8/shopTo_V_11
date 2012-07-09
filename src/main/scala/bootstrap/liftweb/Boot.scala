package bootstrap.liftweb

import net.liftweb._
import common._
import http._
import sitemap._
import Loc._
import mapper._

import code.model._


/**
 * A class that's instantiated early and run.  It allows the application
 * to modify lift's environment
 */
class Boot {
  def boot {
    //starts the DB connection
    DBConnection.init
    Schemifier.schemify(true, Schemifier.infoF _, PersistedClient)
    // Make a transaction span the whole HTTP request
    S.addAround(DB.buildLoanWrapper)
    // where to search snippet
    LiftRules.addToPackages("code")

    val entries =
      Menu(Loc("HomePage", "index" :: Nil, "Home Page", Hidden)) ::
      //static path to be visible
      Menu(Loc("Static", Link(List("static"), true, "/static/index"), "Static Content")) ::
      Menu(Loc("RegistrationForm", "registrationForm" :: Nil , "registration form", Hidden)) ::
      Menu(Loc("embedreg", "embedreg" :: Nil, "embedreg", Hidden)) ::
      Nil

    LiftRules.setSiteMap(SiteMap(entries: _*))
    LiftRules.jsArtifacts = net.liftweb.http.js.jquery.JQuery14Artifacts // Use jQuery 1.4

    LiftRules.ajaxStart =
      Full(() => LiftRules.jsArtifacts.show("ajax-loader").cmd) //Show the spinny image when an Ajax call starts
    
    LiftRules.ajaxEnd =
      Full(() => LiftRules.jsArtifacts.hide("ajax-loader").cmd) // Make the spinny image go away when it ends

    LiftRules.early.append(_.setCharacterEncoding("UTF-8")) // Force the request to be UTF-8

    LiftRules.loggedInTest = Full(() => User.loggedIn_?) // What is the function to test if a user is logged in?

    LiftRules.htmlProperties.default.set((r: Req) =>
    new Html5Properties(r.userAgent))               // Use HTML5 for rendering
  }
}
