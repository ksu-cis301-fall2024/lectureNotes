// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

var x: Z = Z.prompt("Enter a positive number: ")

assume(x > 0)


//orig will always be the original user input value
val orig: Z = x

//do we need a proof block here? no

x = x + 1

Deduce(
  1 ( x == Old(x) + 1 ) by Premise,
  2 ( orig == Old(x) ) by Premise,
  3 ( x == orig + 1 ) by Subst_>(2 , 1),
  4 ( Old(x) > 0 ) by Premise,
  5 ( x > 0 ) by Algebra*(1, 4)

  //want: x == orig + 1 at this point
  //goal: express what just changed WITHOUT using Old value
)


//what can we put in a proof block here?
//what should we be able to assert about x and orig?

x = x + 2

Deduce(
  1 ( x == Old(x) + 2 ) by Premise, //from assignment
  2 ( Old(x) == orig + 1 ) by Premise, //from previous block
  3 ( x == orig + 3 ) by Algebra*(1, 2),
  4 ( Old(x) > 0 ) by Premise, //from previous block
  5 ( x > 0 ) by Algebra*(1, 4),
  6 ( x == orig + 3 & x > 0 ) by AndI(3, 5)
)

//what can we put in a proof block here?

//what do we want to assert? How has x changed?

//Once it is working - if x was originally positive,
//how could we assert that x was still positive at the end?

assert( x == orig + 3 & x > 0 )