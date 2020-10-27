package service;

import assertions.CustomAssert;
import configuration.GsonConfiguration;
import constants.Constants;
import core.ApiFunctions;
import exception.APIResponseException;
import http.HTTPMethodType;
import http.HTTPStatusCode;
import http.Request;
import http.Response;
import model.Category;
import model.PetRecord;
import model.Tag;

import java.util.*;

public class PetStoreService {

    public List<PetRecord> getAllPets(String status) throws APIResponseException {
        Response response = ApiFunctions.getInstance().doGet(Constants.URLConstants.GET_PETS + "?status=" + status);
        CustomAssert.assertEquals(response.getStatusCode(), HTTPStatusCode.OK_200, "Validate Response Code");
        PetRecord[] list = GsonConfiguration.get().fromJson(response.getResponseBody(), PetRecord[].class);
        return Arrays.asList(list);
    }

    public Response addNewPet(long petID, String petName, String tagName, String categoryName, String photoURL, String status) throws APIResponseException {
        List<String> photoList = Arrays.asList(photoURL.split(","));
        List<Tag> tagList = new ArrayList<>();
        tagList.add(new Tag(1, tagName));
        PetRecord petRecord = new PetRecord(petID, new Category(1, categoryName), petName, photoList, tagList, status);
        Request request = new Request(Constants.URLConstants.ADD_UPDATE_DELETE_PET, HTTPMethodType.POST,
                GsonConfiguration.get().toJson(petRecord), getCommonHeaders());
        return ApiFunctions.getInstance().doPost(request);
    }

    public Response updatePetStatus(long petID, String petName, String tagName, String categoryName, String photoURL, String status) throws APIResponseException {
        List<String> photoList = Arrays.asList(photoURL.split(","));
        List<Tag> tagList = new ArrayList<>();
        tagList.add(new Tag(1, tagName));
        PetRecord addNewPetRequestDTO = new PetRecord(petID, new Category(1, categoryName), petName, photoList, tagList, status);
        Request request = new Request(Constants.URLConstants.ADD_UPDATE_DELETE_PET, HTTPMethodType.PUT,
                GsonConfiguration.get().toJson(addNewPetRequestDTO), getCommonHeaders());
        return ApiFunctions.getInstance().doPost(request);
    }

    public Response deletePet(long petID) throws APIResponseException {
        Request request = new Request(Constants.URLConstants.ADD_UPDATE_DELETE_PET + "/" + petID, HTTPMethodType.DELETE);
        return ApiFunctions.getInstance().doDelete(request);
    }

    private Map<String, String> getCommonHeaders() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("Content-Type", "application/json");
        return headers;
    }
}
