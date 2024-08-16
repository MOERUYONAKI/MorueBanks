package MorueBanks;
import java.util.ArrayList;
import java.util.List;

public class bankAccount {
    private int numero;
    private String nom;
    private int credit;

    public static boolean check(List<bankAccount> tab, int val) {
        boolean b = true;

        if (val < 1000 || val > 9999) {
            b = false;
        } else {
            for(bankAccount i : tab){
                if(i.get_numero() == val){
                    b = false;
                    break;
                }
            }
        }

        return b;
    }

    public int get_numero() {
        return this.numero;
    }

    public String get_nom() {
        return this.nom;
    }

    public int get_solde() {
        return this.credit;
    }

    public void deposer(int somme) {
        credit += somme;
    }

    public void retirer(int somme) {
        credit -= somme;
    }

    public void afficher() {
        System.out.println("Solde de " + nom + " (" + numero + ") : \n" + credit);
    }

    public bankAccount() {
        super();

        randomAccountNumber numero = new randomAccountNumber();
        int n = numero.rollValue(new ArrayList<bankAccount>());

        this.numero = n;
        this.nom = "Anonymous";
        this.credit = 0;
    }

    public bankAccount(List<bankAccount> accounts) {
        super();

        randomAccountNumber numero = new randomAccountNumber();
        int n = numero.rollValue(accounts);

        this.numero = n;
        this.nom = "Anonymous";
        this.credit = 0;

        accounts.add(this);
    }
    
    public bankAccount(List<bankAccount> accounts, String nom) {
        super();

        randomAccountNumber numero = new randomAccountNumber();
        int n = numero.rollValue(accounts);

        this.numero = n;
        this.nom = nom;
        this.credit = 0;

        accounts.add(this);
    }
    
    public bankAccount(List<bankAccount> accounts, int numero, String nom) throws NumError {
        super();

        if (!check(accounts, numero)) {
            try {
                throw new NumError();
            }
            catch (NumError e) {
                System.out.println(e) ;
            }

            randomAccountNumber newNumero = new randomAccountNumber();
            numero = newNumero.rollValue(accounts);

            System.out.println("-> Le numéro corrompu a été remplacé avec succès !\n");
        }

        this.numero = numero;
        this.nom = nom;
        this.credit = 0;

        accounts.add(this);
    }
}

// Définition d'une erreur si le numéro de compte est déjà attribué ou à un format invalide
class NumError extends Exception {
    public String toString(){
      return ("\nNumError : Numero de compte invalide...");
   }
}