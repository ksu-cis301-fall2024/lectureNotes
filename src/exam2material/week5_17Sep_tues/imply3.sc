// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

@pure def imply3(p: B, q: B, r: B): Unit = {
  Deduce(
    //@formatter: off

    (p __>: (q __>: r)) |- ( (p __>: q) __>: (p __>: r)  )
      Proof(
      1 (  p __>: (q __>: r) ) by Premise,

    )
    //@formatter:on
  )
}