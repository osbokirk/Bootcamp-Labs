package com.example.VehicleBackEnd.Controller;

import com.example.VehicleBackEnd.Model.Vehicle;
import com.example.VehicleBackEnd.Repository.ContractRepository;
import com.example.VehicleBackEnd.Repository.DealershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContractController {
    @Autowired
    private ContractRepository contractRepository= new ContractRepository();

}
