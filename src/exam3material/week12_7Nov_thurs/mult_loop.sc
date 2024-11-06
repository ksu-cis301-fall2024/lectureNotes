// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

//finding x*y by doing x + x + x + ... + x (y times)
def mult(x: Z, y: Z): Z = {
  //What can we use as the function contract?

  var total: Z = 0
  var i: Z = 0

  while (i != y) {
    //what should the loop invariant be?
    Invariant(
      Modifies(???),
      //what should the loop invariant be?
    )

    //assume loop invariant holds here (premise)

    total = total + x

    i = i + 1

    //Step 2: need to prove that invariant still holds
  }

  return total
}

//////////// test code /////////

val a: Z = 5
val b: Z = 4

//Step 1: prove the precondition

var ans: Z = mult(a, b)

//what do we want to assert that it is?