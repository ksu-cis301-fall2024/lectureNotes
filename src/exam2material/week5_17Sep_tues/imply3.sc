// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

@pure def imply3(p: B, q: B, r: B): Unit = {
  Deduce(
    //@formatter: off

    (p __>: (q __>: r)) |- ( (p __>: q) __>: (p __>: r)  )
      Proof(
      1 (  p __>: (q __>: r) ) by Premise,
      2  SubProof(
        3 Assume(p __>: q),
        4 SubProof(
          5 Assume(p),
          6 (q __>: r) by ImplyE(1, 5),
          7 (q) by ImplyE(3, 5),
          8 (r) by ImplyE(6, 7)
          //goal: r
        ),
        9 (p __>: r) by ImplyI(4)
        //goal: p __>: r
      ),
      10 ((p __>: q) __>: (p __>: r) ) by ImplyI(2)

      //goal: introduce middle -> in (p __>: q) __>: (p __>: r)
    )
    //@formatter:on
  )
}