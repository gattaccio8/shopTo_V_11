package code.driver

import infrastructure.WebSpecification


trait IndexPageDriver extends WebSpecification {
  IndexPageDriver

  def assertIsHomePage = firefoxDriver.getTitle.equals("Home Page")
  def assertUsernameFieldExist = firefoxDriver.findElementById("username").isDisplayed
  def assertPasswordFieldExist = firefoxDriver.findElementById("password").isDisplayed
  def assertHasLoginTextFieldsAndButtons = firefoxDriver.findElementById("loginandsignup").isDisplayed
}

object IndexPageDriver extends IndexPageDriver {
  firefoxDriver.get("http://localhost:8080/")
}