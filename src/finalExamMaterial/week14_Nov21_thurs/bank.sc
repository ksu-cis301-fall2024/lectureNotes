// #Sireum #Logika
//@Logika: --background disabled
import org.sireum._

var balance: Z = 0
var elite: B = F
val eliteMin: Z = 1000000 // $1M is the minimum balance for elite members

//these are the global invariants
@spec def inv = Invariant(
  balance >= 0,
  elite == (balance >= eliteMin)
)

def deposit(amount: Z): Unit = {
  //what can we assume about the global invariants here?
  Contract(
    Requires(amount >= 0),
    Modifies(balance, elite),
    Ensures(
      balance == In(balance) + amount
    )
  )

  //write code
  balance = balance + amount

  if (balance >= eliteMin) {
    elite = true
  }

  //then do verification

  //what must be true about the global invariants here?
}

def withdraw(amount: Z): Unit = {
  Contract(
    Requires(
      //amount >= 0,
      balance >= amount
    ),
    Modifies(balance, elite),
    Ensures(
      balance == In(balance) - amount
    )
  )

  //write code

  balance = balance - amount

  //NOTE: can use this simplified update,
  //but only if we include the "amount >= 0" precondition
  //(which shouldn't be needed, as the global invariant where the
  //balance needs to be nonnegative together with "balance >= amount"
  //implies that the amount must be >= 0)
  /*
  if (balance < eliteMin) {
    elite = false
  }
  */

  if (balance >= eliteMin) {
    elite = true
  } else {
    elite = false
  }

  //then do verification
}

//////////////// Test code /////////////////////

deposit(500000)
assert(balance == 500000 & !elite)
deposit(600000)
assert(balance == 1100000 & elite)
withdraw(150000)
assert(balance == 950000 & !elite)
deposit(200000)
assert(balance == 1150000 & elite)