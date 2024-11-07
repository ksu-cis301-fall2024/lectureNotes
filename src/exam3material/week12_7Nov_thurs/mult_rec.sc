// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

//want to return x * y, through repeated addition
//recursively compute x + x + ... + x (y times)
def mult(x: Z, y: Z): Z = {
  Contract(
    Requires(y >= 0),
    Ensures(Res[Z] == x*y)
  )
  //what goes here?
  //what should we require?
  //what should we ensure?

  //we want answer to hold our calculation
  var answer: Z = 0

  if (y == 0) {
    answer = 0

    //what do we need to do here?
    //prove postcondition, answer == x*y

    Deduce(
      1 ( answer == 0 ) by Premise, //from assignment
      2 ( y == 0 ) by Premise, //from if condition
      3 (  answer == x*y ) by Algebra*(1,2) //proves postcondition
    )
  } else {
    //what do we need to do here?

    //prove precondition for the recursive call
    Deduce(
      1 ( !(y == 0) ) by Premise, //if condition is false
      2 ( y >= 0) by Premise, //from precondition
      3 ( y-1 >= 0) by Algebra*(1,2) //proves precondition for rec. call
      //goal: second parameter (y) >= 0
      //need exactly: y-1 >= 0
    )

    var temp: Z = mult(x, y-1)
    answer = x + temp

    Deduce(
      1 ( temp == x*(y-1) ) by Premise, //from postcondition of rec. call
      2 ( answer == x + temp ) by Premise, //from assignment statement
      3 ( answer == x + x*(y-1) ) by Algebra*(1, 2),
      4 ( answer == x*y ) by Algebra*(3)
    )

    //what do we need to show here?
    //prove postcondition, answer == x*y
  }

  Deduce(
    1 ( answer == x*y ) by Premise //showed postcondition in both branches
  )

  //what do we need to do here?
  //prove postcondition, answer == x*y

  return answer
}

////////////// Test code //////////////

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