// #Sireum #Logika
//@Logika: --manual --background type

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

//Prove OR is commutative:
//p ∨ q ⊢ q ∨ p


@pure def or1(p: B, q: B): Unit = {
  Deduce(
    //@formatter: off

    (p | q) |- (q | p)
      Proof(

      //PROOF GOES HERE
      1 ( p | q ) by Premise,
      2 SubProof(
        3 Assume(q),
        4 (q | p) by OrI1(3)
      ),
      5 SubProof(
        6 Assume(p),
        7 (q | p) by OrI2(6)
      ),
      8 ( q | p ) by OrE(1, 5, 2)
    )
    //@formatter:on
  )
}