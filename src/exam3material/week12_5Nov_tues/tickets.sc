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
    Requires(//what should we require?),
    Ensures(
      //what should we promise?
    )
  )

  //Step 2: list preconditions as premises


  //get the total ticket cost
  val overall: Z = adult*50 + kid*30

  //Step 3: prove we have satisfied the postconditions

  return overall
}

////////////// Test code /////////////////

val k: Z = 3
val a: Z = 2

// Step 1 - prove the precondition before calling the function


val cost: Z = getTicketCosts(a, k)


//step 4: use postconditions to prove your asserts


//what *should* cost be?