package MorueBanks;
import java.util.List;
import java.util.Random;

public class randomAccountNumber {
    private int value;

    public int getValue() {
        return this.value;
    }

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

    public int rollValue(List<bankAccount> accounts) {
        int n = 0;

        while (true) {
            Random rand = new Random();
            n = rand.nextInt(9000);
            n += 1000;

            if (check(accounts, n)) {
                break;
            }
        }

        this.value = n;
        return n;
    }

    public randomAccountNumber() {
        super();

        this.value = 0;
    }
}