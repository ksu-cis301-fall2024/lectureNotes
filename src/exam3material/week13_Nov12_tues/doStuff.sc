// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

def doStuff(bound: Z): Z = {
  Contract(
    Requires(bound >= 1),
    Ensures(Res[Z] == bound*bound)
  )
  var i: Z = 0
  var total: Z = 0

  //Step 1: prove the invariant holds before the loop begins
  //want a claim that is: "total == i*i"

  Deduce(
    1 ( i == 0 ) by Premise,
    2 ( total == 0) by Premise,
    3 ( total == i*i ) by Algebra*(1,2) //proves invariant before loop
  )

  while (i != bound) {
    Invariant(
      Modifies(total, i),
      total == i*i
    )

    i = i + 1

    //put a block after each variable update
    Deduce(
      1 ( i == Old(i) + 1 ) by Premise, //from assignment
      2 ( total == Old(i)*Old(i) ) by Premise,   //from invariant

      //we know Old(i) == i - 1
      3 ( total == (i - 1)*(i - 1) ) by Algebra*(1, 2)
    )

    total = total + (2*i - 1)

    Deduce(
      1 ( total == Old(total) + (2*i - 1) ) by Premise, //from assignment
      2 ( Old(total) == (i - 1)*(i - 1) ) by Premise, //from previous block
      3 ( total == (i - 1)*(i - 1) + (2*i - 1)) by Algebra*(1,2), //put those two together
      4 ( total == i*i ) by Algebra*(3) //proves invariant
      //want: total == i*i
    )

    //Step 2: prove invariant still holds at end of iteration
    //want a claim that is: "total == i*i"
  }

  //Step 3: prove the postcondition
  //need the claim total == bound*bound

  Deduce(
    1 ( total == i*i ) by Premise, //invariant holds at end of iteration
    2 ( !(i != bound) ) by Premise, //loop condition is false
    3 ( bound == i ) by Algebra*(2),
    4 ( total == bound*bound ) by Algebra*(1,3) //proves postcondition
  )

  return total
}

////////////////// Test code /////////////

val x: Z = 5

//Must prove precondition before function call
//need: x-3 >= 1

Deduce(
  1 ( x == 5 ) by Premise,
  2 ( x-3 >= 1 ) by Algebra*(1) //proves precondition
)

val ans: Z = doStuff(x-3)

//after calling function, can use its postcondition as a premise

Deduce(
  1 ( ans == (x-3)*(x-3) ) by Premise, //from postcondition
  2 ( x == 5 ) by Premise,
  3 ( ans == 4 ) by Algebra*(1,2) //proves assert
)

//need: "ans == 4" exactly

assert(ans == 4)