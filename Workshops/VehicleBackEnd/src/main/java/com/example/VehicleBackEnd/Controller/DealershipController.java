package com.example.VehicleBackEnd.Controller;

import com.example.VehicleBackEnd.Model.Vehicle;
import com.example.VehicleBackEnd.Repository.DealershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Dealership")
public class DealershipController {
    @Autowired
    private DealershipRepository dealershipRepository;

    @GetMapping("/{dealerShipId}")
    public ResponseEntity<List<Vehicle>> getVehicles(@PathVariable Integer dealerShipId){
        var vehicles = dealershipRepository.GetAll(dealerShipId);
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }
    @GetMapping("/{dealerShipId}/ByColor/{color}")
    public ResponseEntity<List<Vehicle>> getByColor(@PathVariable  Integer dealerShipId,@PathVariable String color){
        var Vehicles = dealershipRepository.ByColor(color,dealerShipId);
        return new ResponseEntity<>(Vehicles,HttpStatus.OK);
    }
    @GetMapping("/{dealerShipId}/ByType/{type}")
    public ResponseEntity<List<Vehicle>> getByType (@PathVariable int dealerShipId,@PathVariable String type){
        var vehicles = dealershipRepository.ByType(type,dealerShipId);
        return new ResponseEntity<>(vehicles,HttpStatus.OK);
    }
    @GetMapping("/{dealerShipId}/PriceBetween")
    public ResponseEntity<List<Vehicle>> getByPrice(@RequestParam(defaultValue = "0") double min, @RequestParam(defaultValue = "200000") double max, @PathVariable int dealerShipId){
        var vehicles = dealershipRepository.ByPriceRange(min,max,dealerShipId);
        return new ResponseEntity<>(vehicles,HttpStatus.OK);
    }
    @GetMapping("/{dealerShipId}/YearBetween")
    public ResponseEntity<List<Vehicle>> getByYear(@RequestParam(defaultValue = "0") int min,@RequestParam(defaultValue = "0") int max,@PathVariable int dealerShipId){
        var vehicles = dealershipRepository.ByYear(min,max,dealerShipId);
        return new ResponseEntity<>(vehicles,HttpStatus.OK);
    }
    @GetMapping("/{dealerShipId}/MileageBetween")
    public ResponseEntity<List<Vehicle>> getByMilage(@RequestParam(defaultValue = "0") int min,@RequestParam(defaultValue = "0") int max,@PathVariable int dealerShipId){
        var vehicles = dealershipRepository.ByYear(min,max,dealerShipId);
        return new ResponseEntity<>(vehicles,HttpStatus.OK);
    }
    @GetMapping("/{dealerShipId}/VehilceMake")
    public ResponseEntity<List<Vehicle>> getByMakeModel(@RequestParam(defaultValue = "") String make,@RequestParam(defaultValue = "") String model,@PathVariable int dealerShipId){
        var vehicles = dealershipRepository.ByMakeModel(make, model, dealerShipId);
        return new ResponseEntity<>(vehicles,HttpStatus.OK);
    }
    @PostMapping("add/{dealerShipId}")
    public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle,@PathVariable int dealerShipId){
        dealershipRepository.addVehicle(vehicle,dealerShipId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/Delete")
    public ResponseEntity<Void> deletedVehicle(@RequestBody Vehicle vehicle){
        dealershipRepository.removeVehicle(vehicle);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //Should work But would require whole vehicle info
    @PutMapping("update/{dealerShipId}")
    public ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle vehicle,@PathVariable int dealerShipId){
        Vehicle vehicleToUpdate = dealershipRepository.ById(vehicle.getVin());
        vehicleToUpdate.setVehicleType(vehicle.getVehicleType());
        vehicleToUpdate.setMake(vehicle.getMake());
        vehicleToUpdate.setColor(vehicle.getColor());
        vehicleToUpdate.setModel(vehicle.getModel());
        vehicleToUpdate.setOdometer(vehicle.getOdometer());
        vehicleToUpdate.setVin(vehicle.getVin());
        vehicleToUpdate.setPrice(vehicle.getPrice());
        vehicleToUpdate.setYear(vehicle.getYear());
        dealershipRepository.addVehicle(vehicleToUpdate,dealerShipId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
