package repository;

import model.Medicine;
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
    PreparedStatement preparedStatement=connection.prepareStatement("select * from prescription_tbl");
    ResultSet resultSet=preparedStatement.executeQuery();
    List<Prescription> list=new ArrayList<>();
    while(resultSet.next()){
        Prescription prescription=new Prescription(
                resultSet.getInt(1),
                resultSet.getBoolean(2),
                resultSet.getInt(3),
                resultSet.getString(4)
        );
    }
    return list;
}

public List<Medicine>getMedicineForEachPrescription(int id) throws SQLException {
    Connection connection=GetConnection.getConnection();
    PreparedStatement preparedStatement=connection.prepareStatement("select * from medicine_tbl inner join" +
            "  medicineOfPrescription_tbl on medicine_tbl.name=medivineOfPrescription_tbl.medicineName where prescription_id=?");
    preparedStatement.setInt(1,id);

    ResultSet resultSet=preparedStatement.executeQuery();
    List<Medicine> medicineList=new ArrayList<>();
    while(resultSet.next()){
        Medicine medicine=new Medicine(
                resultSet.getString(1)
        );
        medicineList.add(medicine);
    }
    return medicineList;
}

public void confirmPrescription(int id ) throws SQLException {
    Connection connection=GetConnection.getConnection();
    PreparedStatement preparedStatement=connection.prepareStatement("update prescription_tbl" +
            " set isconfirmed=? where id=?");
    preparedStatement.setBoolean(1,true);
    preparedStatement.setInt(2,id);
    preparedStatement.executeUpdate();
}
public List<Medicine> getExistMedicine(int id) throws SQLException {
    Connection connection=GetConnection.getConnection();
    PreparedStatement preparedStatement=connection.prepareStatement("select name , isExist from medicine_tbl" +
            "inner join medicineOfPrescription_tbl where" +
            " medicineOfPrescription_tbl.prescription_id=?");
    ResultSet resultSet=preparedStatement.executeQuery();
    List<Medicine>medicineList=new ArrayList<>();
    while(resultSet.next()){
        if(resultSet.getBoolean(2)){
            Medicine medicine=new Medicine(resultSet.getString(1));
            medicineList.add(medicine);
        }
    }
        return medicineList;
}
}
