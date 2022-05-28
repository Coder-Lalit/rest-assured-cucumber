package org.petstore.steps;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.petstore.bean.Pet;
import org.petstore.service.PetService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class PetStepDefinitions {

    @DataTableType
    public Pet petDefinitions(Map<String,String> entry){
        return Pet.builder()
                .name(entry.get("name"))
                .photoUrls(Arrays.asList(entry.get("photoUrls").split(",")))
                .status(entry.get("status"))
                .build();
    }

    private List<Pet> petList;
    private PetService petService = new PetService();

    @Given("Below list of pets")
    public void below_list_of_pets(List<Pet> petList) {
       this.petList = petList;
    }

    @When("I should able to add the pets to the store")
    public void i_should_able_to_add_the_pets_to_the_store() {
        petList.forEach(pet -> pet.setId(petService.addPet(pet)));
    }

    @Then("I should able to find the pets in the store")
    public void i_should_able_to_find_the_pets_in_the_store() {
        petList.forEach(pet -> petService.getPet(pet));
    }

    @Then("I should able to remove the pet from the store")
    public void i_should_able_to_remove_the_pet_from_the_store() {
        petList.forEach(pet -> petService.deletePet(pet));
    }

}
