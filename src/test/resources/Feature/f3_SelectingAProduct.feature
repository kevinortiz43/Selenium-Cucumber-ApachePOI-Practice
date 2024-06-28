@TestCase3
Feature: Filtering by specific items

   Scenario Outline: User will search for an item by providing specific keywords
    Given User will navigate to the eBay website
    When User will navigate to the advanced search and provide specific search criteria
      And User provides the keyword '<keyword>'
      And User selects keyword options '<keywordOptions>'
      And User provides keyword exclusions '<keywordExclusions>'
      And User selects category '<category>'
      And User selects buying formats '<buyingFormats>'
      And User selects condition '<condition>'
      And User selects show results '<showResults>'
      And User selects shipping options '<shippingOptions>'
      And User selects location '<location>'
      And User selects sort by '<sortBy>'
      And User selects view results '<viewResults>'
      And User selects results per page '<resultsPerPage>'
      Then User will verify the '<keyword>' displayed is the one wanted

    Examples:
		|keyword|keywordOptions|keywordExclusions|category|buyingFormats|condition|showResults|shippingOptions|location|sortBy|viewResults|resultsPerPage|
		|Apple iPhone 15 128GB|Exact words, any order|pro|Cell Phones & Accessories|LH_BIN|s0-1-17-6[4]-[1]-LH_ItemCondition|LH_FR|LH_FS|s0-1-17-6[7]-[2]-LH_PrefLoc|Price + Shipping: lowest first|List view|240|
	
		#Buying format:
		#Accepts offers ="LH_BO"
		#Auction = "LH_Auction"
		#Buy it now = "LH_BIN"
		#Classified ads = "LH_CAds"
		
		#Condition:
		# new = s0-1-17-6[4]-[0]-LH_ItemCondition
		#Used = s0-1-17-6[4]-[1]-LH_ItemCondition
		#N/A  = s0-1-17-6[4]-[2]-LH_ItemCondition
		
		#Show results
		#Free returns = LH_FR
		#Returns accepted = LH_RPA
		#Authorized Seller = LH_AS
		#Deals and Savings = LH_Savings
		# Sale Items = LH_SaleItems
		#Listed as lots = LH_Lots
		
		#Shipping options
		# Free shipping = LH_FP
		# Local picking = LH_LP
		
		#Item Location
		#Default s0-1-17-6[7]-[0]-LH_PrefLoc
		#USA s0-1-17-6[7]-[2]-LH_PrefLoc
		# NA s0-1-17-6[7]-[3]-LH_PrefLoc