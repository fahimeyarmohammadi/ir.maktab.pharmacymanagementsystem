package repository;

import model.Prescription;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrescriptionRepository {
public void insertPrescription(Prescription prescription) throws SQLException {
    Connection connection=GetConnection.getConnection();
    PreparedStatement preparedStatement=connection.prepareStatement("insert into prescription_tbl " +
            " (id , user_id ,medicine_id) values (?,?,?)");
    preparedStatement.setInt(1,prescription.getId());
    preparedStatement.setInt(1,prescription.getUserId());
    preparedStatement.setInt(1,prescription.getMedicineList().get(0).getId());

    preparedStatement.executeUpdate();
}
}
