package code.driver

import code.acceptance.infrastructure.WebSpecification


trait HomeDriver extends WebSpecification {
  HomeDriver

  def assertIsHomePage = firefoxDriver.getTitle.equals("Home Page")
  def assertHasUsernameField = firefoxDriver.findElementById("username").isDisplayed
}

object HomeDriver extends HomeDriver {
  firefoxDriver.get("http://localhost:8080/")
}