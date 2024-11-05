// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

val a: Z = Z.read()    //suppose a is 3
val b: Z = Z.read()    //suppose b is 5
val c: Z = Z.read()    //suppose c is 10
var max: Z = 0


if (a >= b) {
  //what do we know is NOT the max?
  if (a >= c) {
    max = a

    //proof block here
    //want: max is a, and max >= a, b, c
    Deduce(
      //FILL IN
      1 ( max == a ) by Premise,
      2 ( a >= b ) by Premise, //outer if is true
      3 (a >= c) by Premise, //inner if is true
      4 ( max >= a) by Algebra*(1),
      5 ( max >= b ) by Subst_>(1, 2),
      6 (max >= c) by Subst_>(1, 3),
      7 (max == a | max == b) by OrI1(1),
      8 (max == a | max == b | max == c) by OrI1(7)
      //max == a | max == b | max == c
    )
  } else {
    max = c

    //proof block here
    //want: max is c, and max >= a, b, c
    Deduce(
      //FILL IN
      1 (max == c) by Premise,
      2 (a >= b) by Premise, //outer if condition is true
      3 (!(a >= c)) by Premise, //inner if condition is false
      4 (max >= c) by Algebra*(1),
      5 (max >= a)  by Algebra*(1, 3),
      6 (max >= b) by Algebra*(2, 5),
      7 ( max == a | max == b | max == c ) by OrI2(1)
      //max == a | max == b | max == c
    )
  }

  //summary logic block
  Deduce(
    //FILL IN
    //what can we state as premises?
    //how do we get max == a V max == b V max == c?

    1 ( max >= a) by Premise,
    2 (max >= b) by Premise,
    3 ( max >= c) by Premise,
    4 ( max == a | max == b | max == c ) by Premise,
  )
} else {
  //what do we know is NOT the max?
  if (b >= c) {
    max = b

    //block here
    Deduce(
      1 (!(a >= b)) by Premise,
      2 (b >= c) by Premise,
      3 (max == b) by Premise,
      4 (max >= a) by Algebra*(3, 1),
      5 (max >= b) by Algebra*(3),
      6 (max >= c) by Algebra*(2, 3)
    )
  } else {
    max = c

    //block here
    Deduce(
      1 (!(a >= b)) by Premise,
      2 (!(b >= c)) by Premise,
      3 (max == c) by Premise,
      4 (max >= a) by Algebra*(1, 2, 3),
      5 (max >= b) by Algebra*(2, 3),
      6 (max >= c) by Algebra*(3)
    )
  }
  //summary block
  Deduce(
    1 (max >= a) by Premise,
    2 (max >= b) by Premise,
    3 (max >= c) by Premise,
    4 (max == b | max == c) by Premise,
    5 SubProof(
      6 Assume (max == b),
      7 (max == a | max == b) by OrI2(6),
      8 (max == a | max == b | max == c) by OrI1(7)
    ),
    9 SubProof(
      10 Assume (max == c),
      11 (max == a | max == b | max == c) by OrI2(10)
    ),
    12 (max == a | max == b | max == c) by OrE(4, 5, 9)
  )
}

//overall summary here
//summarize both branches
Deduce(
  1 (max >= a) by Premise,
  2 (max >= b) by Premise,
  3 (max >= c) by Premise,
  4 (max == a | max == b | max == c) by Premise
)

println("Max between ", a, ", ", b, " and ", c, " is ", max)

assert(max >= a)
assert(max >= b)
assert(max >= c)
assert(max == a | max == b | max == c)