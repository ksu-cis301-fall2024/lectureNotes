// #Sireum #Logika
//@Logika: --manual --background type

import org.sireum._

//First part proof of distributive law:
//p ∨ (q ∧ r)     is equivalent to
// (p ∨ q) ∧ (p ∨ r)


@pure def orDist1(p: B, q: B, r: B): Unit = {
  Deduce(
    //@formatter: off

    (p | (q & r)) |- ((p | q) & (p | r))
      Proof(

      //PROOF GOES HERE


    )
    //@formatter:on
  )
}