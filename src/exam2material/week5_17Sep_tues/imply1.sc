// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

@pure def imply1(p: B, q: B, r: B): Unit = {
  Deduce(
    //@formatter: off

    (p __>: r, q __>: r ) |- ( p & q __>: r  )
      Proof(
      1 (  p __>: r   ) by Premise,
      2 (  q __>: r   ) by Premise,

    )
    //@formatter:on
  )
}