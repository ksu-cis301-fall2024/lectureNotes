// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.pred._
import org.sireum.justification.natded.prop._

//∀ x (inCIS301(x) → takenCIS200(x)), inCIS301(bob) ⊢ takenCIS200(bob)
//T is our domain - maybe people in this case
@pure def all1[T](inCIS301: T=>B @pure, takenCIS200: T=>B @pure, Bob: T): Unit = {
  Deduce(
    //@formatter: off
    (
      ∀((x: T) => (inCIS301(x) __>: takenCIS200(x))),
      inCIS301(Bob)
    )
  |-
    (
      takenCIS200(Bob)
    )
    Proof(
      1 (∀((x: T) => (inCIS301(x) __>: takenCIS200(x)))) by Premise,
      2 (inCIS301(Bob)) by Premise,
      3 (inCIS301(Bob) __>: takenCIS200(Bob)) by AllE[T](1),
      4 (takenCIS200(Bob)) by ImplyE(3, 2)
    )
    //@formatter:on
  )
}