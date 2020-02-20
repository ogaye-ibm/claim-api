package com.example.cp41.cp4icapstone;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/")
@Api(tags = {"Claim"})
public class ClaimController {


   @Autowired  ClaimRepo claimRepo;

    @ApiOperation(value = "Read all Claims", notes = "Return all Claims in DB", httpMethod = "GET", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Claims retrieved successfully", response = ResponseEntity.class),
            @ApiResponse(code = 400, message = "An exception occurred while retrieving Claims", response = ResponseEntity.class),
            @ApiResponse(code = 500, message = "An internal server error occurred while retrieving Claims")})
    @GetMapping(path = "/claims", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Claim>> getClaims(){
        Iterable<Claim> claims  = claimRepo.findAll();

        List<Claim> result = new ArrayList<>();
        for (Claim claim : claims) {
            result.add(claim);
        }

        System.out.println("**************************** count: "+ claimRepo.count());
        return ResponseEntity.status(HttpStatus.CREATED).body(result);

    }

    @ApiOperation(value = "Read a Claim", notes = "Retrieve a Claims by ID", httpMethod = "GET", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Claim retrieved successfully", response = ResponseEntity.class),
            @ApiResponse(code = 400, message = "An exception occurred while retrieving Claim", response = ResponseEntity.class),
            @ApiResponse(code = 500, message = "An internal server error occurred while retrieving Claim")})
    @GetMapping(value = "/claim/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Claim> getClaim(@PathVariable Long id){

        return ResponseEntity.status(HttpStatus.OK).body(claimRepo.findById(id).orElse(null));
    }

    @ApiOperation(value = "Create a Claim", notes = "Create a new Claims in DB", httpMethod = "POST", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Claims created successfully", response = ResponseEntity.class),
            @ApiResponse(code = 400, message = "An exception occurred while creating a Claims", response = ResponseEntity.class),
            @ApiResponse(code = 500, message = "An internal server error occurred while creating a Claim")})
    @PostMapping (path = "/claim", produces = MediaType.APPLICATION_JSON_VALUE)
    public void createClaim(@RequestBody Claim claimDetail){
        try {
            claimRepo.save(claimDetail);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
