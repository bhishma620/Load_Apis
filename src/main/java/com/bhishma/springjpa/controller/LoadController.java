package com.bhishma.springjpa.controller;

import com.bhishma.springjpa.entity.Payload;
import com.bhishma.springjpa.service.LoadService;
import com.bhishma.springjpa.service.LoadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/load")

public class LoadController {

    @Autowired
    LoadService loadService;

    //creating the load
    @PostMapping("")
    ResponseEntity<String> createLoad(@RequestBody Payload payload){


        return loadService.createLoad(payload);

    }

    //get all payload by shipperid as in request param
    @GetMapping()

    ResponseEntity<List<Payload>> getAllLoadsByShipperId(@RequestParam("shipperId") int shipperId){
        return loadService.getAllLoadsByShipperId(shipperId);
    }


    //get payload by loadid

    @GetMapping("/{loadId}")
    ResponseEntity<Payload> getLoadByLoadId(@PathVariable int loadId){

        return loadService.getLoadById(loadId);

    }



    //update payload

    @PutMapping("/{loadId}")
    ResponseEntity<String> updateLoadDetails(@PathVariable int loadId,@RequestBody  Payload payload){

        return loadService.updateLoadDetails(loadId,payload);

    }

    //delete a payload

    @DeleteMapping("{loadId}")
    ResponseEntity<String> deleteLoadDetails(@PathVariable int loadId){

        return loadService.deleteLoad(loadId);

    }

}
