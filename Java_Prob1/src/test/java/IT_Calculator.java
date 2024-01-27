import java.util.Scanner;

public class IT_Calculator {
    public static void main(String[] args) {
        double taxableIncome, taxPaidPerYear, taxPayablePerMonth;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Taxable Income: $");
        taxableIncome = scanner.nextDouble();
        double taxRate;
        if (taxableIncome <= 25000) {
            taxRate = 0;
        } else if (taxableIncome <= 50000) {
            taxRate = 0.1;
        } else if (taxableIncome <= 75000) {
            taxRate = 0.2;
        } else {
            taxRate = 0.3;
        }
        taxPaidPerYear = taxableIncome * taxRate;
        System.out.println("Tax Paid in a Year: $" + taxPaidPerYear);
        taxPayablePerMonth = taxPaidPerYear / 12;
        System.out.println("Tax Payable per Month: $" + taxPayablePerMonth);
        scanner.close();
    }
}
