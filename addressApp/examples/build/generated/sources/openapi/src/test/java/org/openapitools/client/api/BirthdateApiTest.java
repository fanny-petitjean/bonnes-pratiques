/*
 * Mines - address app
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.api;

import org.openapitools.client.ApiException;
import org.openapitools.client.model.Birthdate;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * API tests for BirthdateApi
 */
@Ignore
public class BirthdateApiTest {

    private final BirthdateApi api = new BirthdateApi();

    
    /**
     * Info for a specific birthdate
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getBirthdateTest() throws ApiException {
        String id = null;
        Birthdate response = 
        api.getBirthdate(id);
        
        // TODO: test validations
    }
    
    /**
     * List all birthdates
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void listBirthdatesTest() throws ApiException {
        List<Birthdate> response = 
        api.listBirthdates();
        
        // TODO: test validations
    }
    
}
