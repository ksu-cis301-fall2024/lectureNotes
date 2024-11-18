// #Sireum #Logika
//@Logika: --background disabled
import org.sireum._

//"Unit" is like a void return type
def makePosZero(seq: ZS, pos: Z): Unit = {
  //how would we write the function contract?
  //what do we want to require of seq?
  //how can we describe how seq will change?

  seq(pos) = 0
}

///// Test code ///////////

var nums: ZS = ZS(1,2,3)
makePosZero(nums, 2)

//we want to claim that nums is what it was, but with position 2
//changed to 0

//---> what should we assert?