package code.acceptance.infrastructure

import infrastructure.Browser

trait WebSpecification {
  WebSpecificationSuite

  val browser = Browser
  val firefoxDriver = browser.firefoxDriver
}


object WebSpecificationSuite {
  messageOut
  RunApp
  private def messageOut = println("I am web specification")
}
