// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.pred._
import org.sireum.justification.natded.prop._

// !(∃ x (P(x) & Q(x))) ⊢ ∀ x (P(x) __>: ¬Q(x))

@pure def exists1[T](P: T=>B @pure, Q: T=>B @pure): Unit = {
  Deduce(
    //@formatter: off

    (
      !(∃((x: T) => (P(x) & Q(x))))
    )
    |-
    (
      ∀((x: T) => (P(x)) __>: !Q(x))
    )
      Proof(
      1 ( !(∃((x: T) => (P(x) & Q(x)))) ) by Premise,


    )
    //@formatter:on
  )
}