package klarna;

import java.util.ArrayList;
import java.util.List;

class Transaction {
    String name, city;
    int time, amount;

    public Transaction(String strS) {
        String[] str = strS.split(",");
        this.name = str[0];
        this.time = Integer.parseInt(str[1]);
        this.amount = Integer.parseInt(str[2]);
        this.city = str[3];
    }
}

class Underwriter {
    public static String[] invalidTransactions(String[] transactions) {
        Transaction[] data = new Transaction[transactions.length];
        for (int i = 0; i < transactions.length; i++) {
            data[i] = new Transaction(transactions[i]);
        }
        //String[] ans = new String[transactions.length];
        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < data.length; i++) {
            if (data[i].amount > 2000) {
                ans.add(transactions[i]);
                continue;
            }
            for (int j = 0; j < data.length; j++) {
                if (i == j) continue;
                if (Math.abs(data[i].time - data[j].time) <= 60 && data[i].name.equals(data[j].name) && !data[i].city.equals(data[j].city)) {
                    ans.add(transactions[i]);
                    break;
                }
            }
        }
        String[] arr = new String[ans.size()];
        ans.toArray(arr);
        return arr;
    }
}

