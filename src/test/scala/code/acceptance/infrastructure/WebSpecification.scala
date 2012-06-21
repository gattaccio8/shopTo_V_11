package code.acceptance.infrastructure

import infostructure.Browser

trait WebSpecification {
  WebSpecificationSuite
  val firefoxDriver = Browser.firefoxDriver
}


object WebSpecificationSuite {
  messageOut
  RunApp

  private def messageOut = println("I am web specification")
}

