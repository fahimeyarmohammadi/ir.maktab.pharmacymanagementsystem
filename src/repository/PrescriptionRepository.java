package repository;

import model.Prescription;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrescriptionRepository {
public void insertPrescription(Prescription prescription) throws SQLException {
    Connection connection=GetConnection.getConnection();
    PreparedStatement preparedStatement=connection.prepareStatement("insert into prescription_tbl " +
            " (id , user_id ,medicine_id_1 ,medicine_id_2 ," +
            "medicine_id_3 ,medicine_id_4 ,medicine_id_5 ," +
            "medicine_id_6 ,medicine_id_7 ,medicine_id_8," +
            " medicine_id_9 ,medicine_id_10) values (?,?,?,?,?,?,?,?,?,?,?,?)");
    preparedStatement.setInt(1,prescription.getId());
    preparedStatement.setInt(1,prescription.getUserId());
    preparedStatement.setInt(1,prescription.getMedicineList().get(0).getId());
    preparedStatement.setInt(1,prescription.getMedicineList().get(1).getId());
    preparedStatement.setInt(1,prescription.getMedicineList().get(2).getId());
    preparedStatement.setInt(1,prescription.getMedicineList().get(3).getId());
    preparedStatement.setInt(1,prescription.getMedicineList().get(4).getId());
    preparedStatement.setInt(1,prescription.getMedicineList().get(5).getId());
    preparedStatement.setInt(1,prescription.getMedicineList().get(6).getId());
    preparedStatement.setInt(1,prescription.getMedicineList().get(7).getId());
    preparedStatement.setInt(1,prescription.getMedicineList().get(8).getId());
    preparedStatement.setInt(1,prescription.getMedicineList().get(9).getId());

    preparedStatement.executeUpdate();
}

public void deletePrescription(int id) throws SQLException {
    Connection connection=GetConnection.getConnection();
    PreparedStatement preparedStatement=connection.prepareStatement("delete from prescription_tbl where id=?");
    preparedStatement.setInt(1,id);

    preparedStatement.executeUpdate();

}

public void deleteMedicineFromPrescription(int id,String medicineName) throws SQLException {
    Connection connection=GetConnection.getConnection();
    PreparedStatement preparedStatement=connection.prepareStatement("update prescription_tbl" +
            "");
}
}
