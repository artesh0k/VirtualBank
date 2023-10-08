package sk.tuke.virtualbank.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Payment {
   @Id
   @GeneratedValue
   private int paymentId;

   @ManyToOne
   @JoinColumn(name="payer_account_id", nullable=false)
   private Account payer;

   @ManyToOne
   @JoinColumn(name="beneficiary_account_id", nullable=false)
   private Account beneficiary;

   @Column(nullable = false)
   private double amount;

   private String variableSym;

   private String specificSym;

   private String constantSym;

   private String informationForBeneficiary;

   @Column(nullable = false)
   private Date doneAt;

   public Payment() {
   }


   public Payment(Account payer, Account beneficiary, double amount, String variableSym, String specificSym, String constantSym, String informationForBeneficiary, Date doneAt) {
      this.payer = payer;
      this.beneficiary = beneficiary;
      this.amount = amount;
      this.variableSym = variableSym;
      this.specificSym = specificSym;
      this.constantSym = constantSym;
      this.informationForBeneficiary = informationForBeneficiary;
      this.doneAt = doneAt;
   }

   public int getPaymentId() {
      return paymentId;
   }

   public Account getPayer() {
      return payer;
   }

   public void setPayer(Account payer) {
      this.payer = payer;
   }

   public Account getBeneficiary() {
      return beneficiary;
   }

   public void setBeneficiary(Account beneficiary) {
      this.beneficiary = beneficiary;
   }

   public double getAmount() {
      return amount;
   }

   public void setAmount(double amount) {
      this.amount = amount;
   }

   public String getVariableSym() {
      return variableSym;
   }

   public void setVariableSym(String variableSym) {
      this.variableSym = variableSym;
   }

   public String getSpecificSym() {
      return specificSym;
   }

   public void setSpecificSym(String specificSym) {
      this.specificSym = specificSym;
   }

   public String getConstantSym() {
      return constantSym;
   }

   public void setConstantSym(String constantSym) {
      this.constantSym = constantSym;
   }

   public String getInformationForBeneficiary() {
      return informationForBeneficiary;
   }

   public void setInformationForBeneficiary(String informationForBeneficiary) {
      this.informationForBeneficiary = informationForBeneficiary;
   }

   public Date getDoneAt() {
      return doneAt;
   }

   public void setDoneAt(Date doneAt) {
      this.doneAt = doneAt;
   }

   @Override
   public String toString() {
      return "Payment{" +
              "paymentId=" + paymentId +
              ", payer=" + payer +
              ", beneficiary=" + beneficiary +
              ", amount=" + amount +
              ", variableSym='" + variableSym + '\'' +
              ", specificSym='" + specificSym + '\'' +
              ", constantSym='" + constantSym + '\'' +
              ", informationForBeneficiary='" + informationForBeneficiary + '\'' +
              ", doneAt=" + doneAt +
              '}';
   }
}
