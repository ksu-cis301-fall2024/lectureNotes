// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.pred._
import org.sireum.justification.natded.prop._

// ∀ x (P(x) __>: Q(x)) |- ∀ x (!Q(x) __>: !P(x))

@pure def all3[T](P: T=>B @pure, Q: T=>B @pure): Unit = {
  Deduce(
    //@formatter: off

    (
      ∀((x: T) => (P(x) __>: Q(x)))
    )
      |-
    (
       ∀((x: T) => (!Q(x) __>: !P(x)))
    )
    Proof(
      1 ( ∀((x: T) => (P(x) __>: Q(x))) ) by Premise,

      //we want a ∀ statement, so we use AllI
      2 Let ((random: T) => SubProof(
          3 SubProof(
            4 Assume(!Q(random)),
            5 SubProof(
              6 Assume(P(random)),
              7 (P(random) __>: Q(random)) by AllE[T](1),
              8 (Q(random)) by ImplyE(7, 6),
              9 (F) by NegE(8, 4)
              //want: F
            ),
            10 (!P(random)) by NegI(5)
            //want: !P(random)
          ),
          11 (!Q(random) __>: !P(random)) by ImplyI(3)
        //want: !Q(random) __>: !P(random)
      )),
      12 (∀((x: T) => (!Q(x) __>: !P(x)))) by AllI[T](2)
    )
    //@formatter:on
  )
}