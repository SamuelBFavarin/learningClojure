(defn rest_of_div [dividend divisor]
  ( = 0 (mod dividend divisor))
)

(defn fizzbuzz [value] 
  (cond
    
    (and 
      (rest_of_div value 3)
      (rest_of_div value 5)
    )"fizzbuzz"
     
    (rest_of_div value 3) "fizz"
    (rest_of_div value 5) "buzz"
    :else value  
  )
)

(fizzbuzz 2)
(fizzbuzz 5)
(fizzbuzz 3)
(fizzbuzz 15)


