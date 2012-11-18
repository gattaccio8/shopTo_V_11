package code.acceptance.infrastructure

import infrastructure.Browser

trait WebSpecification {
  WebSpecificationSuite

  val browser = Browser
  val firefoxDriver = browser.firefoxDriver
//  val firefoxDriver = browser.chromeDriver
}


object WebSpecificationSuite {
  messageOut
  RunApp
  private def messageOut = println("I am web specification")
}
