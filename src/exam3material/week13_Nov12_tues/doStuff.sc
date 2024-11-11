// #Sireum #Logika
//@Logika: --background disabled

import org.sireum._

def doStuff(bound: Z): Z = {
  Contract(
    Requires(bound >= 1),
    Ensures(Res[Z] == //what?)
  )
  var i: Z = 0
  var total: Z = 0

  while (i < bound) {
    Invariant(
      Modifies(total, i),
      i >= 0,
      i <= bound,
      //what else?
    )

    i = i + 1
    total = total + (2*i - 1)
  }

  return total
}

////////////////// Test code /////////////

assert(doStuff(1) == ?)
assert(doStuff(2) == ?)
assert(doStuff(3) == ?)