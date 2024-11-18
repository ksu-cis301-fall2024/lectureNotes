// #Sireum #Logika
//@Logika: --background disabled

import org.sireum._

def nested(num: Z, rows: Z, cols: Z): Z = {
  Contract(
    Requires (rows >= 1, cols >= 1),
    Ensures(Res[Z] == ??)
  )

  var i: Z = 0
  var sum: Z = 0

  while (i < rows) {
    Invariant(
      Modifies(i, sum),
      i >= 0,
      i <= rows,
      //what else?
    )

    var j: Z = 0
    var line: Z = 0
    while (j < cols) {
      Invariant(
        Modifies(j, line),
        j >= 0,
        j <= cols,
        //what else?
      )

      line = line + num
      j = j + 1
    }

    sum = sum + line
    i = i + 1
  }

  return sum
}



////////////// Test code ////////////

assert(nested(1,2,3) == ?)
assert(nested(-2,4,2) == ?)
assert(nested(3,3,3) == ?)