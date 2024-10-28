// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._

//use a loop to print the numbers from 10 down to 1

var cur: Z = 10
while (cur >= 1) {
  println("Next number: ", cur)
  cur = cur - 1
}