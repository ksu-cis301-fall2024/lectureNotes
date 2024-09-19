// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

@pure def lem(p: B): Unit = {
  Deduce(
    //@formatter: off

    |- ( p | !p )
      Proof(
        1 SubProof(
          //try pbc
          2 Assume ( !(p | !p) ),

          //if we got p | !p, would contradict with #2

          //if we could get just !p, could use OrI to get p | !p, would F

          3 SubProof(
            4 Assume(p),
            5 ( p | !p ) by OrI1(4),
            6 (F) by NegE(5, 2)
            //goal: F
          ),
          //use NegI to conclude !p
          7 (!p) by NegI(3),
          8 (p | !p) by OrI2(7),
          9 (F) by NegE(8, 2)

          //goal: F
        ),
        10 (p | !p) by PbC(1)
        //use pbc to conclude p V !p
    )
    //@formatter:on
  )
}