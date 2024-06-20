package com.example.VehicleBackEnd.Controller;

import com.example.VehicleBackEnd.Model.Vehicle;
import com.example.VehicleBackEnd.Repository.DealershipRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DealershipController {
    private DealershipRepository dealershipRepository = new DealershipRepository();
    @GetMapping("/{dealerShipId}")
    public ResponseEntity<List<Vehicle>> getVehicles(@PathVariable int dealerShipID){
        var vehicles = dealershipRepository.GetAll(dealerShipID);
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }


}
