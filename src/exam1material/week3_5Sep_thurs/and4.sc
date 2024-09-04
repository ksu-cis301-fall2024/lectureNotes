// #Sireum #Logika
//@Logika: --manual --background type

import org.sireum._

//Prove AND is commutative:
//p ∧ q ⊢ q ∧ p


@pure def and4(p: B, q: B): Unit = {
  Deduce(
    //@formatter: off

    (p & q) |- (q & p)
      Proof(

      //PROOF GOES HERE


    )
    //@formatter:on
  )
}