// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.pred._
import org.sireum.justification.natded.prop._

// ∀ x (P(x) __>: ¬Q(x)) ⊢ !(∃ x (P(x) & Q(x)))

@pure def exists2[T](P: T=>B @pure, Q: T=>B @pure): Unit = {
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

      //use AllI to build our goal forall statement
      2 Let ((a: T) => SubProof(

        //use ImplyI to build the implies
        3 SubProof(
          4 Assume(P(a)),

          //use NegI to get !Q(a)
          5 SubProof(
            6 Assume(Q(a)),
            7 (P(a) & Q(a)) by AndI(4, 6),
            8 (∃((x: T) => (P(x) & Q(x)))) by ExistsI[T](7),
            9 (F) by NegE(8, 1)

            //need: ∃((x: T) => (P(x) & Q(x))) to F with premise
            //goal: F
          ),
          10 (!Q(a)) by NegI(5)

          //goal: !Q(a)
        ),
        11 (P(a) __>: !Q(a)) by ImplyI(3)

        //goal: P(a) -> !Q(a)
      )),
      12 (∀((x: T) => (P(x)) __>: !Q(x))) by AllI[T](2)

      //goal: ∀((x: T) => (P(x)) __>: !Q(x))
    )
    //@formatter:on
  )
}