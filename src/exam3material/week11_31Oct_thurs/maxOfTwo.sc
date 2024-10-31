// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._


val a: Z = Z.prompt("Enter first number: ")
val b: Z = Z.prompt("Enter second number: ")

var max: Z = 0

if (a > b) {
  max = a

  Deduce(
    1 ( a > b ) by Premise, //if condition is true
    2 ( max == a ) by Premise, //from assignment
    3 ( max >= a ) by Algebra*(2), //needed for first assert
    4 ( max >= b ) by Algebra*(1, 2), //needed for first assert
  )
} else {
  max = b

  Deduce(
    1 ( !(a > b) ) by Premise, //if condition is false
    2 ( max == b ) by Premise, //from assignment
    3 ( a <= b ) by Algebra*(1),
    4 ( max >= b ) by Algebra*(2), //needed for first assert
    5 ( max >= a ) by Algebra*(3, 4) //needed for second assert
  )
}

//summarize what I learned, build my asserts
Deduce(
  1 ( max >= a ) by Premise, //true in both branches
  2 ( max >= b ) by Premise, //true in both branches
  3 ( max == a | max == b ) by Premise, //LHS in if, RHS in else
  4 ( max >= a & max >= b) by AndI(1, 2)
)

//assert that we have found the max
assert(max >= a & max >= b)
assert(max == a | max == b)