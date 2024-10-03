// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.pred._
import org.sireum.justification.natded.prop._

// ∀ x (Human(x) __>: Mortal(x)), Human(Socrates) |- ∃ x Mortal(x)

@pure def exists1[T](Human: T=>B @pure, Mortal: T=>B @pure, Socrates: T): Unit = {
  Deduce(
    //@formatter: off

    (
      ∀ ((x: T) => (Human(x) __>: Mortal(x))),
      Human(Socrates)
    )
    |-
      ( ∃ ((x: T) => Mortal(x)) )
    Proof(
      1 ( ∀ ((x: T) => (Human(x) __>: Mortal(x))) ) by Premise,
      2 ( Human(Socrates) ) by Premise,
      3 ( Human(Socrates) __>: Mortal(Socrates) ) by AllE[T](1),
      4 ( Mortal(Socrates) ) by ImplyE(3, 2),
      5 ( ∃ ((x: T) => Mortal(x)) ) by ExistsI[T](4)
    )
    //@formatter:on
  )
}