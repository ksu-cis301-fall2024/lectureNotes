// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

//FIRST: walk through with num = 6
//why do we know the odd/even results at each checkpoint?

var num: Z = Z.prompt("Enter an even number: ")

Deduce(
  1 (2 != 0) by Algebra*()
)

assume(num % 2 == 0)

//what assumptions are we making about user inputs?
//how to put those in assumes?

num = num + 1

Deduce(
  1 ( num == Old(num) + 1 ) by Premise, //from assignment
  2 ( Old(num) % 2 == 0) by Premise, //from assume
  3 ( num % 2 == 1 ) by Algebra*(1,2)
)

//assert that num is now odd

assert(num % 2 == 1)

num = num * 2

Deduce(
  1 ( num == Old(num)* 2 ) by Premise, //from assignment
  2 ( num % 2 == 0 ) by Algebra*(1)
)

//assert that num is now even

assert(num % 2 == 0)