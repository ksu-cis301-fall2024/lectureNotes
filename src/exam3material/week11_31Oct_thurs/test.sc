// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

var x: Z = 4
var y: Z = x

x = x + 1

Deduce(

)

//If I comment out the total line below,
//I can't claim the two statements in the Deduce
//block as premises anymore

var total: Z = x + y

//These seem like the result of deductive reasoning
//instead of premises, but they are verified in
//manual mode as long as I have that "total" variable
//declared above
Deduce(
  1 ( y == 4 ) by Premise,
  2 ( x == y + 1 ) by Premise
)
