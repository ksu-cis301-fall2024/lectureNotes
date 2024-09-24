// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

//(c ∧ n) → t, h ∧ ¬s, h ∧ ¬(s ∨ c) → p ⊢ (n ∧ ¬t) → p


@pure def big1(c: B, n: B, t: B, h: B, s: B, p: B): Unit = {
  Deduce(
    //@formatter: off

    ( (c & n) __>: t, h & !s, h & !(s | c) __>: p ) |- ( n & !t __>: p )
      Proof(
        1 ( (c & n) __>: t ) by Premise,
        2 ( h & !s ) by Premise,
        3 ( h & !(s | c) __>: p ) by Premise,
        4 ( h ) by AndE1(2),
        5 ( !s ) by AndE2(2),

        //follow ImplyI pattern
        6 SubProof(
            7 Assume ( n & !t ), //LHS
            8 ( n ) by AndE1(7),
            9 ( !t ) by AndE2(7),

            //goal: p (RHS)
            //p is RHS of premise 3
            //need h & !(s | c) for LHS to use that premise
            //already have h, just need !(s | c)

            //goal: !(s | c)

            //follow NegI pattern
            10 SubProof(
                11 Assume (s | c),

                //try OrE to get F in both cases

                12 SubProof(
                    13 Assume(s),
                    14 (F) by NegE(13, 5)
                    //want: F
                ),
                15 SubProof(
                    16 Assume(c),
                    17 (c & n) by AndI(16, 8),
                    18 ( t ) by ImplyE(1, 17),
                    19 ( F ) by NegE(18, 9)
                    //want: F
                ),
                20 (F) by OrE(11, 12, 15)
                //goal: F
            ),
            21 (!(s | c)) by NegI(10),
            22 (h & !(s | c)) by AndI(4, 21),
            23 (p) by ImplyE(3, 22)
        ),
        24 (n & !t __>: p) by ImplyI(6)
    )
    //@formatter:on
  )
}