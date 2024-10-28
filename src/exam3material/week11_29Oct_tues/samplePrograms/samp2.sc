// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._

//get user input number, print whether
//it is positive or negative

//what does "val" mean?
val num: Z = Z.prompt("Enter a number: ")

if (num > 0) {
  println(num, " is positive")
} else {
  println(num, " is negative (or zero)")
}