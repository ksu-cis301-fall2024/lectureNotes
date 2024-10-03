// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.pred._
import org.sireum.justification.natded.prop._

// ∀ x (Human(x) __>: Mortal(x)), Human(Socrates) |- ∃ x ()

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

    )
    //@formatter:on
  )
}