// #Sireum #Logika
//@Logika: --background disabled
import org.sireum._

//add 1 to all elements
def plusOne(nums: ZS): Unit = {
  //function contract
  Contract(
    Modifies(nums),
    Ensures(
      //for every value in nums, it is one bigger than the original value
      ∀(0 until nums.size) (k => (nums(k) == In(nums)(k) + 1))
    )
  )

  var i: Z = 0
  while (i < nums.size) {
    //loop invariant
    Invariant(
      Modifies(nums, i),
      i >= 0, //lower bound for the loop counter
      i <= nums.size, //upper bound for the loop counter,
      nums.size == In(nums).size, //size doesn't change
      ∀(0 until i) (k => (nums(k) == In(nums)(k) + 1)), //what elements have changed
      ∀(i until nums.size) (k => (nums(k) == In(nums)(k))) //what elements haven't changed
    )

    nums(i) = nums(i) + 1
    i = i + 1
  }
}

///////////////////////////

var test: ZS = ZS(4,1,3,8,10,2)

plusOne(test)

//what do we want to assert?
assert(test == ZS(5,2,4,9,11,3))