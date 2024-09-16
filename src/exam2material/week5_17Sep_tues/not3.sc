// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

@pure def not3(p: B, q: B, r: B): Unit = {
  Deduce(
    //@formatter: off

    ( p __>: q ) |- ( !q __>: !p  )
      Proof(
      1 (  p __>: q ) by Premise,

    )
    //@formatter:on
  )
}