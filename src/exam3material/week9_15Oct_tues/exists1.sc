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
      ∀((x: T) => (Human(x) __>: Mortal(x))),
      ∃((x: T) => Human(x))
    )
    |-
    (
      ∃((x: T) => Mortal(x))
    )
    Proof(
      1 ( ∀((x: T) => (Human(x) __>: Mortal(x))) ) by Premise,
      2 ( ∃((x: T) => Human(x)) ) by Premise,

      //use ExistsE on premise 2, introducing an alias for that statement
      3 Let ((bob: T) => SubProof(
        4 Assume (Human(bob)),
        5 ( Human(bob) __>: Mortal(bob)) by AllE[T](1),
        6 (Mortal(bob)) by ImplyE(5, 4),
        7 (∃((x: T) => Mortal(x))) by ExistsI[T](6)
        //want: ∃((x: T) => Mortal(x))
      )),
      8 (∃((x: T) => Mortal(x))) by ExistsE[T](2, 3)

      //goal: ∃((x: T) => Mortal(x))
    )
    //@formatter:on
  )
}