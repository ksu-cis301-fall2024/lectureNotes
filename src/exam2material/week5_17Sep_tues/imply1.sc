// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

@pure def imply1(p: B, q: B, r: B): Unit = {
  Deduce(
    //@formatter: off

    (p __>: r, q __>: r ) |- ( p & q __>: r  )
      Proof(
      1 (  p __>: r   ) by Premise,
      2 (  q __>: r   ) by Premise,
      3 SubProof(
        4 Assume(p & q),
        5 (p) by AndE1(4),
        6 (q) by AndE2(4),
        7 (r) by ImplyE(1, 5)

        //goal: r
      ),
      8 (p & q __>: r) by ImplyI(3)
      //goal: p & q __>: r
    )
    //@formatter:on
  )
}