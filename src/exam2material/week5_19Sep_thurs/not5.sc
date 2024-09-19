// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

@pure def not5(p: B, q: B, r: B): Unit = {
  Deduce(
    //@formatter: off

    ( !(!p | !q) ) |- ( p & q )
      Proof(
        1 (  !(!p | !q) ) by Premise,

        //try proving p first
        2 SubProof(
          3 Assume(!p),
          4 (!p | !q) by OrI1(3),
          5 (F) by NegE(4, 1)
          //want: !p | !q
          //contradiction
        ),
        6 (p) by PbC(2),

        //want to use pbc to get p

        //then try proving q
        7 SubProof(
          8 Assume(!q),
          9 (!p | !q) by OrI2(8),
          10 (F) by NegE(9, 1)
          //want F
        ),
        11 (q) by PbC(7),

        //then use AndI
        12 (p & q) by AndI(6, 11)
    )
    //@formatter:on
  )
}