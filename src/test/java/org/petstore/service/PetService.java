package org.petstore.service;

import org.petstore.bean.Pet;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PetService {

    public long addPet(Pet pet) {
        return given().log().all()
                .baseUri(Constant.BASE_URL)
                .basePath(Constant.VERSION + Constant.PET_RESOURCE)
                .contentType(Constant.CONTENT_TYPE)
                .when()
                .body(pet)
                .post()
                .then()
                .statusCode(200)
                .extract().as(Pet.class).getId();
    }

    public void updatePet(Pet pet) {
         given().log().all()
                .baseUri(Constant.BASE_URL)
                .basePath(Constant.VERSION + Constant.PET_RESOURCE)
                .contentType(Constant.CONTENT_TYPE)
                .when()
                .body(pet)
                .put()
                .then()
                .statusCode(200)
                .extract().as(Pet.class).getId();
    }

    public void getPet(Pet pet) {
         given().log().all()
                .baseUri(Constant.BASE_URL)
                .basePath(Constant.VERSION + Constant.PET_RESOURCE+"/"+pet.getId())
                .contentType(Constant.CONTENT_TYPE)
                .when()
                .get()
                .then()
                .statusCode(200)
                .assertThat().body("name",equalTo(pet.getName()));
    }

    public void deletePet(Pet pet) {
        given().log().all()
                .baseUri(Constant.BASE_URL)
                .basePath(Constant.VERSION + Constant.PET_RESOURCE+"/"+pet.getId())
                .contentType(Constant.CONTENT_TYPE)
                .when()
                .delete()
                .then()
                .statusCode(200);
    }

}
