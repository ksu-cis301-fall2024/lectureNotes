// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

def absVal(numOrig: Z) : Z = {
  //what do we need here?
  Contract(
    //no requirements needed
    Ensures(
      Res[Z] >= 0,
      Res[Z] == numOrig | Res[Z] == -1 * numOrig
    )
  )

  var num: Z = numOrig

  //update num to be the absolute value of the input
  if (num < 0) {
    num = num * -1

    Deduce(
      1 ( num == Old(num) * -1) by Premise, //from assignment
      2 ( Old(num) < 0) by Premise, //from condition

      3 ( num >= 0 ) by Algebra*(1, 2),
      4 ( Old(num) == numOrig) by Premise,
      5 ( num== -1 * numOrig ) by Algebra*(1, 4)
    )

    //need: num>=0
    //num == numOrig OR num== -1 * numOrig
  } else {
    //do nothing -- num is already its own absolute value

    Deduce(
      1 (!(num < 0)) by Premise, //condition is false
      2 ( num >= 0 ) by Algebra*(1),
      3 ( num == numOrig ) by Premise
    )

    //need: num >= 0
    //num == numOrig OR num== -1 * numOrig
  }

  Deduce(
    1 ( num >= 0 ) by Premise, //true in both branches
    2 ( num == numOrig | num== -1 * numOrig ) by Premise
        //LHS from else, RHS from if
  )

  //these were our old asserts
  //assert(num >= 0)
  //assert(num == numOrig | num == -1 * numOrig)
  //what do we return?

  //need to prove: both postconditions
  //num >= 0
  //num == numOrig | num== -1 * numOrig

  return num

}

////////////////// Test code //////////////

val x: Z = -4

//use function to get absolute value of x
//what *should* the absolute value be?

//function doesn't have preconditions, so don't need to prove
//them here

val ans: Z = absVal(x)

Deduce(
  1 ( ans >= 0 ) by Premise, //from first postcondition
  2 ( ans == x | ans == -1 * x) by Premise, //from 2nd postcondition
  3 ( x == -4 ) by Premise

  //WILL FINISH ON THURSDAY
)

assert(ans == 4)