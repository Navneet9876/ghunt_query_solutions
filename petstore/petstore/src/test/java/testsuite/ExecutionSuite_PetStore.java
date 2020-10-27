package testsuite;

import assertions.CustomAssert;
import base.BaseTestClass;
import global.Utils;
import http.HTTPStatusCode;
import http.Response;
import model.PetRecord;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import service.PetStoreService;

public class ExecutionSuite_PetStore extends BaseTestClass {
    PetStoreService petStoreService = null;
    long petID = Utils.getRandomNo();
    String tagName = "German";
    String categoryName = "Dog";
    String photoURLs = "https://upload.wikimedia.org/wikipedia/commons/d/d0/German_Shepherd_-_DSC_0346_%2810096362833%29.jpg";
    String petName = "German Shepherd";

    @BeforeClass
    public void beforeClass() {
        petStoreService = new PetStoreService();
    }

    @Test
    public void TC_001_ValidateFunctionality_GetAllAvailablePets() throws Exception {
        String status = "available";
        for (PetRecord petRecord : petStoreService.getAllPets(status)) {
            CustomAssert.assertEquals(petRecord.getStatus(), status, "Compare Status for PetName = " + petRecord.getName());
        }
    }

    @Test
    public void TC_002_ValidateFunctionality_AddNewAvailablePet() throws Exception {
        String status = "available";
        Response response = petStoreService.addNewPet(petID, petName, tagName, categoryName, photoURLs, status);
        CustomAssert.assertEquals(response.getStatusCode(), HTTPStatusCode.OK_200, "Validate Response Code");
        boolean flag = false;
        for (PetRecord record : petStoreService.getAllPets(status)) {
            if (record.getName().equalsIgnoreCase(petName)) {
                flag = true;
                break;
            }
        }
        CustomAssert.assertTrue(flag, "Validate New Record Added");
    }

    @Test
    public void TC_003_ValidateFunctionality_UpdatePetStatusToSold() throws Exception {
        String status = "sold";
        Response response = petStoreService.updatePetStatus(petID, petName, tagName, categoryName, photoURLs, status);
        CustomAssert.assertEquals(response.getStatusCode(), HTTPStatusCode.OK_200, "Validate Response Code");
        boolean flag = false;
        for (PetRecord record : petStoreService.getAllPets(status)) {
            if (record.getName().equals(petName)) {
                flag = true;
                CustomAssert.assertEquals(record.getStatus(), status, "Validate updated Status of Pet");
            }
        }
    }

    @Test
    public void TC_004_ValidateFunctionality_DeletePet() throws Exception {
        String status = "sold";
        Response response = petStoreService.deletePet(petID);
        CustomAssert.assertEquals(response.getStatusCode(), HTTPStatusCode.OK_200, "Validate Response Code");
        boolean flag = true;
        for (PetRecord record : petStoreService.getAllPets(status)) {
            if (record.getId() == petID) {
                flag = false;
            }
        }
        CustomAssert.assertTrue(flag, "Check Pet Deleted with ID " + petID);
    }


}
