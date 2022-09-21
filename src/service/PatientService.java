package service;

import model.Prescription;
import repository.PrescriptionRepository;

import java.sql.SQLException;

public class PatientService {
    PrescriptionRepository prescriptionRepository = new PrescriptionRepository();

    public void insertPrescription(Prescription prescription) throws SQLException {
        prescriptionRepository.insertPrescription(prescription);
        int prescriptionId = prescriptionRepository.getPrescriptionId(prescription.getUserNationalCode());
        for (int i = 0; i < prescription.getNumberOfMedicine(); i++) {
            prescriptionRepository.insertMedicineToPrescription(prescriptionId, prescription.getMedicineList().get(i).getName());
        }
    }

}
