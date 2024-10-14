// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.pred._
import org.sireum.justification.natded.prop._

// ∀ x (Human(x) → Mortal(x)), ∃ x (Human(x)) ⊢ ∃ x (Mortal(x))

@pure def exists1[T](Human: T=>B @pure, Mortal: T=>B @pure): Unit = {
  Deduce(
    //@formatter: off

    (
      !(∀((x: T) => (Human(x) __>: Mortal(x)))),
      ∃((x: T) => Human(x))
    )
    |-
    (
      ∃((x: T) => Mortal(x))
    )
    Proof(
      1 ( !(∀((x: T) => (Human(x) __>: Mortal(x)))) ) by Premise,
      2 ( ∃((x: T) => Human(x)) ) by Premise,

    )
    //@formatter:on
  )
}