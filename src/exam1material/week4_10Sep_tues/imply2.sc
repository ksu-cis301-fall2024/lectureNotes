// #Sireum #Logika
//@Logika: --manual --background type

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

@pure def implication2(p: B, q: B, r: B): Unit = {
  Deduce(
    //@formatter:off
    (p __>: r,  q __>: r,  p | q) |- ( r )
      Proof(
        1 ( p __>: r )  by Premise,
        2 ( q __>: r ) by Premise,
        3 ( p | q ) by Premise,
    )
    //@formatter:on
  )
}