// #Sireum #Logika
//@Logika: --manual --background type

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

//Given premises:  a ∧ b, c
//Use natural deduction to prove: b ∧ c


@pure def and1(a: B, b: B, c: B): Unit = {
    Deduce(
        (a & b, c) |- (b & c)
        Proof(
            //PROOF GOES HERE

        )
    )
}