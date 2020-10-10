
; we can create a list as
'(1 2 3 4 5 6)

; or
(list 1 2 3 4 5 6)

; take name of lists
(def one-to-six '(1 2 3 4 5 6))
(count one-to-six)

; use range to create a list
(def one-to-ten (range 1 10))
(count one-to-ten)

; other example of list
(def stuffs '("Car" "Book" 1999 24 10))
(nth stuffs 0)
(nth stuffs 4)
(last stuffs)
(first stuffs)

(conj stuffs "Phone")
stuffs



