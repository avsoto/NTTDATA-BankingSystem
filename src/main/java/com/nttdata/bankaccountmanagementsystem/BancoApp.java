package com.nttdata.bankaccountmanagementsystem;

public class BancoApp {
    public static void main(String[] args) {

        Client client = Client.register("Ana", "Soto", "12345678", "ana@example.com");
        Client client2 = Client.register("David", "Villafane", "12345679", "david@example.com");

        System.out.println("Client 1: " + client + " Client 2: " + client2);

    }
}