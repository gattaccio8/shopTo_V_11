package code.model

import net.liftweb.mapper._

object PersistedSupplier extends PersistedSupplier with LongKeyedMetaMapper[PersistedSupplier] {
  override def dbTableName = "suppliers"
}

class PersistedSupplier extends LongKeyedMapper[PersistedSupplier] with IdPK with CreatedUpdated with OneToMany[Long, PersistedSupplier] {
  def getSingleton = PersistedSupplier
    object name extends MappedString(this, 150)
    object telephone extends MappedString(this, 30)
    object email extends MappedEmail(this, 200)
    object address extends MappedText(this)
    object opening_hours extends MappedString(this, 255)
//    object auctions extends MappedOneToMany(Auction, Auction.supplier,
//      OrderBy(Auction.close_date, Descending))
//      with Owned[Auction]
//      with Cascade[Auction]
}
