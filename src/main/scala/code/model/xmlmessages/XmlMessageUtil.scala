package code.model.xmlmessages

import java.io.File
import xml.{XML, NodeSeq}
import code.model.{ListOfProducts, Product}

object XmlMessageUtil {

  def readTags(file:File) : NodeSeq = {
    val xml = XML.loadFile(file)
    xml
  }

  def getProdDetails(file: File) = {
    val nodeS = readTags(file)
    for(pro <- nodeS \\ "Product") {
      def image =  (pro \\ "Media" \\ "Boxart").text
      def name =  (pro \\ "Name").text
      def currency = (pro \\ "Price" \\ "Currency").text
      def price =  (pro \\ "Price" \\ "Amount").text
      def product = new Product(name, price, currency, image)
      ListOfProducts.allProducts += product
    }
    ListOfProducts.allProducts
  }
}