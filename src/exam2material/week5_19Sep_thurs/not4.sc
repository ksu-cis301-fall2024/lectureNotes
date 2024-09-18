// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

@pure def not4(p: B, q: B, r: B): Unit = {
  Deduce(
    //@formatter: off

      ( !q __>: !p )|- ( p __>: q )
      Proof(
      1 (  !q __>: !p ) by Premise,

    )
    //@formatter:on
  )
}