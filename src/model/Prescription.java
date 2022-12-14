package model;

import java.util.List;

public class Prescription {
    private int id;
    private String userNationalCode;
    private int numberOfMedicine;
    private List<Medicine> medicineList;

    private boolean isConfirmed;
    private double totalPrice;

    public Prescription(int id, boolean isConfirmed, int numberOfMedicine, String userNationalCode) {
        this.id = id;
        this.isConfirmed = isConfirmed;
        this.numberOfMedicine = numberOfMedicine;
        this.userNationalCode = userNationalCode;
    }

    public Prescription(int id, boolean isConfirmed, int numberOfMedicine, String userNationalCode, List<Medicine> medicineList) {
        this.id = id;
        this.isConfirmed = isConfirmed;
        this.numberOfMedicine = numberOfMedicine;
        this.userNationalCode = userNationalCode;
        this.medicineList = medicineList;
    }

    public Prescription(String nationalCode, int numberOfMedicine, List<Medicine> medicineList) {
        this.userNationalCode = nationalCode;
        this.numberOfMedicine = numberOfMedicine;
        this.medicineList = medicineList;
    }

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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "id=" + id +
                ", userNationalCode='" + userNationalCode + '\'' +
                ", numberOfMedicine=" + numberOfMedicine +
                ", medicineList=" + medicineList +
                ", isConfirmed=" + isConfirmed +
                ", totalPrice=" + totalPrice +
                '}';
    }
}


