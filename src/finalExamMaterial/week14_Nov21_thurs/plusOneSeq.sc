// #Sireum #Logika
//@Logika: --background disabled
import org.sireum._

//add 1 to all elements
def plusOne(nums: ZS): Unit = {
  var i: Z = 0
  while (i < nums.size) {
    nums(i) = nums(i) + 1
    i = i + 1
  }
}

///////////////////////////

var test: ZS = ZS(4,1,3,8,10,2)

plusOne(test)

//what do we want to assert?