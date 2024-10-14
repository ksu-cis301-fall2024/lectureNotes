// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.pred._
import org.sireum.justification.natded.prop._

// ∃ x ¬P(x)   equivalent to    ¬(∀ x P(x))

@pure def demogan2A[T](P: T=>B @pure): Unit = {
  Deduce(
    //@formatter: off

    (
      !(∃((x: T) => !P(x)))
    )
      |-
    (
        !(∀((x: T) => P(x)))
    )
    Proof(
      1 ( !(∃((x: T) => !P(x))) ) by Premise,

    )
    //@formatter:on
  )
}

@pure def demogan2B[T](P: T=>B @pure): Unit = {
  Deduce(
    //@formatter: off

    (
      !(∀((x: T) => P(x)))
    )
      |-
    (
      !(∃((x: T) => !P(x)))
    )
    Proof(
      1 ( !(∀((x: T) => P(x))) ) by Premise,

    )
    //@formatter:on
  )
}

