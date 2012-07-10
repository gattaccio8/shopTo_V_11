package code.model.persistedobjects

import net.liftweb.mapper._
import net.liftweb.common.{Box, Full}
import xml.Node

object Customer extends Customer with KeyedMetaMapper[Long, Customer] with MetaMegaProtoUser[Customer] {
  override def dbTableName = "customers"
  override val basePath = "account" :: Nil
  override def skipEmailValidation = true
}

class Customer extends MegaProtoUser[Customer] {
  def getSingleton = Customer
//  override def screenWrap: Box[Node] = Full(
//    <lift:surround with="default" at="content">
//      <div id="box1" class="topbg">
//          <lift:bind/>
//      </div>
//      <lift:with-param name="sidebar">
//          <lift:embed what="_light_basket"/>
//      </lift:with-param>
//    </lift:surround>)
}