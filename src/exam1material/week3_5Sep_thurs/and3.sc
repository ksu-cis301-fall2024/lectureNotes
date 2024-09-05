// #Sireum #Logika
//@Logika: --manual --background type

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

//Prove the sequent:
//p ∧ q ∧ r ⊢ q


@pure def and3(p: B, q: B, r: B): Unit = {
  Deduce(
    //@formatter: off

    (p & q & r) |- (q)
      Proof(

      //PROOF GOES HERE
      1 ( p & q & r ) by Premise,
      2 ( p & q ) by AndE1(1),
      3 ( r ) by AndE2(1),
      4 ( q ) by AndE2(2)
    )
    //@formatter:on
  )
}