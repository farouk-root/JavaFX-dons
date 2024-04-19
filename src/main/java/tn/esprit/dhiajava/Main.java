package tn.esprit.dhiajava;

import tn.esprit.dhiajava.models.DonsModel;
import tn.esprit.dhiajava.services.DonsFinanciaireService;
import tn.esprit.dhiajava.utils.MyDatabase;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        MyDatabase myDatabase = MyDatabase.getInstance();
        DonsFinanciaireService donsFinanciaireService = new DonsFinanciaireService(myDatabase);
        //DonsModel don = new DonsModel("Farouk", "Don1 description", 100);
        //donsFinanciaireService.add(don);
        //donsFinanciaireService.update(don, 8);
        //donsFinanciaireService.delete(8);
//        List<DonsModel> donsList = donsFinanciaireService.getAll();
//        for (DonsModel don : donsList) {
//            System.out.println(don.getId());
//        }
//        DonsModel don = donsFinanciaireService.getById(7);
//        System.out.println(don.getTitre());
    }
}

