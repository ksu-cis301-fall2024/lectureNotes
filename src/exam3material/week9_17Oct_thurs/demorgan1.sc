// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.pred._
import org.sireum.justification.natded.prop._

// ∀ x ¬P(x)   equivalent to   ¬(∃ x P(x))

@pure def demogan1A[T](P: T=>B @pure): Unit = {
  Deduce(
    //@formatter: off

    (
      ∀((x: T) => !P(x))
    )
    |-
    (
      !(∃((x: T) => P(x)))
    )
    Proof(
      1 ( ∀((x: T) => !P(x)) ) by Premise,

      //use NegI to build !(∃((x: T) => P(x)))
      2 SubProof(
        3 Assume( ∃((x: T) => P(x)) ),

        //now what can we do with line 3?

        //goal: F
      )
    )
    //@formatter:on
  )
}

@pure def demogan1B[T](P: T=>B @pure): Unit = {
  Deduce(
    //@formatter: off

    (
      !(∃((x: T) => P(x)))
    )
      |-
    (
      ∀((x: T) => !P(x))
    )
    Proof(
      1 ( !(∃((x: T) => P(x))) ) by Premise,

      //use AllI to build ∀((x: T) => !P(x))
      2 Let ((a: T) => SubProof(

        //use NegI to build !P(a)
        3 SubProof(
          4 Assume(P(a)),
          5 ( ∃((x: T) => P(x)) ) by ExistsI[T](4),
          6 ( F ) by NegE(5, 1)
        ),
        7 (!P(a)) by NegI(3)

        //goal: !P(a)
      )),
      8 ( ∀((x: T) => !P(x)) ) by AllI[T](2)
    )
    //@formatter:on
  )
}