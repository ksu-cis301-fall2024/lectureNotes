// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

var num: Z = Z.prompt("Enter a number: ")
val numOrig : Z = num

if (num < 0) {
  num = num * -1
} else {
  //no code, just for verification

}

//How can we assert that num is the absolute value of the input?
