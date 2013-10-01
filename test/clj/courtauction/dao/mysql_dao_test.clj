(ns courtauction.dao.mysql-dao-test
  (:use [clojure test]
        [courtauction.domain]
        ) 
  (:require [courtauction.beans :as beans]
            )
  )

(deftest add-courtauction-test 
  (let [dao-impl# (beans/get-obj :courtauction-dao)
        a-courtauction (struct courtauction nil (.getTime (new java.util.Date)) "caDesc"
                               1 "itemType" "addr0" 
                                "addr1" "addr2" "addr"
                                "addrInfo" "remarks" 2000000
                                1000000 "auctionInfo" "auctionTel"
                                     "2013-10-01 10:00" "auctionLoc" "status")
        id (:generated_key (first (.add-courtauction dao-impl# a-courtauction)))
        ret-courtauction (first (.get-courtauction dao-impl# id))]
    (println (:caNo a-courtauction) (:caNo ret-courtauction))
    (is (:caNo a-courtauction) (:caNo ret-courtauction))
    )
  )