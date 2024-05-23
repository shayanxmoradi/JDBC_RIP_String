package sql.domain;

public class Borrower {
    private String customerName;
    private int loanNumbe;

    public Borrower(String customerName, int loanNumbe) {
        this.customerName = customerName;
        this.loanNumbe = loanNumbe;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getLoanNumbe() {
        return loanNumbe;
    }

    public void setLoanNumbe(int loanNumbe) {
        this.loanNumbe = loanNumbe;
    }
}
