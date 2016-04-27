;importing models

(import cus.fraud.detect.model.*)
(deftemplate Address       (declare (from-class Address)))
(deftemplate Browser   (declare (from-class Browser)))
(deftemplate CreditCard (declare (from-class CreditCard)))
(deftemplate Email    (declare (from-class Email)))
(deftemplate Fraud    (declare (from-class Fraud)))
(deftemplate IP    (declare (from-class IP)))
(deftemplate PayPal    (declare (from-class PayPal)))
(deftemplate Phone    (declare (from-class Phone)))
(deftemplate Risk    (declare (from-class Risk)))

;defining rules

(defrule csc-doesnt-match
    "IF CSC doesn’t match THEN fraud could be happening (medium risk)"
    (CreditCard {cscNotMatching == TRUE})
    =>
    (add (new Risk "medium")))

(defrule addres-zip-provided-avs
    "IF address AND zip is provided THEN AVS, IF AVS doesn’t match 
     	THEN fraud could be happening (medium risk)"
    (CreditCard {adressProvided == TRUE && zipProvided == TRUE && avsNotMatching == TRUE})
    =>
    (add (new Risk "medium")))
    
(defrule csc-avs-doesnt-match
    "IF CSC AND AVS doesn’t match THEN fraud could be happening (high risk)"
    (CreditCard {cscNotMatching == TRUE && avsNotMatching == TRUE})
    =>
    (add (new Risk "high")))
    
(defrule bin-iin-different
    "IF BIN/IIN is different from customer country THEN fraud could be happening (medium risk)"
    (CreditCard {binIinDiffers == TRUE})
    =>
    (add (new Risk "medium")))
    
(defrule using-prepaidcard
    "IF customer is using a gift/prepaid card THEN fraud could be happening (medium risk)"
    (CreditCard {usingGiftCard == TRUE})
    =>
    (add (new Risk "medium")))

(defrule luhm-algorithm-check
    "IF credit card number doesn’t pass the Luhn Algorithm Check 
    	THEN fraud could be happening (high risk)"
    (CreditCard {luhnAlgorithNoPass == TRUE})
    =>
    (add (new Risk "high")))

(defrule lost-stolen-db
    "IF credit card is in a database of lost/stolen cards THEN fraud could be happening (high risk)"
    (CreditCard {lostStolenDB == TRUE})
    =>
    (add (new Risk "high")))

(defrule trusted-bank
    "IF credit card is not from a trusted & well-known bank THEN fraud could be happening (medium risk)"
    (CreditCard {notTrustedBank == TRUE})
    =>
    (add (new Risk "medium")))

(defrule paypal-not-match
    "IF PayPal name does not match customer data THEN fraud could be happening (medium risk)"
    (PayPal {nameNotMatching == TRUE})
    =>
    (add (new Risk "medium")))
    
(defrule paypal-address-data
    "IF PayPal postal address does not match customer data THEN fraud could be happening (medium risk)"
    (PayPal {postalAddresNotMatching == TRUE})
    =>
    (add (new Risk "medium")))

(defrule paypal-not-verified
    "IF PayPal is not verified THEN fraud could be happening (high risk)"
    (PayPal {paypalNotVerified == TRUE})
    =>
    (add (new Risk "high")))

(defrule customer-disputes
    "IF the customer has a history of disputes in PayPal TEHN fraud could be happening (high risk)"
    (PayPal {customerHasDisputes == TRUE})
    =>
    (add (new Risk "high")))

(defrule paypal-scam-db
    "IF PayPal email address is in an online database of scams THEN fraud could be happening (high risk)"
    (PayPal {emailInScamDB == TRUE})
    =>
    (add (new Risk "high")))

(defrule email-not-replied
    "IF email doesn’t get replied THEN fraud could be happening (low risk)"
    (Email {emailNotReplied == TRUE})
    =>
    (add (new Risk "low")))

(defrule email-rejected
    "IF email get rejected THEN fraud could be happening (medium risk)"
    (Email {emailRejected == TRUE})
    =>
    (add (new Risk "medium")))

(defrule extension-shady
    "IF email extension looks shady (not gmail, yahoo, hotmail, outlook) THEN fraud could be happening (low risk)"
    (Email {extensionLooksShady == TRUE})
    =>
    (add (new Risk "low")))
    
(defrule generic-responder
    "IF email has a generic auto-responder enabled THEN fraud could be happening (medium risk)"
    (Email {hasGenericResponse == TRUE})
    =>
    (add (new Risk "medium")))

