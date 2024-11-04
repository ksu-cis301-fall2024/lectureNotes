// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

//just the code for finding the biggest of 3 numbers

val a: Z = Z.read()    //suppose a is 3
val b: Z = Z.read()    //suppose b is 5
val c: Z = Z.read()    //suppose c is 10
var max: Z = 0

/*
1) finish the code
2) add asserts at the bottom
3) mark where logic blocks would go
4) finish the verification in the next file
*/

if (a >= b) {
  //finish code here

  //what do we know is NOT the max? b

  if (a >= c) {
    max = a

  } else {
    max = c

  }
} else {
  //finish code here

  //what do we know is NOT the max? a

  if (b >= c) {
    max = b

  } else {
    max = c

  }
}

//overall summary here

println("Max between ", a, ", ", b, " and ", c, " is ", max)

//How do we know we have the max?
//what assert(s) do we want?

//need the first 3 in EVERY branch
//need ONE of the last assert in every branch

assert(max >= a)
assert(max >= b)
assert(max >= c)
assert(max == a | max == b | max == c)