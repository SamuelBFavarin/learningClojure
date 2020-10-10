; This is a simple algorithm Fizzbuzz
; Write a program that for multiples of '3' print "Fizz" instead of the number and for the multiples of '5'- print "Buzz".

(defn rest_of_div [dividend divisor]
  (= 0 (mod dividend divisor)))

(defn fizzbuzz [value]
  (cond

    (and
     (rest_of_div value 3)
     (rest_of_div value 5)) "fizzbuzz"

    (rest_of_div value 3) "fizz"
    (rest_of_div value 5) "buzz"
    :else value))

; single call
(fizzbuzz 2)
(fizzbuzz 5)
(fizzbuzz 3)
(fizzbuzz 15)

; call fizzbuzz function for each number between 1 and 15 
; with list
(def one-to-fifteen (range 1 16))
(map fizzbuzz one-to-fifteen)

; call fizzbuzz function for each number between 1 and 5 
; with vector
(def one-to-five [1 2 3 4 5])
(map fizzbuzz one-to-five)