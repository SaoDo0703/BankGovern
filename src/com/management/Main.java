package com.management;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class  Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        AccountManagement accountManagement = new AccountManagement();
        ArrayList<Account> accounts = accountManagement.getList();
        showMenu();
        while (true) {
            int number = scanner.nextInt();
            switch (number) {

                case 1:
                    Account account = inputInfor();
                    if(accounts.contains(account)){
                        System.out.println("ID Already Exist !!");
                    }else{
                        accountManagement.addAccount(account);
                        System.out.println("Added !!");
                    }
                    break;
                case 2:
                    System.out.println("nhập ID muốn xóa:");
                    long id = scanner.nextLong();
                    Account A = accountManagement.searchByID(id);
                    if ( A == null ){
                        break;
                    }
                    accountManagement.removeAccount(A);
                    System.err.println("đã xóa thành công");
                    break;
                case 3:
                    System.out.println("nhap ID");
                    Long Id = scanner.nextLong();
                    for (Account account2 : accounts){
                        if (account2 == accountManagement.searchByID(Id)){
                            System.out.println(account2);
                        }
                    }
                    break;

                case 4:
                    for (Account acc: accounts) {
                        display(acc);
                    }
                    break;
                case 5:
                    System.out.println("Nhập ID:");
                    long d = scanner.nextLong();
                    Account a = accountManagement.searchByID(d);
                    if (a == null ) {
                        break;
                    }
                    System.out.println("nhập số tiền cần chuyển");
                    double k = scanner.nextDouble();
                    if ( k <= 0 ) {
                        System.out.println("số tiền chuyển k hợp lệ");
                    }
                    a.addMoney(k);
                    System.out.println("chuyển tiền thành công");
                    break;
                case 6:
                    System.out.println("Nhập ID");
                    Long r = scanner.nextLong();
                    Account account4 = accountManagement.searchByID(r);
                    if( account4 == null ){
                        break;
                    }
                    System.out.println("Nhập số tiền muốn rút:");
                    double m = scanner.nextDouble();
                    if ( m > account4.getAmount() ){
                        System.out.println("số tiền rút không hợp lệ");
                    }else {
                        account4.withdraw(m);
                        System.out.println("đã rút thành công");
                    }
                    break;
                case 7:
                    System.out.println(" Nhập ID Nhận tiền:");
                    long accountGet = scanner.nextLong();
                    System.out.println(" Nhập ID chuyển tiền");
                    long accountTransfer = scanner.nextLong();
                    System.out.println("nhập số tiền chuyển:");
                    double money = scanner.nextDouble();
                    Account account1 = accountManagement.searchByID(accountGet);
                    Account account2 = accountManagement.searchByID(accountTransfer);
                    if ((account1 == null) || (account2 ==null)){
                        break;
                    }
                    if (money >= account2.getAmount()){
                        System.out.println("số tiền không hợp lệ");
                    } else  {
                        account1.transfer(money,account2);
                    }
                    break;
                case 8:
                    Collections.sort(accounts, new Comparator<Account>() {
                        @Override
                        public int compare(Account o1, Account o2) {
                            int index = o1.getAccountName().compareTo(o2.getAccountName());
                                if(index >=0){
                                    return 1;
                                }else{
                                    return -1;
                                }
                            }
                    }); //
                    for( Account account3 : accounts){
                        System.out.println("After Sort !!");
                        display(account3);
                    }
                    break;
                case 9:
                    Collections.sort(accounts, new Comparator<Account>() {
                        @Override
                        public int compare(Account o1, Account o2) {
                            if (o1.getAmount() > o2.getAmount()) {
                                return -1;
                            } else if (o1.getAmount() < o2.getAmount()) {
                                return 1;
                            } else {
                                return 0;
                            }
                        }
                    });
                    for(Account account3 : accounts){
                        display(account3);
                        System.out.println("After Sort");
                    }
                    break;
                case 10:
                    showMenu();
                    break;
                case 11:
                    return;
                default:
                    System.out.println("Mời bạn nhập lại:");
                    break;
            }

        }
    }

    public static void showMenu() {
        System.out.println("Welcome to the Agribank");
        System.out.println("Please choose an action: ");
        System.out.println("1. Add Account");
        System.out.println("2. Delete Account");
        System.out.println("3. Search Account");
        System.out.println("4. Display all");
        System.out.println("5. Add money for an account");
        System.out.println("6. Withdraw money from an account");
        System.out.println("7. Transfer money");
        System.out.println("8. Sort List Based On Name ");
        System.out.println("9. Sort List Based One Amount");
        System.out.println("10. Show menu");
        System.out.println("11. Exist");
    }

    public static Account inputInfor() {
        System.out.println("Please input infor of an account: ");
        System.out.print(" ID: ");
        long ID = scanner.nextLong();
        scanner.nextLine();
        System.out.print(" accountName: ");
        String accountName = scanner.nextLine();
        double initialMoney = 50000;
        return new Account(ID, accountName, initialMoney);
    }

    public static void display(Account account) {
        System.out.println(account.toString());
    }
}


