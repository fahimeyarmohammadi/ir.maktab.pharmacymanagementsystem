package service;

import model.Medicine;
import model.Prescription;
import repository.MedicineRepository;
import repository.PrescriptionRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientService {
    PrescriptionRepository prescriptionRepository = new PrescriptionRepository();
    MedicineRepository medicineRepository = new MedicineRepository();

    public void insertPrescription(Prescription prescription) throws SQLException {
        prescriptionRepository.insertPrescription(prescription);
        int prescriptionId = prescriptionRepository.getPrescriptionId(prescription.getUserNationalCode());
        for (int i = 0; i < prescription.getNumberOfMedicine(); i++) {
            prescriptionRepository.insertMedicineToPrescription(prescriptionId, prescription.getMedicineList().get(i).getName());
        }
    }

    public List<Medicine> getPriceOfMedicine(String nationalCode) throws SQLException {
        int prescriptionId = prescriptionRepository.getPrescriptionId(nationalCode);
        List<Medicine> priceOfMedicine = new ArrayList<>();
        priceOfMedicine = medicineRepository.getPriceOfMedicine(prescriptionId);
        return priceOfMedicine;
    }

    public double getPriceOfPrescription(String nationalCode) throws SQLException {
        int prescriptionId = prescriptionRepository.getPrescriptionId(nationalCode);
        double totalPrice = prescriptionRepository.getTotalPriceOfPrescription(prescriptionId);
        return totalPrice;
    }

    public void deletePrescription(String nationalCode) throws SQLException {
        int prescriptionId = prescriptionRepository.getPrescriptionId(nationalCode);
        prescriptionRepository.deletePrescription(prescriptionId);
        prescriptionRepository.deleteAllMedicineFromPrescription(prescriptionId);
    }

    public void addMedicineToPrescription(String nationalCode, String medicineName) throws SQLException {
        int prescriptionId = prescriptionRepository.getPrescriptionId(nationalCode);
        prescriptionRepository.insertMedicineToPrescription(prescriptionId, medicineName);
        int numberOfMedicine = prescriptionRepository.getNumberOfMedicine(prescriptionId);
        prescriptionRepository.updatePrescription(prescriptionId,numberOfMedicine+1);
    }

    public void deleteAMedicineFromPrescription(String nationalCode,String medicineName) throws SQLException {
        int prescriptionId = prescriptionRepository.getPrescriptionId(nationalCode);
        prescriptionRepository.deleteAMedicineFromPrescription(prescriptionId,medicineName);
        int numberOfMedicine = prescriptionRepository.getNumberOfMedicine(prescriptionId);
        prescriptionRepository.updatePrescription(prescriptionId,numberOfMedicine-1);
    }
}
