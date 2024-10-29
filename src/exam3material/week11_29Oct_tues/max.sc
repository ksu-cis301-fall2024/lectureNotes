// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

val x: Z = Z.prompt("Enter first number: ")
val y: Z = Z.prompt("Enter second number: ")

//how do we assume x is bigger than y?
assume(x >= y)

val max: Z = x

Deduce(
  1 (x >= y) by Premise,
  2 (max == x) by Premise,
  3 (max >= x) by Algebra*(2),
  4 (max >= y) by Algebra*(1, 2),
  5 (max >= x & max >=y ) by AndI(3, 4),
  6 (max == x | max == y) by OrI1(2)
)


//what can we put in a proof block here?

//how do we assert max is the biggest between our two inputs?

assert(max >= x & max >= y)
assert(max == x | max == y)