package com.management;

import java.util.ArrayList;

public class AccountManagement extends Account {
    private ArrayList<Account> accountList = new ArrayList<>();

    public ArrayList<Account> getList() {
        return accountList;
    }
    public void addAccount(Account account) {
        for (Account ac : accountList){
            if (ac.getID() == account.getID()){
                System.out.println("ID đã tồn tại");
                return;
            }
        }
        accountList.add(account);
    }

    public void removeAccount(Account account) {
        accountList.remove(account);
    }

    public Account searchByID(long ID) {
        for (Account account: accountList) {
            if( account.getID() == ID) {
                return account;
            }
        }
        System.out.println("ID không hợp lệ");
        return null;
    }
}



