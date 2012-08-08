package code.driver

import code.acceptance.infrastructure.WebSpecification


trait HomeDriver extends WebSpecification {
  HomeDriver

  def assertIsHomePage = firefoxDriver.getTitle.equals("Home Page")
  def assertUsernameFieldExist = firefoxDriver.findElementById("username").isDisplayed
  def assertPasswordFieldExist = firefoxDriver.findElementById("password").isDisplayed
}

object HomeDriver extends HomeDriver {
  firefoxDriver.get("http://localhost:8080/")
}