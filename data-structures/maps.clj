; a keyword
:a

; a map can be created as
(hash-map :valor 200 :tipo "Receita")

; or

(def trasacao {:valor 200 :tipo "receita"})

; add a new key-value
(assoc trasacao :categoria "educação")

trasacao

(get trasacao :valor)

(:valor trasacao)

(def transacao-desnecessaria {:valor 34
                              :tipo "despesa"
                              :rotulos '("desnecessaria" "cartao")})

(:rotulos transacao-desnecessaria)
(:rotulos trasacao)

(:rotulos trasacao '())