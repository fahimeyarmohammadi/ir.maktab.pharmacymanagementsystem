gipackage repository;

import model.Medicine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicineRepository {
    public List<Medicine> getPriceOfMedicine() throws SQLException {
        Connection connection=GetConnection.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("select name , price from medicine_tbl" +
                " inner join medicinesOfPrescription_tbl on medicine_tbl.name=medicinesOfPrescription_tbl.medicineName" +
                " inner join prescription_tbl on medicinesOfPrescription_tbl.prescription_id=prescription_tbl.id where" +
                " isconfirmed=?");
        preparedStatement.setBoolean(1,true);
        ResultSet resultSet=preparedStatement.executeQuery();
        List<Medicine>medicineList=new ArrayList<>();
        while (resultSet.next()){
            Medicine medicine=new Medicine(
                    resultSet.getString(0),
                    resultSet.getDouble(1)
            );
            medicineList.add(medicine);
        }
        return medicineList;
    }
}
