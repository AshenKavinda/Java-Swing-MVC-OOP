import View.FormCashier.FormCashier;
import View.FormStock.FormStock;
import View.FormUser.FormUser;
import View.LogIn.FormLogIn;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {

            //FormStock formStock = new FormStock();
            //FormCashier formCashier = new FormCashier(2);
            //FormUser formUser = new FormUser();
            //FormSalesReport formSalesReport = new FormSalesReport();

            /*-------------------------------------------------------------------*/
            FormLogIn formLogIn = new FormLogIn();

            //**form user has not user login**
            //FormUser formUser = new FormUser();
            /*-------------------------------------------------------------------*/

            //database code is included in project folder
            //LogIn data
            //Inventory username = nicInventory password = 1234
            //Cashier username = nicCashier password = 1234
            //TopBord username = nicTopBord password = 1234

            //special note
            //cashier interface (only works for key listeners)
                //fill item code and quantity press enter to add item(cursor should be in the quantity field)
                //for edit item table, press f2 after cursor focused to table and using up down arrows select item and press delete button
                //after all item added press F12 for billing
                //F12 -> billing
                    //first press - focus to cash text field fill it and press again
                    //second press - it fill balance value and press again
                    //third press - conform bill and generate bill
                    //***to print bill should fill correct folder path (Model/Bill/Bill/printTxt()/directoryPath)***


        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}