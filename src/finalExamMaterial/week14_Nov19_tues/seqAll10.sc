// #Sireum #Logika
//@Logika: --background disabled
import org.sireum._

//set all elements to 10
def all10(nums: ZS): Unit = {

  var i: Z = 0
  while (i < nums.size) {
    nums(i) = 10
  }
}

///////////////////////////

var test: ZS = ZS(4,1,3,8,10,2)

all10(test)

//what do we want to assert?