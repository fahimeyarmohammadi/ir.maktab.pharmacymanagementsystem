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
            " (user_natinalcode ,numberofmedicine, totalPrice ,isconfirmed ) values (?,?,?,?)");

    preparedStatement.setString(1,prescription.getUserNationalCode());
    preparedStatement.setInt(2,prescription.getNumberOfMedicine());
    preparedStatement.setDouble(3,prescription.getTotalPrice());
    preparedStatement.setBoolean(4,prescription.isConfirmed());

    preparedStatement.executeUpdate();
}
public void insertMedicineToPrescription(int prescriptionId, String medicineName) throws SQLException {
    Connection connection=GetConnection.getConnection();
    PreparedStatement preparedStatement=connection.prepareStatement( "insert into medicinesOfPrescription_tbl" +
            "(prescription_id , medicineName ) values (?,?)");
    preparedStatement.setInt(1,prescriptionId);
    preparedStatement.setString(2,medicineName);

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
public void deleteAllMedicineFromPrescription(int id) throws SQLException {
    Connection connection=GetConnection.getConnection();
    PreparedStatement preparedStatement=connection.prepareStatement( "delete from medicinesOfPrescription_tbl" +
            " where prescription_id=?");
    preparedStatement.setInt(1,id);
    preparedStatement.executeUpdate();
}

public void deleteAMedicineFromPrescription(int id,String medicineName) throws SQLException {
    Connection connection=GetConnection.getConnection();
    PreparedStatement preparedStatement=connection.prepareStatement( "delete from medicinesOfPrescription_tbl" +
            " where prescription_id=? and medicineName=?");
    preparedStatement.setInt(1,id);
    preparedStatement.setString(2,medicineName);
    preparedStatement.executeUpdate();
}

public List<Prescription> getPrescription() throws SQLException {
    Connection connection=GetConnection.getConnection();
    PreparedStatement preparedStatement=connection.prepareStatement("select * from prescription_tbl" +
            " inner join medicinesOfPrescription_tbl on prescription_tbl.id=medicinesOfPrescription_tbl.prescription_id ");
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
