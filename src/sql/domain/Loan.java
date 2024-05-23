package sql.domain;

public class Loan {
    private int loanNumber;
    private String brnachName;
    private double amount;

    public Loan(int loanNumber, String brnachName, double amount) {
        this.loanNumber = loanNumber;
        this.brnachName = brnachName;
        this.amount = amount;
    }

    public int getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(int loanNumber) {
        this.loanNumber = loanNumber;
    }

    public String getBrnachName() {
        return brnachName;
    }

    public void setBrnachName(String brnachName) {
        this.brnachName = brnachName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}