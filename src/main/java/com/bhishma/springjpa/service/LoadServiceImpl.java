package com.bhishma.springjpa.service;

import com.bhishma.springjpa.entity.Payload;
import com.bhishma.springjpa.repostory.LoadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LoadServiceImpl implements LoadService {

    @Autowired
    LoadRepo loadRepo;

    @Override
    public ResponseEntity<String> createLoad(Payload payload) {

        try {

            loadRepo.save(payload);

            return new ResponseEntity<>("Load details added successfully", HttpStatus.CREATED);

        }
        catch (Exception e) {

            e.printStackTrace();

            return new ResponseEntity<>("Failed to add load", HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @Override
    public ResponseEntity<List<Payload>> getAllLoadsByShipperId(int shipperId) {

        try {

            List<Payload> payloads = loadRepo.findByShipperId(shipperId);

            return new ResponseEntity<>(payloads, HttpStatus.OK);

        }
        catch (Exception e) {

            e.printStackTrace();

            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @Override
    public ResponseEntity<Payload> getLoadById(int loadId) {

        try {
            Payload payload = loadRepo.findByLoadId(loadId);

            if (payload != null) {
                return new ResponseEntity<>(payload, HttpStatus.OK);
            }

            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        }

        catch (Exception e) {

            e.printStackTrace();

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ResponseEntity<String> updateLoadDetails(int loadId, Payload payload) {

        try {

            Payload existingPayload = loadRepo.findByLoadId(loadId);

            if (existingPayload != null) {


                existingPayload.setLoadingPoint(payload.getLoadingPoint());
                existingPayload.setUnloadingPoint(payload.getUnloadingPoint());
                existingPayload.setProductType(payload.getProductType());
                existingPayload.setTruckType(payload.getTruckType());
                existingPayload.setNoOfTrucks(payload.getNoOfTrucks());
                existingPayload.setWeight(payload.getWeight());
                existingPayload.setDate(payload.getDate());
                loadRepo.save(existingPayload);


                return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
            }

            else {

                return new ResponseEntity<>("Load not found with ID: " + loadId, HttpStatus.NOT_FOUND);

            }
        }

        catch (Exception e) {

            e.printStackTrace();
            return new ResponseEntity<>("Failed to update load", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<String> deleteLoad(int loadId) {
        try {
            Optional<Payload> payload = Optional.ofNullable(loadRepo.findByLoadId(loadId));

            if (payload.isPresent()) {

                loadRepo.delete(payload.get());

                return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);

            }

            else {
                return new ResponseEntity<>("Load with id " + loadId + " not found", HttpStatus.NOT_FOUND);
            }

        }
        catch (Exception e) {

            e.printStackTrace();

            return new ResponseEntity<>("Failed to delete load", HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }
}
