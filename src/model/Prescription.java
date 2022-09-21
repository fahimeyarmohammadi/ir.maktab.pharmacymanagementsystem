package model;

import java.util.List;

public class Prescription {
    private int id;
    private String userNationalCode;
    private int numberOfMedicine;
    private List<Medicine>medicineList;

     private boolean isConfirmed;

    public int getNumberOfMedicine() {
        return numberOfMedicine;
    }

    public void setNumberOfMedicine(int numberOfMedicine) {
        this.numberOfMedicine = numberOfMedicine;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserNationalCode() {
        return userNationalCode;
    }

    public void setUserNationalCode(String userNationalCode) {
        this.userNationalCode = userNationalCode;
    }

    public List<Medicine> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<Medicine> medicineList) {
        this.medicineList = medicineList;
    }
}


