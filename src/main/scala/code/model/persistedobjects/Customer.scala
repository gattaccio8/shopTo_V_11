package code.model.persistedobjects

import net.liftweb.mapper._

object Customer extends Customer with KeyedMetaMapper[Long, Customer] with MetaMegaProtoUser[Customer] {  //it's MetaProtoUser on the book
  override def dbTableName = "customers"
  override val basePath = "account" :: Nil
  override def skipEmailValidation = true
}

class Customer extends MegaProtoUser[Customer] {
 def getSingleton = Customer
}