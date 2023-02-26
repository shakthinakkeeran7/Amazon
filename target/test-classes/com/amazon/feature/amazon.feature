Feature: Testing e-commerce Website


Scenario: dropdown Value compare

When get Dropdown List
And comapare give value "Music" in the list

Scenario: serach Bar Value compare

Given give value "cd" to the search bar 
And comapare  in the search list and click

Scenario: get First Product Title and Select

When get Product Title in search result
Then  click Product Title

Scenario: get Second page Product Title

When  move to new product page
And get Product Title in New Page
And Compare the Both Title
Then if the title is simler value click add to cart
And take screenshot in the Added to Cart page
Scenario: goto Cart

When  click go to cart button

Scenario: get Goto Cart Page Product Title

And  compare With Previous Title
And  get Screenshoton On The  Add To Cart Page
Then click Proceed To Buy button
And close The Current Window