// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

//FIRST: walk through with num = 6
//why do we know the odd/even results at each checkpoint?

var num: Z = Z.prompt("Enter an even number: ")

//what assumptions are we making about user inputs?
//how to put those in assumes?

num = num + 1

//assert that num is now odd

num = num * 2

//assert that num is now even