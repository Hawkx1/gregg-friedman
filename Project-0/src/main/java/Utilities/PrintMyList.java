package Utilities;

import Items.AccountItem;

public class PrintMyList {

    public static void printList(AccountItem acctItem) {
        System.out.print(acctItem.getAccount_id() + " | ");
        System.out.printf("$%.2f%n", acctItem.getBalance());
    }
}
