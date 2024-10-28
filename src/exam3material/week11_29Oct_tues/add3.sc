// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._


var x: Z = Z.prompt("Enter a positive number: ")

assume(x > 0)


//orig will always be the original user input value
val orig: Z = x

//do we need a proof block here?

x = x + 1


//what can we put in a proof block here?
//what should we be able to assert about x and orig?

x = x + 2

//what can we put in a proof block here?

//what do we want to assert? How has x changed?

//Once it is working - if x was originally positive,
//how could we assert that x was still positive at the end?
