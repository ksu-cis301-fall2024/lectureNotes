// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.pred._
import org.sireum.justification.natded.prop._

// ∀ x (P(x) __>: Q(x)) |- ∀ x (!Q(x) __>: !P(x))

//will finish on Tues Oct 8

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

    )
    //@formatter:on
  )
}