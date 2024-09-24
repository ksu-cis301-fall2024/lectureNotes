// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

//(p → q) → r, s → ¬p, t, (¬s ∧ t) → q ⊢ r

@pure def big2(p: B, q: B, r: B, s: B, t: B): Unit = {
  Deduce(
    //@formatter: off

    ( (p __>: q) __>: r, s __>: !p, t, (!s & t) __>: q ) |- ( r )
      Proof(
        1 ( (p __>: q) __>: r ) by Premise,
        2 ( s __>: !p ) by Premise,
        3 ( t ) by Premise,
        4 ( (!s & t) __>: q ) by Premise,

        //can't do anything yet with premises
        //would want to prove p-> q to use premise 1
    )
    //@formatter:on
  )
}