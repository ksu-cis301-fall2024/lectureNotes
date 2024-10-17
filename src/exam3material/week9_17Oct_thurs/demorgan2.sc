// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.pred._
import org.sireum.justification.natded.prop._

// ∃ x ¬P(x)   equivalent to    ¬(∀ x P(x))

@pure def demorgan2A[T](P: T=>B @pure): Unit = {
  Deduce(
    //@formatter: off

    (
      ∃((x: T) => !P(x))
    )
      |-
    (
        !(∀((x: T) => P(x)))
    )
    Proof(
      1 (  ∃((x: T) => !P(x))            ) by Premise,

      //use NegI to build !(∀((x: T) => P(x)))
      2 SubProof(
        3 Assume(  ∀((x: T) => P(x))  ),

        //what can we do with line 1?
        //try ExistsE
        4 Let ((a: T) => SubProof(
          5 Assume(  !P(a)  ),
          6 (  P(a)                      ) by AllE[T](3),
          7 (  F                         ) by NegE(6, 5)
          //goal: F
        )),
        8 (  F                           ) by ExistsE[T](1, 4)

        //goal: F
      ),
      9 (  !(∀((x: T) => P(x)))          ) by NegI(2)
    )
    //@formatter:on
  )
}

@pure def demorgan2B[T](P: T=>B @pure): Unit = {
  Deduce(
    //@formatter: off

    (
      !(∀((x: T) => P(x)))
    )
      |-
    (
      ∃((x: T) => !P(x))
    )
    Proof(
      1 ( !(∀((x: T) => P(x)) )              ) by Premise,

      //no obvious approach, try PbC
      2 SubProof(
        3 Assume( !(∃((x: T) => !P(x))) ),

        //use AllI to prove ∀((x: T) => P(x))
        4 Let ((a: T) => SubProof(

          //no obvious way to get P(a), try PbC
          5 SubProof(
            6 Assume( !P(a) ),

            //error on proof step 7 in lecture
            //was a bug in Logika. It is fixed in the
            //newest release.
            7 ( ∃((x: T) => !P(x)) ) by ExistsI[T](6),
            8 ( F ) by NegE(7, 3)

            //goal: F
          ),
          9 ( P(a) ) by PbC(5)
          //afterward, use Pbc to conclude P(a)

          //goal: P(a) (prove our goal for all with random indiv)
        )),
        10 ( ∀((x: T) => P(x)) ) by AllI[T](4),
        11 ( F ) by NegE(10, 1)

        //if we got ∀((x: T) => P(x)), would contradict with premise
        //goal: contradiction
      ),
      12 ( ∃((x: T) => !P(x)) ) by PbC(2)

      //conclude ∃((x: T) => !P(x)) using PbC
    )
    //@formatter:on
  )
}

