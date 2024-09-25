
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class DaySeven {
    private final Scanner scanner = new Scanner(System.in);

    public void pinCheck() {
        String PIN;
        boolean checks;
        do {
            System.out.print("Masukkan PIN\t\t\t:\t");
            PIN = scanner.nextLine();
            checks = PIN.length() != 6 || !(PIN.matches("[0-9]+"));
            if (checks)
                System.out.println("PIN SALAH!");
        } while (checks);
    }

    public long depositCash(long balance) {
        System.out.print("Uang yang disetor\t\t:\t");
        long amount = Long.parseLong(scanner.nextLine().trim().replaceAll("[^0-9a-zA-Z]", "")); // NumberFormatException
        return balance + amount;
    }

    public void mainMenu() {
        System.out.print("Pilihan transfer\t\t:\t");
        System.out.print("1. Antar Rekening\t");
        System.out.println("2. Antar Bank\t");
        System.out.println("\t\t\t\t\t*input pilihannya berupa angka 1 atau 2");
        System.out.print("Input\t\t\t\t: \t");
    }

    public boolean inputTransferAccount() {
        boolean checks;
        String account;
        do {
            System.out.print("Masukkan rekening tujuan\t:\t");
            account = scanner.nextLine();
            checks = account.length() != 10 || !(account.matches("[0-9]+"));
            if (checks) {
                System.out.println("Rekening salah!");
                System.out.print("Ulangi ? (Y/N)\t");
                if (scanner.nextLine().toLowerCase().equals("n"))
                    break;
            }
        } while (checks);
        return checks;
    }

    public boolean inputBankId() {
        boolean checks;
        String bankId;
        do {
            System.out.print("Masukkan kode bank\t\t:\t");
            bankId = scanner.nextLine();
            checks = bankId.length() != 3 || !(bankId.matches("[0-9]+"));
            if (checks) {
                System.out.println("Kode bank tidak ditemukan!");
                System.out.print("Ulangi ? (Y/N)\t");
                if (scanner.nextLine().toLowerCase().equals("n"))
                    break;
            }
        } while (checks);
        inputTransferAccount();
        return checks;
    }

    public long inputTransferAmount() {
        System.out.print("Masukkan nominal transfer\t:\t");
        long amount = Long.parseLong(scanner.nextLine().trim().replaceAll("[^0-9a-zA-Z]", "")); // NumberFormatException
        return amount;
    }

    public long betweenAccounts(long balance) throws InsufficientBalanceException {
        boolean checks = inputTransferAccount();
        long amount = 0;
        if (!checks) {
            amount = inputTransferAmount();
            if (balance - amount < 0) {
                throw new InsufficientBalanceException("Saldo Rekening tidak Cukup: " + balance);
            }
        } else {
            System.out.println("Transfer dibatalkan!");
            return balance - amount;
        }
        Locale locale = new Locale("id", "ID");
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        System.out.print("Transaksi berhasil, saldo anda saat ini ");
        System.out.println(nf.format(balance - amount));
        return balance - amount;
    }

    public long betweenBanks(long balance) throws InsufficientBalanceException {
        boolean checks = inputBankId();
        long amount = 7500;
        if (!checks) {
            amount += inputTransferAmount();
            if (balance - amount < 0) {
                throw new InsufficientBalanceException("Saldo Rekening tidak Cukup: " + balance);
            }
        } else {
            System.out.println("Transfer dibatalkan!");
            return balance;
        }
        Locale locale = new Locale("id", "ID");
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        System.out.print("Transaksi berhasil, saldo anda saat ini ");
        System.out.println(nf.format(balance - amount));
        return balance - amount;
    }

    public void moneyTransferProgram(long balance) {
        try {
            pinCheck();
            balance = depositCash(balance);
            int menuOption;
            do {
                mainMenu();
                try {
                    menuOption = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    menuOption = -1; // make menuOption case default, so still loops
                }
                switch (menuOption) {
                    case (1) -> {
                        try {
                            balance = betweenAccounts(balance);
                        } catch (InsufficientBalanceException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    case (2) -> {
                        try {
                            balance = betweenBanks(balance);
                        } catch (InsufficientBalanceException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    default -> {
                        System.out.println("Menu Tidak Ditemukan!");
                        System.out.print("Ulangi ? (Y/N)\t");
                        if (scanner.nextLine().toLowerCase().equals("n"))
                            menuOption = 0;
                    }
                }
            } while (menuOption != 1 && menuOption != 2 && menuOption != 0);
        } catch (NumberFormatException e) {
            System.out.println("Nominal input tidak valid!");
        }
    }
}