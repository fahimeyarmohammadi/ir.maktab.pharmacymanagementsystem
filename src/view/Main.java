package view;

import model.Medicine;
import model.Prescription;
import model.User;
import service.PatientService;
import service.AdminService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        PatientService patientService = new PatientService();
        AdminService adminService = new AdminService();
        System.out.println("are you admin or patient");
        System.out.println("1--> patient 2--> admin");
        String answer = scanner.nextLine();
        switch (answer) {
            case "1":
                System.out.println("enter your prescription information enter your nationalCod");
                String nationalCode = scanner.nextLine();
                boolean flag = true;
                int numberOfMedicine = 0;
                while (flag) {
                    System.out.println("enter number of medicine between 1 and 10");
                    numberOfMedicine = Integer.parseInt(scanner.nextLine());
                    if (numberOfMedicine > 1 && numberOfMedicine <= 10)
                        flag = false;
                }
                List<Medicine> medicineList = new ArrayList<>();
                for (int i = 0; i < numberOfMedicine; i++) {
                    System.out.println("enter medicine name");
                    String medicineName = scanner.nextLine();
                    Medicine medicine = new Medicine(medicineName);
                    medicineList.add(medicine);
                }
                Prescription prescription = new Prescription(nationalCode, numberOfMedicine, medicineList);
                patientService.insertPrescription(prescription);


                break;
            case "2":
                System.out.println(" singIn--->1 , singUp--->2 ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        System.out.println("enter your username and nationalCode");
                        String userName = scanner.nextLine();
                        String nationalcode = scanner.nextLine();
                        User user = new User(userName, nationalcode);
                        if (!adminService.userSingIn(user))
                            System.out.println("this user not found");
                        else {
                            List<Prescription>allPrescription=new ArrayList<>();
                            allPrescription=adminService.getAllPrescription();
                            for (int i = 0; i <allPrescription.size() ; i++) {
                                System.out.println(allPrescription.get(i));
                            }
                            adminService.confirmPrescription(allPrescription);
                        }
                        break;

                }
        }

    }
}
