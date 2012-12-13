package code.driver

import infrastructure.WebSpecification


trait IndexPageDriver extends WebSpecification {
  IndexPageDriver

  def enterUsernameAndPassword(username: String, password: String) = {
    elementById("username").sendKeys(username)
    elementById("password").sendKeys(password)
  }

  def clickLogin = elementById("login").click()
  def assertIsHomePage = firefoxDriver.getTitle.equals("Home Page")
  def assertUsernameFieldExist = elementById("username").isDisplayed
  def assertPasswordFieldExist = elementById("password").isDisplayed
  def assertHasLoginTextFieldsAndButtons = elementById("loginandsignup").isDisplayed

  private def elementById(id: String) = firefoxDriver.findElementById(id)
}

object IndexPageDriver extends IndexPageDriver {
  firefoxDriver.get("http://localhost:8080/")
}