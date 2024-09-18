// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

@pure def not5(p: B, q: B, r: B): Unit = {
  Deduce(
    //@formatter: off

    ( !(!p | !q) ) |- ( p & q )
      Proof(
      1 (  !(!p | !q) ) by Premise,

    )
    //@formatter:on
  )
}