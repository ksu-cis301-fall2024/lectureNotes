// #Sireum #Logika
//@Logika: --background disabled
import org.sireum._

//want to write a swap function
def swap(nums: ZS, pos1: Z, pos2: Z): Unit = {
  var temp: Z = nums(pos1)
  nums(pos1) = nums(pos2)
  nums(pos2) = temp
}

///////////////////////////

var test: ZS = ZS(4,1,3,8,10,2)

swap(test, 2, 4)


//what do we want to assert?