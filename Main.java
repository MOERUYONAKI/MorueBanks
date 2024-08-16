package MorueBanks;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws NumError {
        List<bankAccount> accounts = new ArrayList<bankAccount>();
        inputReader reader = new inputReader();

    /* - TESTS
        // Morue avec un numéro et un nom
        bankAccount morue = new bankAccount(accounts, 1234, "Morue");
        morue.deposer(100);
        morue.retirer(75);
        morue.afficher();

        // Morue avec un numéro aléatoire et un nom
        bankAccount randomMorue = new bankAccount(accounts, "Morue");
        randomMorue.retirer(20);
        randomMorue.afficher();

        // Morue avec un numéro aléatoire et sans nom
        bankAccount secretMorue = new bankAccount(accounts);
        secretMorue.deposer(10);
        secretMorue.afficher();

        // Morue avec un numéro aléatoire non répertorié et sans nom
        bankAccount glitchedMorue = new bankAccount();
        glitchedMorue.afficher();

        // Morue avec un numéro invalide et un nom
        bankAccount falseMorue = new bankAccount(accounts, 124, "Morue");
        falseMorue.afficher();

        // Morue avec un numéro et un nom entrés manuellement
        System.out.println(" ");

        String name = reader.readName();
        int num = reader.readNum();

        if (num > 999 && num < 10000) {
            System.out.println(" ");
        }

        bankAccount customMorue = new bankAccount(accounts, num, name);
        customMorue.afficher();
    TESTS - */

        System.out.println("\n> ----- MorueBanks ----- <\n");

        // Lecture des commandes 
        inputCommands prompt = new inputCommands(reader);
        prompt.read(accounts);
    }
}