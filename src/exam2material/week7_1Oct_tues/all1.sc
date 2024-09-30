// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.pred._
import org.sireum.justification.natded.prop._

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

    )
    //@formatter:on
  )
}