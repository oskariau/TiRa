package tree;
/**
 *
 * @author kamaj
 */
public class Menu {
//main alkaa-----------------------------------------------------------------------------
        public static void main(String[] args) {

                        printMenu();

        }
//main loppuu --------------------------------------------------------------------------
//printMenu alkaa------------------------------------------------------------------
        @SuppressWarnings("null")
		private static void printMenu() {
                char select;
                BinaryTree tree = new BinaryTree();
                int data;
                do {

                        System.out.println("\n\t\t\t1. Lisää avain.");
                        System.out.println("\t\t\t2. Etsi avaimella.");
                        System.out.println("\t\t\t3. Poista avaimella.");
                        System.out.println("\t\t\t4. Käy puu läpi esijärjestyksessä.");
                        System.out.println("\t\t\t5. lopetus ");
                        System.out.print("\n\n"); // tehdään tyhjiä rivejä
                        select = Lue.merkki();
                        switch (select) {
                        case '1':
                            System.out.println("Anna uusi avain (merkkijono)");
                            data = Lue.kluku();
                            tree.insert(data);
                            break;
                        case '2':                           
                            System.out.println("Anna etsittävä avain (merkkijono)");
                            data = Lue.kluku();
                            if (tree.find(data)!=null){
                                System.out.println("Avain löytyi.");
                            }
                            else {
                                System.out.println("Avainta ei löytynyt.");
                            }                     
                            break;
                        case '3':
                        	System.out.println("Anna poistettava avain");
                        	data = Lue.kluku();
                        	if (tree.find(data)!=null){
                        		tree.delete(data);
                                System.out.println("Avain poistettu.");
                            }
                            else {
                                System.out.println("Avainta ei löytynyt.");
                            } 
                        	break;
                        case '4':
                            //tree.preOrder();
                            char h = Lue.merkki(); // pysäytetään kontrolli
                            break;
                        case '5':
                            break;
                        }
                }
                while (select != '5');
        }
//printMenu loppuu ----------------------------------------------------------------
}
