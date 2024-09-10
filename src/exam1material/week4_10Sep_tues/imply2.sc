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
        4 SubProof(
          5 Assume(p),
          6 ( r ) by ImplyE(1, 5)
        ),
        7 SubProof(
          8 Assume(q),
          9 ( r ) by ImplyE(2, 8)
        ),
      10 ( r )  by OrE(3, 4, 7)
    )
    //@formatter:on
  )
}