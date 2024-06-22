package com.example.VehicleBackEnd.Repository;


import com.example.VehicleBackEnd.Model.LeaseContract;
import com.example.VehicleBackEnd.Model.SalesContract;
//import org.apache.commons.dbcp2.BasicDataSource;
import com.example.VehicleBackEnd.Model.Vehicle;
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
    public void addLeaseContract(LeaseContract contract){
        String query = "{Call AddLeaseContract(?,?,?,?,?)}";
        try (Connection con = basicDataSource.getConnection(); CallableStatement callableStatement = con.prepareCall(query)){
            callableStatement.setString(1,contract.getVehicleSold().getVin());
            callableStatement.setFloat(2,(float) contract.endingValue);
            callableStatement.setFloat(3,(float) contract.leaseFeeCharge);
            callableStatement.setFloat(4,(float) contract.monthlyPayment);
            callableStatement.setFloat(5,(float) contract.totalPrice);
            callableStatement.executeQuery();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public LeaseContract getLeaseContractById(int contractId){
        String query = "{Call GetLeaseContractById(?)}";
        List<LeaseContract>  contract = new ArrayList<>();
        try(Connection connection = basicDataSource.getConnection();CallableStatement call = connection.prepareCall(query)){
            call.setInt(1,contractId);
            ResultSet resultSet =  call.executeQuery();
            while(resultSet.next()){
                String date = resultSet.getString(1);
                String customerName = resultSet.getString("CustomerName");
                String email = resultSet.getString("Email");
                DealershipRepository  dealershipRepository = new DealershipRepository();
                Vehicle vehicleSold = dealershipRepository.ById(resultSet.getString("Vin"));
                String contractDate = resultSet.getString("ContractDate");

                LeaseContract contract1 = new LeaseContract(contractDate,customerName,email,vehicleSold);
                contract.add(contract1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contract.get(0);
    }

    public void addSalesContract(SalesContract contract){
        String query = "{Call AddSalesContract(?,?,?,?,?,?,?,?)}";
        try (Connection con = basicDataSource.getConnection();CallableStatement call = con.prepareCall(query)){
            call.setString(1,contract.getVehicleSold().getVin());
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
    public SalesContract getSalesContractById(int SaleContactId){
        String query = "{Call GetSalesContractById(?)}";
        SalesContract contract = null;
        try(Connection connection = basicDataSource.getConnection();CallableStatement call = connection.prepareCall(query)){
            call.setInt(1,SaleContactId);
            contract = (SalesContract) call.executeQuery();
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return contract;
    }
}
