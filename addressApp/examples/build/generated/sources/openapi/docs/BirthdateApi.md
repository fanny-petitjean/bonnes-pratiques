# BirthdateApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getBirthdate**](BirthdateApi.md#getBirthdate) | **GET** /birthdate/{id} | Info for a specific birthdate |
| [**getBirthdateWithHttpInfo**](BirthdateApi.md#getBirthdateWithHttpInfo) | **GET** /birthdate/{id} | Info for a specific birthdate |
| [**listBirthdates**](BirthdateApi.md#listBirthdates) | **GET** /birthdate | List all birthdates |
| [**listBirthdatesWithHttpInfo**](BirthdateApi.md#listBirthdatesWithHttpInfo) | **GET** /birthdate | List all birthdates |



## getBirthdate

> Birthdate getBirthdate(id)

Info for a specific birthdate

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BirthdateApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        BirthdateApi apiInstance = new BirthdateApi(defaultClient);
        String id = "id_example"; // String | The id of the birthdate to retrieve
        try {
            Birthdate result = apiInstance.getBirthdate(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling BirthdateApi#getBirthdate");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**| The id of the birthdate to retrieve | |

### Return type

[**Birthdate**](Birthdate.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Expected response to a valid request |  -  |

## getBirthdateWithHttpInfo

> ApiResponse<Birthdate> getBirthdate getBirthdateWithHttpInfo(id)

Info for a specific birthdate

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BirthdateApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        BirthdateApi apiInstance = new BirthdateApi(defaultClient);
        String id = "id_example"; // String | The id of the birthdate to retrieve
        try {
            ApiResponse<Birthdate> response = apiInstance.getBirthdateWithHttpInfo(id);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling BirthdateApi#getBirthdate");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Response headers: " + e.getResponseHeaders());
            System.err.println("Reason: " + e.getResponseBody());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**| The id of the birthdate to retrieve | |

### Return type

ApiResponse<[**Birthdate**](Birthdate.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Expected response to a valid request |  -  |


## listBirthdates

> List<Birthdate> listBirthdates()

List all birthdates

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BirthdateApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        BirthdateApi apiInstance = new BirthdateApi(defaultClient);
        try {
            List<Birthdate> result = apiInstance.listBirthdates();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling BirthdateApi#listBirthdates");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**List&lt;Birthdate&gt;**](Birthdate.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | An array of birthdates |  -  |

## listBirthdatesWithHttpInfo

> ApiResponse<List<Birthdate>> listBirthdates listBirthdatesWithHttpInfo()

List all birthdates

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BirthdateApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        BirthdateApi apiInstance = new BirthdateApi(defaultClient);
        try {
            ApiResponse<List<Birthdate>> response = apiInstance.listBirthdatesWithHttpInfo();
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling BirthdateApi#listBirthdates");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Response headers: " + e.getResponseHeaders());
            System.err.println("Reason: " + e.getResponseBody());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

ApiResponse<[**List&lt;Birthdate&gt;**](Birthdate.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | An array of birthdates |  -  |

