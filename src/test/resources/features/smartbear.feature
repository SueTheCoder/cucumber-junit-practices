
  Feature: SmartBear order process
    @smartBear
    Scenario: Verifying and Adding new order
      Given User is logged into SmartBear Tester account
      And User clicks "Order" menu
      # User fills out the form as followed:
      And User selects "FamilyAlbum" from product dropdown
      And User enters "4" to quantity
      And User enters "John Wick" to costumer name
      And User enters "Kinzie Ave" to street
      And User enters "Chicago" to city
      And User enters "IL" to state
      And User enters "60056"
      And User selects "Visa" as card type
      And User enters "1111222233334444" to card number
      And User enters "12/22" to expiration date
      And User clicks process button
      And User clicks "View all orders" menu
      Then User verifies "John Wick" is in the list

    @smartBear_1
    Scenario Outline: Verifying and Adding new order
      Given User is logged into SmartBear Tester account
      And User clicks "Order" menu
      # User fills out the form as followed:
      And User selects "<product>" from product dropdown
      And User enters "<quantity>" to quantity
      And User enters "<customer name>" to costumer name
      And User enters "<street>" to street
      And User enters "<city>" to city
      And User enters "<state>" to state
      And User enters "<zip>"
      And User selects "<card type>" as card type
      And User enters "<card number>" to card number
      And User enters "<expiration date>" to expiration date
      And User clicks process button
      And User clicks "View all orders" menu
      Then User verifies "<customer name>" is in the list
      Examples:
        | product     | quantity | customer name   | street      | city        | state | zip   | card Type | card number  | expiration date | customer name   |
        | MyMoney     | 1        | Ken Adams       | Kinzie St   | Chicago     | IL    | 60004 | Visa     | 333212315225 | 12/22           | Ken Adams       |
        | FamilyAlbum | 4        | Joey Trbbiani   | State St    | Chicago     | IL    | 60656 | Visa     | 335252145235 | 11/22           | Joey Trbbiani   |
        | ScreenSaver | 5        | Rachel Green    | Michigan St | Chicago     | IL    | 60056 | Visa     | 521452145248 | 10/22           | Rachel Green    |
        | MyMoney     | 5        | Chandler Bing   | Erie St     | Chicago     | IL    | 60666 | Visa     | 854785125832 | 10/22           | Chandler Bing   |
        | FamilyAlbum | 9        | Dr DrakeRamoray | Dale St     | Arl Hgths   | IL    | 60452 | Visa     | 333849521452 | 10/22           | Dr DrakeRamoray |
        | ScreenSaver | 10       | Monica Geller   | Euclid St   | Arl Hgths   | IL    | 60312 | Visa     | 335248521452 | 10/22           | Monica Geller   |
        | MyMoney     | 3        | Ross Geller     | River St    | Des Plaines | IL    | 60666 | Visa     | 335890210000 | 12/22           | Ross Geller     |
        | MyMoney     | 1        | Ken Adams       | Kinzie St   | Chicago     | IL    | 60312 | Visa     | 358215822324 | 10/22           | Ken Adams       |