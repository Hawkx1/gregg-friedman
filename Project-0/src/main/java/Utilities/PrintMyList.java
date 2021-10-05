package Utilities;

import Items.AccountItem;

public class PrintMyList {

    public static void printList(AccountItem acctItem) {
        /*This method takes the AccountItem object brought in by the ArrayList displays the account_id part of the item
        puts a separator in the form of a pipe. Then, without a newline since it's a print not a println, uses the "print
        function" printf to show the balance part of the item as currency using a regular expression.
         */
        System.out.print(acctItem.getAccount_id() + " | ");
        System.out.printf("$%.2f\n", acctItem.getBalance());
    }
}
