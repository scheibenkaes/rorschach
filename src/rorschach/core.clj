(ns rorschach.core)

(defmacro derive-atom
  "Defines a new atom 'new-atm' and adds a watch to the original atom.
 whenever the origin gets updated f will be called with the new value
 and its return value will be stored into new-atm."
  [atm new-atm key f & [inital-value]]
  `(do
     (def ~new-atm (atom (or ~inital-value (~f (deref ~atm)))))
     (add-watch ~atm ~key (fn [r# k# old# n#]
                            (reset! ~new-atm (~f n#))))))

