public class Main {

    public static void main(String[] args) {

        PrinterService printerService = new PrinterService();

        System.out.println(printerService.getPrinters());

        //print some stuff. Change the printer name to your thermal printer name.
        printerService.printString("POS-80", "\n\n testing \n\n testing");

        // cut that paper!
        // byte[] cutP = new byte[] { 0x1d, 'V', 1 };
        // byte[] cutP = new byte[] { 'O', 'V', 'O'};

        // printerService.printBytes("POS-80", cutP);

    }

}