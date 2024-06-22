package com.example.VehicleBackEnd.Controller;

import com.example.VehicleBackEnd.Model.*;
import com.example.VehicleBackEnd.Repository.ContractRepository;
import com.example.VehicleBackEnd.Repository.DealershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.rmi.dgc.Lease;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ContractController {
    @Autowired
    private ContractRepository contractRepository;

    @GetMapping("/Sales/{contractId}")
    public ResponseEntity<SalesContract> getSalesContract(@PathVariable int contractId){
        var contract = contractRepository.getSalesContractById(contractId);
        return new ResponseEntity<>(contract,HttpStatus.OK);
    }
    @PostMapping("/Sales")
    public ResponseEntity<SalesContract> addSalesContract(@RequestBody SalesContractDTO contract){
        contractRepository.addSalesContract(contract);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/Leases/{contractId}")
    public ResponseEntity<LeaseContractDTO> getLeaseContract(@PathVariable int contractId){
        var contract = contractRepository.getLeaseContractById(contractId);
        return new ResponseEntity<>(contract,HttpStatus.OK);
    }
    @PostMapping("/Leases")
    public ResponseEntity<LeaseContract> addLeaseContract(@RequestBody LeaseContractDTO contract){
        contractRepository.addLeaseContract(contract);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
