; This is a simple program to control a personal finances, follow the features:  
; 
;  - Register a income or expense transaction
;  - Group all transactions by category (food, hobby, rent)
;  - Group all transactions by period
;  - Group all transactions by tags (necessary or unnecessary) 


; the financial transactions
(def transaction
  [{:value 33.0 :type "expense" :comment "launch" :date "19/11/2016"}
   {:value 2700 :type "income" :comment "job" :date "01/12/2016"}
   {:value 29 :type "expense" :comment "Clojure Book" :date "03/12/2016"}])

; function to resume a transaction
(defn resume [transaction]
  (select-keys transaction [:value :type :date]))

(map resume transaction)

; filter transactions by type
(defn expense? [transaction]
  (= (:type transaction) "expense"))

(filter expense? transaction)

; lets sum all values!
; this function get only value by transaction
(defn only-value [transaction]
  (:value transaction))

; get only expense transactions value
(map only-value (filter expense? transaction))

; sum all expense transactions values 
(reduce + (map only-value (filter expense? transaction)))

; we can do this with the other way, look:
(reduce +
        (map #(:value %)
             (filter #(= (:type %) "expense")
                     transaction)))


; get only values more than $100


(defn big-value? [transaction]
  (> (:value transaction) 100))

(filter big-value? transaction)

; doing the same thing, but with anon function:
; we use "fn" to create anon functions
(filter (fn [transaction]
          (> (:value transaction) 100))
        transaction)

; short way to create a anon function 
(filter #(> (:value %) 100) transaction)


; get first value from transactions


(only-value (first transaction))

; or using "thread-first"
(-> (first transaction)
    (only-value))

; thread-last
(->> (filter expense? transaction)
     (map only-value)
     (reduce +))