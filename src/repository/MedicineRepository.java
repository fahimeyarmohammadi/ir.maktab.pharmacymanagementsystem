package repository;

import model.Medicine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MedicineRepository {
    public List<Medicine> getPriceOfMedicine() throws SQLException {
        Connection connection=GetConnection.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("select * from prescription_tbl" +
                " inner join medicinesOfPrescription_tbl on prescription_tbl.id=medicinesOfPrescription_tbl.prescription_id" +
                " inner join medicine_tbl on medicinesOfPrescription_tbl.medicineNme=medicine_tbl.name where" +
                " isconfirmed=?");
        preparedStatement.setBoolean(1,true);
        ResultSet resultSet=preparedStatement.executeQuery();
    }
}
