
(use 'ConnjurRV.readcyana 
;     'ConnjurRV.vizcharts  
     'ConnjurRV.structdisplay  
     'ConnjurRV.modelreducer
     'ConnjurRV.statistics
     'ConnjurRV.bmrbstats
     'clojure.contrib.generic.functor)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def my-protein (make-protein-from-files "data/connjur.seq" "data/connjur.prot"))

(def stats-protein
  (merge-bmrb my-protein))

(def example-stats 
  (protein-to-num-atoms-per-residue my-protein))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn shifts-on-structure
  "the shifts probably don't correspond to the structure"
  []
  (display-colored-struct 
   (load-pdb-struct "1TXR") 
   (color-map (protein-to-atomid-shifts my-protein))))

(defn norm-shifts-on-struct
  ""
  []
  (display-colored-struct
   (load-pdb-struct "1TXR")
   (color-map (normalized-shifts (protein-to-atomid-map stats-protein)))))

(comment
(defn shifts-on-histogram
  ""
  []
  (make-histogram (vals (protein-to-atomid-shifts my-protein)) "a"))
)