(defrule email-scam-db
    "IF email is in an online database of scams THEN fraud could be happening (high risk)"
    (Email {inScamDB == TRUE})
    =>
    (add (new Risk "high")))

(defrule ip-billing-address
    "IF IP is from country X AND transaction billing address is from country Y THEN fraud could be happening (medium risk)"
    (IP {billingAddressDifferent == TRUE})
    =>
    (add (new Risk "medium")))

(defrule ip-using-proxy
    "IF customer is using a proxy THEN fraud could be happening (medium risk)"
    (IP {usingProxy == TRUE})
    =>
    (add (new Risk "medium")))

(defrule ip-using-vpn
    "IF customer is using a VPN TEHN fraud could be happening (medium risk)"
    (IP {usingVPN == TRUE})
    =>
    (add (new Risk "medium")))

(defrule ip-fraudulent-trans
    "IF previous fraudulent transactions were made with the same IP before THEN fraud could be happening (high risk)"
    (IP {fraudulentTrx == TRUE})
    =>
    (add (new Risk "high")))

(defrule ip-different-login
    "IF each time the customer logs in has a completely different IP THEN fraud could be happening (medium risk)"
    (IP {differentIPlogin == TRUE})
    =>
    (add (new Risk "medium")))
    
(defrule phone-different-address
    "IF phone number prefix is from city X AND transaction billing address is from city Y THEN fraud could be happening (low risk)"
    (Phone {differentAddress == TRUE})
    =>
    (add (new Risk "low")))

(defrule phone-not-exists
    "IF phone number does not exist THEN fraud could be happening (high risk)"
    (Phone {nonexistentPhone == TRUE})
    =>
    (add (new Risk "high")))
    
(defrule phone-unavailable
    "IF phone is always unavailable THEN fraud could be happening (medium risk)"
    (Phone {alwaysUnavailable == TRUE})
    =>
    (add (new Risk "medium")))

(defrule phone-prepaid
    "IF phone number is a prepaid one THEN fraud could be happening (low risk)"
    (Phone {prepaidPhone == TRUE})
    =>
    (add (new Risk "low")))

(defrule phone-scam-db
    "IF phone number is in an online database of scams THEN fraud could be happening (high risk)"
    (Phone {inScamDB == TRUE})
    =>
    (add (new Risk "high")))  
    
(defrule address-not-real
    "IF address is not real THEN fraud could be happening (high risk)"
    (Address {falseAddress == TRUE})
    =>
    (add (new Risk "high"))) 

(defrule address-residential
    "IF address is not from a residential home THEN fraud could be happening (low risk)"
    (Address {notFromResidentialHome == TRUE})
    =>
    (add (new Risk "low"))) 
    
(defrule address-po-box
    "IF address is a P.O. box THEN fraud could be happening (low risk)"
    (Address {poBox == TRUE})
    =>
    (add (new Risk "low"))) 
    
(defrule address-suspicious-country
    "IF customer is from a suspicious country (Nigeria, Ghana, Cameroon) THEN fraud could be happening (high risk)"
    (Address {fromSuspiciousCountry == TRUE})
    =>
    (add (new Risk "high"))) 
    
(defrule address-scam-db
    "IF address is in an online database of scams THEN fraud could be happening (high risk)"
    (Address {inScamDB == TRUE})
    =>
    (add (new Risk "high"))) 
    
(defrule browser-private
    "IF customer is using private browsing when doing a transaction THEN fraud could be happening (medium risk)"
    (Browser {usingPrivateBrowser == TRUE})
    =>
    (add (new Risk "medium")))     

(defrule browser-javascript-enabled
    "IF customer does not have Javascript enabled when doing a transaction THEN fraud could be happening (medium risk)"
    (Browser {javascriptNotEnabled == TRUE})
    =>
    (add (new Risk "medium")))   
    
(defrule browser-store-cookies
    "IF customer is not able to store cookies when doing a transaction THEN fraud could be happening (medium risk)"
    (Browser {notStoringCookies == TRUE})
    =>
    (add (new Risk "medium")))   

(defrule browser-fast-actions
    "IF customer is performing actions too fast (less than a second) THEN fraud could be happening (high risk)"
    (Browser {performingFastActions == TRUE})
    =>
    (add (new Risk "high")))    

(defrule browser-outdated
    "IF customer is using an outdated browser (User Agent detection) THEN fraud could be happening (medium risk)"
    (Browser {usingOutdatedBrowser == TRUE})
    =>
    (add (new Risk "medium"))) 
