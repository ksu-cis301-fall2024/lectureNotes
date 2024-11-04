// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

def absVal(numOrig: Z) : Z = {
  //what do we need here?

  var num: Z = numOrig

  //update num to be the absolute value of the input
  if (num < 0) {
    num = num * -1

  } else {
    //do nothing -- num is already its own absolute value

  }

  //these were our old asserts
  //assert(num >= 0)
  //assert(num == numOrig | num == -1 * numOrig)
  //what do we return?

}

////////////////// Test code //////////////

val x: Z = -4

//use function to get absolute value of x
//what *should* the absolute value be?
