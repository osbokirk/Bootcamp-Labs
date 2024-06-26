package com.example.VehicleBackEnd.Repository;


import com.example.VehicleBackEnd.Model.*;
//import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ContractRepository {
    @Autowired
    private DataSource basicDataSource;

    /*public ContractRepository(String url, String userName, String password){
        basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(userName);
        basicDataSource.setPassword(password);
    }

     */
    public void addLeaseContract(LeaseContractDTO contract){
        String query = "{Call AddLeaseContract(?,?,?,?,?)}";
        try (Connection con = basicDataSource.getConnection(); CallableStatement callableStatement = con.prepareCall(query)){
            callableStatement.setString(1,contract.Vin);
            callableStatement.setFloat(2,(float) contract.endingValue);
            callableStatement.setFloat(3,(float) contract.leaseFeeCharge);
            callableStatement.setFloat(4,(float) contract.monthlyPayment);
            callableStatement.setFloat(5,(float) contract.totalPrice);
            callableStatement.executeQuery();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public LeaseContractDTO getLeaseContractById(int contractId){
        String query = "{Call GetLeaseContractById(?)}";
        List<LeaseContractDTO>  contract = new ArrayList<>();
        try(Connection connection = basicDataSource.getConnection();CallableStatement call = connection.prepareCall(query)){
            call.setInt(1,contractId);
            ResultSet resultSet =  call.executeQuery();
            while(resultSet.next()){
                String date = resultSet.getString("ContractDate");
                String customerName = resultSet.getString("CustomerName");
                String email = resultSet.getString("Email");
                String vin  = resultSet.getString("Vin");

                double totalPrice = resultSet.getDouble("TotalPrice");
                double monthlyPayment = resultSet.getDouble("MonthlyPayment");
                double endingValue = resultSet.getDouble("EndingingValue");
                double leaseFeeCharge = resultSet.getDouble("LeaseFeeCharge");
                double intrestRate = resultSet.getDouble("InterestRate");

                LeaseContractDTO contractDTO = new LeaseContractDTO(date,customerName,email,totalPrice,monthlyPayment,endingValue,leaseFeeCharge,intrestRate,vin);
                contract.add(contractDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contract.get(0);
    }

    public void addSalesContract(SalesContractDTO contract){
        String query = "{Call AddSalesContract(?,?,?,?,?,?,?,?)}";
        try (Connection con = basicDataSource.getConnection();CallableStatement call = con.prepareCall(query)){
            call.setString(1,contract.getVin());
            call.setFloat(2,(float) contract.getSalesTaxAmmount());
            call.setBoolean(3,contract.isFinanced());
            call.setInt(4, contract.getTermLenght());
            call.setFloat(5,(float) contract.getIntrestRate());
            call.setFloat(6,(float) contract.getProcessingFee());
            call.setFloat(7,(float)contract.getTotalPrice());
            call.setFloat(8,(float)contract.getMonthlyPayment());
            call.executeQuery();
        }catch (SQLException ex ){
            ex.printStackTrace();
        }
    }

    public SalesContractDTO getSalesContractById(int SaleContactId){
        String query = "{Call GetSalesContractById(?)}";
        List<SalesContractDTO> contracts = new ArrayList<>();
        try(Connection connection = basicDataSource.getConnection();CallableStatement call = connection.prepareCall(query)){
            call.setInt(1,SaleContactId);
            ResultSet resultSet =  call.executeQuery();
            while(resultSet.next()){
                String date = resultSet.getString("ContractDate");
                String customerName = resultSet.getString("CustomerName");
                String email = resultSet.getString("Email");
                String vin  = resultSet.getString("Vin");
                int termLength = resultSet.getInt("TermLenght");
                double totalPrice = resultSet.getDouble("TotalPrice");
                double monthlyPayment = resultSet.getDouble("MonthlyPayment");
                //double endingValue = resultSet.getDouble("EndingingValue");
                //double leaseFeeCharge = resultSet.getDouble("LeaseFeeCharge");
                double intrestRate = resultSet.getDouble("InterestRate");
                double salesTaxAmmount = resultSet.getDouble("salesTaxAmmount");
                double processingFee = resultSet.getDouble("ProcessingFee");
                boolean isFinanced = resultSet.getBoolean("isFinanced");

                SalesContractDTO contractDTO = new SalesContractDTO(date,customerName,email,vin,termLength,salesTaxAmmount,processingFee,intrestRate,monthlyPayment,totalPrice,isFinanced);
                contracts.add(contractDTO);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return contracts.get(0);
    }
}
