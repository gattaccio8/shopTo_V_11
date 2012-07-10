//package code.model.persistedobjects
//
//import net.liftweb.mapper._
//import net.liftweb.common.Full
//
//class Auction extends LongKeyedMapper[Auction] with IdPK with CreatedUpdated {
//  def getSingleton = PersistedAuction
//  object name extends MappedString(this, 150)
//  object description extends MappedText(this)
//  object ends_at extends MappedDateTime(this)
//  object outbound_on extends MappedDateTime(this)
//  object inbound_on extends MappedDateTime(this)
//  object flying_from extends MappedString(this, 100)
//  object permanent_link extends MappedString(this, 150)
//  object is_closed extends MappedBoolean(this)
//
//  object supplier extends LongMappedMapper(this, Supplier) {
//    override def dbColumnName = "supplier_id"
//
//    override def validSelectValues =
//      Full(Supplier.findMap(OrderBy(Supplier.name, Ascending)) {
//        case s: Supplier => Full(s.id.is -> s.name.is)
//      })
//  }
//}