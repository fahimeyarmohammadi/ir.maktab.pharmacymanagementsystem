package service;

import model.Medicine;
import model.Prescription;
import model.User;
import repository.PrescriptionRepository;
import repository.UserRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminService {
    UserRepository userRepository = new UserRepository();
    PrescriptionRepository prescriptionRepository = new PrescriptionRepository();

    public boolean userSingIn(User user) throws SQLException {
        return userRepository.userSignIn(user);
    }

    public void userSingUp(User user) throws SQLException {
        userRepository.insertUser(user);
    }

    public List<Prescription> getAllPrescription() throws SQLException {
        List<Prescription> prescriptionList = new ArrayList<>();
        List<Prescription> resultPrescriptionList = new ArrayList<>();
        prescriptionList = prescriptionRepository.getPrescription();
        List<Medicine> medicineList = new ArrayList<>();
        for (int i = 0; i < prescriptionList.size(); i++) {
            int prescriptionId = prescriptionRepository.getPrescriptionId(prescriptionList.get(i).getUserNationalCode());
            medicineList = prescriptionRepository.getMedicineForEachPrescription(prescriptionId);
            Prescription prescription = new Prescription(prescriptionId, prescriptionList.get(i).isConfirmed()
                    , prescriptionList.get(i).getNumberOfMedicine()
                    , prescriptionList.get(i).getUserNationalCode(), medicineList);
            resultPrescriptionList.add(prescription);
        }
        return resultPrescriptionList;
    }

    public void confirmPrescription(List<Prescription> prescriptionList) throws SQLException {

        for (int i = 0; i < prescriptionList.size(); i++) {
            List<Medicine> medicineList = new ArrayList<>();
            int prescriptionId = prescriptionRepository.getPrescriptionId(prescriptionList.get(i).getUserNationalCode());
            if (!prescriptionList.get(i).isConfirmed()) {
                prescriptionRepository.confirmPrescription(prescriptionId);
                medicineList = prescriptionRepository.getExistMedicine(prescriptionId);
                List<Medicine> resultMedicine = new ArrayList<>();
                for (int j = 0; j < medicineList.size(); j++) {
                    double price = prescriptionRepository.getPriceOfMedicine(medicineList.get(j).getName());
                    Medicine medicine = new Medicine(medicineList.get(j).getName(), price);
                    resultMedicine.add(medicine);
                }
                List<Medicine>originalMedicineList=new ArrayList<>();
                prescriptionRepository.updatePrescription(prescriptionId,resultMedicine.size());
                originalMedicineList = prescriptionRepository.getMedicineForEachPrescription(prescriptionId);
                for (int j = 0; j < originalMedicineList.size(); j++) {
                    boolean temp=false;
                    for (int k = 0; k <medicineList.size() ; k++) {
                        if(originalMedicineList.get(j).getName().equals(medicineList.get(k).getName())) {
                            temp = true;
                            break;
                        }
                    }
                    if(!temp){
                        prescriptionRepository.deleteAMedicineFromPrescription(prescriptionId,originalMedicineList.get(j).getName());
                }
                }
            }
        }
    }
}