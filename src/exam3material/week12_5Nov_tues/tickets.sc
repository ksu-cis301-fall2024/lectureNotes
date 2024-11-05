// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

//adult tickets: $50
//kid tickets: $30
def getTicketCosts(adult: Z, kid: Z): Z = {
  //function contract
  Contract(
    Requires(adult >= 0, kid >= 0),
    Ensures(
      //what should we promise?
      //Res[Z]
      Res[Z] == adult*50 + kid*30,
      Res[Z] >= 0
    )
  )

  //Step 2: list preconditions as premises


  //get the total ticket cost
  val overall: Z = adult*50 + kid*30

  //Step 3: prove we have satisfied the postconditions

  Deduce(
    1 ( overall == adult*50 + kid*30) by Premise, //proves postcondition
    2 (adult >= 0) by Premise, //from precondition
    3 (kid >= 0) by Premise, //from other precondition
    4 (overall >= 0) by Algebra*(1,2,3) //proves second postcondition
    //need: overall >= 0
  )

  return overall
}

////////////// Test code /////////////////

val k: Z = 3 //$30 each
val a: Z = 2 //$50 each

// Step 1 - prove the precondition before calling the function

Deduce(
  1 ( k == 3) by Premise,
  2 (a == 2) by Premise,
  3 (a >= 0) by Algebra*(2),
  4 (k>= 0) by Algebra*(1)

  //a >= 0
  //k >= 0
)

val cost: Z = getTicketCosts(a, k)

Deduce(
  1 ( cost == a*50 + k*30 ) by Premise, //use postcondition from function
  2 ( a == 2) by Premise,
  3 (k ==3 ) by Premise,
  4 (cost == 190) by Algebra*(1,2,3)
)

//step 4: use postconditions to prove your asserts


//what *should* cost be?
assert(cost == 190)