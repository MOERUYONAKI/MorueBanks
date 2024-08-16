package MorueBanks;
import java.util.List;

public class inputCommands {
    private inputReader reader;

    public static bankAccount checkAndGet(List<bankAccount> tab, int val) {
        for (bankAccount i : tab) {
            if(i.get_numero() == val){
                return i;
            }
        }

        return null;
    }
    
    public void read(List<bankAccount> accounts) throws NumError {
        String cmd = this.reader.readCmd();
        bankAccount account;
        String name;
        int value, num;

        switch (cmd) {
            case "help":
            case "?":
            case "":
                System.out.print("Commands - \n" +
                                        " add \n" +
                                        " exit \n" +
                                        " list \n" +
                                        " new \n" + 
                                        " pay \n" + 
                                        " take \n"
                                    ); break;

            case "add":
                value = this.reader.readValue();
                num = this.reader.readNum();

                account = checkAndGet(accounts, num);

                account.deposer(value);
                System.out.println(" ");

                account.afficher();
                break;

            case "exit":
                reader.close();
                break;

            case "list":
                for (bankAccount acc : accounts) {
                    acc.afficher();
                }

                break;

            case "new":
                name = this.reader.readName();
                num = this.reader.readNum();

                account = new bankAccount(accounts, num, name);
                System.out.println(" ");

                account.afficher();
                break;

            case "pay":
                for (bankAccount acc : accounts) {
                    int salaire = Math.round(acc.get_solde() * 40 / 100);

                    if (salaire < 20) {
                        salaire = 20;
                    }

                    acc.deposer(salaire);
                    System.out.println(acc.get_nom() + "(" + acc.get_numero() + ") - +" + salaire);
                }

                break;

            case "take":
                value = this.reader.readValue();
                num = this.reader.readNum();

                account = checkAndGet(accounts, num);
                
                account.retirer(value);
                System.out.println(" ");

                account.afficher();
                break;
        
            default:
                System.out.println("Commande introuvable, try \"help\"...");
                break;
        }

        if (!cmd.equals("exit")) {
            System.out.println(" "); 
            read(accounts);
        }
    }

    public inputCommands() {
        super();

        this.reader = new inputReader();
    }

    public inputCommands(inputReader reader) {
        super();

        this.reader = reader;
    }
}