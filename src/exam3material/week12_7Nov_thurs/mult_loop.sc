// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

//finding x*y by doing x + x + x + ... + x (y times)
def mult(x: Z, y: Z): Z = {
  //What can we use as the function contract?
  Contract(
    Requires(y >= 0),
    Ensures(Res[Z] == x*y)
  )

  var total: Z = 0
  var i: Z = 0

  //what do we need to do with the loop invariant here? prove it

  Deduce(
    1 ( total == 0 ) by Premise,
    2 ( i == 0 ) by Premise,
    3 ( total == i*x ) by Algebra*(1,2), //proves loop invariant,
    4 ( y >= 0  ) by Premise, //from precondition
    5 ( i <= y ) by Algebra*(2,4) //proves 2nd invariant
  )

  //want: total == i*x

  while (i < y) {
    //what should the loop invariant be?
    Invariant(
      Modifies(total, i),
      //what should the loop invariant be?
      total == i*x,
      i <= y
    )

    //what can we do with the loop invariant here?

    total = total + x

    Deduce(
      1 ( total == Old(total) + x ) by Premise, //from assignment
      2 ( Old(total) == i*x) by Premise, //from loop invariant
      3 ( total == i*x + x ) by Algebra*(1,2)
    )

    i = i + 1

    Deduce(
      1 ( i == Old(i) + 1 ) by Premise, //from assignment
      2 ( total == Old(i)*x + x) by Premise, //from previous block
      3 ( total == (i-1)*x + x ) by Algebra*(1,2),
      4 ( total == i*x ) by Algebra*(3), //proves invariant still holds
      5 ( Old(i) < y ) by Premise, //from loop condition
      6 ( i <= y ) by Algebra*(1, 5) //proves 2nd invariant
    )

    //what do we need to do with the loop invariant here?

    //need: total == i*x (prove invariant still holds)
    //need: i <= y
  }

  //what do we need to do here? prove postcondition

  //need: total == x*y

  Deduce(
    1 ( total == i*x  ) by Premise, //loop invariant is true
    2 ( !(i < y) ) by Premise, //loop condition is false
    3 ( i <= y ) by Premise, //from 2nd loop invariant
    4 ( i == y ) by Algebra*(2,3),
    5 ( total == x*y ) by Algebra*(1,4) //proves postcondition
  )

  return total
}

//////////// test code /////////

val a: Z = 5
val b: Z = 4

//Step 1: prove the precondition

Deduce(
  1 ( b == 4 ) by Premise,
  2 ( b >= 0 ) by Algebra*(1) //proves precondition
  //need: b >= 0 to prove precondition
)

var ans: Z = mult(a, b)

//what do we want to assert that ans is?

Deduce(
  1 ( ans == a*b ) by Premise, //from postcondition
  2 ( a == 5 ) by Premise,
  3 ( b == 4 ) by Premise,
  4 ( ans == 20 ) by Algebra*(1,2,3) //proves assert
)

assert(ans == 20)