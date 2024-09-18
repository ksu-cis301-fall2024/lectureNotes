// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

@pure def lem(p: B): Unit = {
  Deduce(
    //@formatter: off

    |- ( p | !p )
      Proof(

    )
    //@formatter:on
  )
}