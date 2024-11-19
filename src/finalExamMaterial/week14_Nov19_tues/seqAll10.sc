// #Sireum #Logika
//@Logika: --background disabled
import org.sireum._

//set all elements to 10
def all10(nums: ZS): Unit = {
  Contract(
    Modifies(nums),
    Ensures(
      ∀(0 until nums.size) (k => nums(k) == 10)
    )
  )

  var i: Z = 0
  while (i < nums.size) {
    Invariant(
      Modifies(i, nums),
      i >= 0,
      i <= nums.size,
      ∀(0 until i) (k => nums(k) == 10)
    )

    nums(i) = 10
    i = i + 1
  }
}

///////////////////////////

var test: ZS = ZS(4,1,3,8,10,2)

all10(test)

//what do we want to assert?
assert(test == ZS(10,10,10,10,10,10))