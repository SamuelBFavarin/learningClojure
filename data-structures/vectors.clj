
; we can create a vector as
(vector 1 2 3 4 5 6)

; or
[1 2 3 4 5 6]

; simple vector
(def vector-numbers [1 2 3 4 5 6])
(count vector-numbers)

(def singer ["Tim Maia" "Seu Jorge" 26 "janeiro" 1964])
(get singer 0)
(get singer 4)
(last singer)

(conj singer "MPB")

singer