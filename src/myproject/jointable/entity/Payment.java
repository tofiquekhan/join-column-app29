package myproject.jointable.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
@Inheritance(strategy = InheritanceType.JOINED)
public class Payment {

	@Id
	@Column
	private String txId;
	@Column
	private String payDate;
	@Column
	private int payAmt;
	
	public String getTxId() {
		return txId;
	}
	public void setTxId(String txId) {
		this.txId = txId;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public int getPayAmt() {
		return payAmt;
	}
	public void setPayAmt(int payAmt) {
		this.payAmt = payAmt;
	}
	
	
}
