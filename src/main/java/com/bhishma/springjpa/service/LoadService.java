package com.bhishma.springjpa.service;

import com.bhishma.springjpa.entity.Payload;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LoadService {


    public ResponseEntity<String> createLoad(Payload payload);

    public ResponseEntity<List<Payload>>getAllLoadsByShipperId(int shipperId);

    public ResponseEntity<Payload> getLoadById(int loadId);

    public ResponseEntity<String> updateLoadDetails(int loadId,Payload payload);

    public ResponseEntity<String> deleteLoad(int loadId);


}
