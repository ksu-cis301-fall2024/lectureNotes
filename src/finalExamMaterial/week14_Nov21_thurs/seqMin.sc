// #Sireum #Logika
//@Logika: --background disabled
import org.sireum._

//return the smallest element in list
def min(list: ZS): Z = {
  Contract(
    Requires(list.size > 0),
    Ensures(
      //describe the return value
      //should be less than or equal to every value in list
      ∀(0 until list.size) (k => Res[Z] <= list(k)),

      //the thing I'm returning really is one of the list values
      ∃(0 until list.size) (k => Res[Z] == list(k))
    )
  )

  //write the function
  var small: Z = list(0)
  var i: Z = 1
  while (i < list.size) {
    Invariant(
      Modifies(i, small),
      i >= 1, //lower bound for loop counter
      i <= list.size, //upper bound for loop counter
      ∀(0 until i) (k => small <= list(k)),
      ∃(0 until i) (k => small == list(k))
    )

    if (list(i) < small) {
      small = list(i)
    }
    i = i + 1
  }

  return small

  //then do the verification
}

////////////// Calling code ///////////////////

var test: ZS = ZS(8,1,0,10,9,2,0)
var testMin: Z = min(test)

//what should testMin be?
//--> assert what?
assert(testMin == 0)