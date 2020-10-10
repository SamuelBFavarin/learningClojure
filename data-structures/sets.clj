; We can create sets as
(hash-set "MPB" "FUNK")

; or
#{"MPB" "FUNK"}

(def music-generes (hash-set "MPB" "FUNK"))

(conj music-generes "ROCK")

(conj music-generes "FUNK")

music-generes