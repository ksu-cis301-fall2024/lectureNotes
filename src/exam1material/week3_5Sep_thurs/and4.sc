// #Sireum #Logika
//@Logika: --manual --background type

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

//Prove AND is commutative:
//p ∧ q ⊢ q ∧ p


@pure def and4(p: B, q: B): Unit = {
  Deduce(
    //@formatter: off

    (p & q) |- (q & p)
      Proof(

      //PROOF GOES HERE
      1 (  p & q  ) by Premise,
      2 (  q      ) by AndE2(1),
      3 (  p      ) by AndE1(1),
      4 (  q & p  ) by AndI(2, 3)
    )
    //@formatter:on
  )
}