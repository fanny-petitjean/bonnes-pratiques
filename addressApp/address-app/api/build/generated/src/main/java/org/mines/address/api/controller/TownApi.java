/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.3.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.mines.address.api.controller;

import org.mines.address.api.model.Address;
import org.mines.address.api.model.Town;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-16T16:41:38.192651400+02:00[Europe/Paris]")
@Validated
@Tag(name = "address", description = "the address API")
public interface TownApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /town/{id}/address : Creates an address
     *
     * @param id The town id (required)
     * @param address  (required)
     * @return Expected response to a valid request (status code 200)
     */
    @Operation(
        operationId = "createAddresses",
        summary = "Creates an address",
        tags = { "address" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Expected response to a valid request", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Address.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/town/{id}/address",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Address> createAddresses(
        @Parameter(name = "id", description = "The town id", required = true, in = ParameterIn.PATH) @PathVariable("id") String id,
        @Parameter(name = "Address", description = "", required = true) @Valid @RequestBody Address address
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"number\" : 0, \"street\" : \"street\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /town : Create a town
     *
     * @param town  (required)
     * @return Null response (status code 201)
     */
    @Operation(
        operationId = "createTown",
        summary = "Create a town",
        tags = { "town" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Null response", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Town.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/town",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Town> createTown(
        @Parameter(name = "Town", description = "", required = true) @Valid @RequestBody Town town
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"name\", \"postCode\" : \"postCode\", \"id\" : \"id\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /town/{id} : Delete a town.
     *
     * @param id  (required)
     * @return Town has been deleted. (status code 204)
     */
    @Operation(
        operationId = "deleteTown",
        summary = "Delete a town.",
        tags = { "town" },
        responses = {
            @ApiResponse(responseCode = "204", description = "Town has been deleted.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/town/{id}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<String> deleteTown(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") String id
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /town/{id} : Info for a specific town
     *
     * @param id The id of the town to retrieve (required)
     * @return Expected response to a valid request (status code 200)
     */
    @Operation(
        operationId = "getTown",
        summary = "Info for a specific town",
        tags = { "town" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Expected response to a valid request", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Town.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/town/{id}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<Town> getTown(
        @Parameter(name = "id", description = "The id of the town to retrieve", required = true, in = ParameterIn.PATH) @PathVariable("id") String id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"name\", \"postCode\" : \"postCode\", \"id\" : \"id\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /town/{id}/address : Retrieves all addresses for a given town
     *
     * @param id The town id (required)
     * @return Expected response to a valid request (status code 200)
     */
    @Operation(
        operationId = "listAddresses",
        summary = "Retrieves all addresses for a given town",
        tags = { "address" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Expected response to a valid request", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Address.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/town/{id}/address",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<Address>> listAddresses(
        @Parameter(name = "id", description = "The town id", required = true, in = ParameterIn.PATH) @PathVariable("id") String id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"number\" : 0, \"street\" : \"street\" }, { \"number\" : 0, \"street\" : \"street\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /town : List all towns
     *
     * @return An array of towns (status code 200)
     */
    @Operation(
        operationId = "listTowns",
        summary = "List all towns",
        tags = { "town" },
        responses = {
            @ApiResponse(responseCode = "200", description = "An array of towns", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Town.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/town",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<Town>> listTowns(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"name\" : \"name\", \"postCode\" : \"postCode\", \"id\" : \"id\" }, { \"name\" : \"name\", \"postCode\" : \"postCode\", \"id\" : \"id\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /town : Update a town
     *
     * @param town  (required)
     * @return Null response (status code 200)
     */
    @Operation(
        operationId = "updateTown",
        summary = "Update a town",
        tags = { "town" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Null response", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Town.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/town",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Town> updateTown(
        @Parameter(name = "Town", description = "", required = true) @Valid @RequestBody Town town
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"name\", \"postCode\" : \"postCode\", \"id\" : \"id\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
