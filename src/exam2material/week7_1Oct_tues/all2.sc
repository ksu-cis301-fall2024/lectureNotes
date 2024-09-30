// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.pred._
import org.sireum.justification.natded.prop._

@pure def all2part1[T](P: T=>B @pure, Q: T=>B @pure): Unit = {
  Deduce(
    //@formatter: off

    (
      ∀((x: T) => (P(x) & Q(x)))
    )
      |-
    (
       ∀((x: T) => P(x))) & (∀((x: T) => Q(x))
    )
    Proof(

    )
    //@formatter:on
  )
}

@pure def all2part2[T](P: T=>B @pure, Q: T=>B @pure): Unit = {
  Deduce(
    //@formatter: off

    (
      ∀((x: T) => P(x))) & (∀((x: T) => Q(x))
    )
      |-
    (
      ∀((x: T) => (P(x) & Q(x)))
    )
    Proof(

    )
    //@formatter:on
  )
}