// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

@pure def imply2(p: B, q: B, r: B): Unit = {
  Deduce(
    //@formatter: off

    (p __>: r, q __>: r ) |- ( p | q __>: r  )
      Proof(
      1 (  p __>: r   ) by Premise,
      2 (  q __>: r   ) by Premise,
      3 SubProof(
        4 Assume(p | q),
        5 SubProof(
          6 Assume(p),
          7 (r) by ImplyE(1, 6),

          //goal: r
        ),
        8 SubProof(
          9 Assume(q),
          10 (r) by ImplyE(2, 9)
          //goal: r
        ),
        11 (r) by OrE(4, 5, 8)
        //subproof with q next

        //goal: r
      ),
      12 (p | q __>: r) by ImplyI(3)

      //goal: p | q __>: r
    )
    //@formatter:on
  )
}