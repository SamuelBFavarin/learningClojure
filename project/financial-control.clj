; This is a simple program to control a personal finances, follow the features:  
; 
;  - Register a income or expense transaction
;  - Group all transactions by category (food, hobby, rent)
;  - Group all transactions by period
;  - Group all transactions by tags (necessary or unnecessary) 


; the financial transactions
(def transaction
  [{:value 33.0 :currency "R$" :type "expense" :comment "launch" :date "19/11/2016"}
   {:value 2700 :currency "R$" :type "income" :comment "job" :date "01/12/2016"}
   {:value 29 :currency "R$" :type "expense" :comment "Clojure Book" :date "03/12/2016"}])

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

; lets create a resume text by transactions:
; first, lets flag a value as "-" to expense or "+" to income 
(defn flagged-value [transaction]
  (let [currency (:currency transaction "R$") value (:value transaction)]
    (if (= (:type transaction) "expense")
      (str currency " -" value)
      (str currency " +" value))))

(flagged-value (first transaction))
(flagged-value (second transaction))

; now, lets create a function to show a transaction value as "date => R$ +- value"
(defn date-value [transaction]
  (str (:date transaction) " => " (flagged-value transaction)))

(date-value (first transaction))

(defn yuan-transaction [transaction]
  (assoc transaction :value (* 2.15 (:value transaction))
         :currency "¥"))

(yuan-transaction (first transaction))
