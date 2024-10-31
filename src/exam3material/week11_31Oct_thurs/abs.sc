// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

var num: Z = Z.prompt("Enter a number: ")
val numOrig : Z = num


if (num < 0) {
  num = num * -1

  Deduce(
    1 ( Old(num) < 0 ) by Premise, //if condition was true
    2 ( num == Old(num) * -1 ) by Premise, //from assignment
    3 ( numOrig == Old(num) ) by Premise, //from previous assignment
    4 ( num >= 0 ) by Algebra*(1,2), //needed for second assert
    5 ( num == numOrig * -1 ) by Subst_>(3 ,2) //for first assert
  )

} else {
  //no code, just for verification

  Deduce(
    1 ( numOrig == num ) by Premise, //from previous assignment
    2 ( num == numOrig ) by Algebra*(1), //for first assert
    3 ( !(num < 0) ) by Premise, //if condition is false
    4 ( num >= 0 ) by Algebra*(3) //needed for second assert
  )
}

Deduce(
  1 (num >= 0 ) by Premise, //true in both branches
  2 (num == numOrig | num == numOrig * -1) by Premise //LHS from else
                                                  //RHS from if
)

//How can we assert that num is the absolute value of the input?
//numOrig was the original input

assert(num == numOrig | num == numOrig * -1)
assert(num >= 0)

