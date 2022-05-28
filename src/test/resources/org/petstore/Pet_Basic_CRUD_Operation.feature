Feature: Basic Pet resource validation

  Scenario: Create flow validation
    Given Below list of pets
      | name | status    | photoUrls                                                                                                                   |
      | Joye | available | https://static8.depositphotos.com/1057741/1041/i/950/depositphotos_10415184-stock-photo-golden-retriever-dog-sitting-on.jpg |
    When I should able to add the pets to the store
    Then I should able to find the pets in the store
    Then I should able to remove the pet from the store