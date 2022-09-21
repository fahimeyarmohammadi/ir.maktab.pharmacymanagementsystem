package repository;

import model.Prescription;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionRepository {
public void insertPrescription(Prescription prescription) throws SQLException {
    Connection connection=GetConnection.getConnection();
    PreparedStatement preparedStatement=connection.prepareStatement("insert into prescription_tbl " +
            " (user_natinalcode ,numberofmedicine ,medicine1 ,medicine2 ," +
            "medicine3 ,medicine4 ,medicine_5 ," +
            "medicine6 ,medicine7 ,medicine8," +
            " medicine9 ,medicine10 ,isconfirmed ) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");

    preparedStatement.setString(1,prescription.getUserNationalCode());
    preparedStatement.setInt(2,prescription.getNumberOfMedicine());
    preparedStatement.setString(3,prescription.getMedicineList().get(0).getName());
    preparedStatement.setString(4,prescription.getMedicineList().get(1).getName());
    preparedStatement.setString(5,prescription.getMedicineList().get(2).getName());
    preparedStatement.setString(6,prescription.getMedicineList().get(3).getName());
    preparedStatement.setString(7,prescription.getMedicineList().get(4).getName());
    preparedStatement.setString(8,prescription.getMedicineList().get(5).getName());
    preparedStatement.setString(9,prescription.getMedicineList().get(6).getName());
    preparedStatement.setString(10,prescription.getMedicineList().get(7).getName());
    preparedStatement.setString(11,prescription.getMedicineList().get(8).getName());
    preparedStatement.setString(12,prescription.getMedicineList().get(9).getName());
    preparedStatement.setBoolean(13,prescription.isConfirmed());

    preparedStatement.executeUpdate();
}

public void getConfirmedPrescription(int id) throws SQLException {
    Connection connection=GetConnection.getConnection();
    PreparedStatement preparedStatement=connection.prepareStatement("select * fromprescriotion_tbl inner join medicine_tbl" +
            "on pre  ");

}

public void deletePrescription(int id) throws SQLException {
    Connection connection=GetConnection.getConnection();
    PreparedStatement preparedStatement=connection.prepareStatement("delete from prescription_tbl where id=?");
    preparedStatement.setInt(1,id);

    preparedStatement.executeUpdate();

}

public void addMedicineFromPrescription(int id,int medicineId) throws SQLException {
    Connection connection=GetConnection.getConnection();
    PreparedStatement preparedStatement=connection.prepareStatement("update prescription_tbl" +
            " set   where id=?");
}

public List<Prescription> getPrescription() throws SQLException {
    Connection connection=GetConnection.getConnection();
    PreparedStatement preparedStatement=connection.prepareStatement("select * from prescription_tbl ");
    ResultSet resultSet=preparedStatement.executeQuery();
    List<Prescription> list=new ArrayList<>();
    while(resultSet.next()){
        Prescription prescription=new Prescription(
                resultSet.getInt(1),
        );
    }
    return list;

}
}
