package MorueBanks;
import java.util.Scanner;

public class inputReader {
    private Scanner inputScan = new Scanner(System.in);

    public String readName() {
        System.out.print("Enter name - \n> ");

        String name = this.inputScan.nextLine();

        return name;
    }

    public String readCmd() {
        System.out.print("MorueBanks > ");

        String cmd = this.inputScan.nextLine();

        return cmd;
    }

    public int readNum() {
        System.out.print("Enter account number - \n> ");
        int num;

        try {
            num = Integer.parseInt(this.inputScan.nextLine());
        }
        catch (NumberFormatException e) {
            num = 0;
        }
        
        return num;
    }
    
    public int readValue() {
        System.out.print("Enter value - \n> ");
        int value;

        try {
            value = Integer.parseInt(inputScan.nextLine());
        }
        catch (NumberFormatException e) {
            value = 0;
        }

        if (value < 0) value = 0;
        
        return value;
    }

    public void close() {
        this.inputScan.close();
    }

    public inputReader() {
        super();
    }
}