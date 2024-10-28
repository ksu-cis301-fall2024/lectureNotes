// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

var x: Z = Z.read()
var y: Z = Z.read()

//save out the original values
val xOrig: Z = x
val yOrig: Z = y

//x = 7, y = 4

//want to swap x and y
x = x + y           //x = ?, y = ?


y = x - y            //x = ?, y = ?



x = x - y           //x = ?, y = ?

//what do we want to claim we did?
