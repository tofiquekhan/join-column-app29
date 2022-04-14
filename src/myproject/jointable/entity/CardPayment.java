package myproject.jointable.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "card_payment")
@PrimaryKeyJoinColumn(name = "txId")
public class CardPayment extends Payment{

	@Column
	private int cardNo;
	@Column
	private String exrDate;
	@Column
	public int getCardNo() {
		return cardNo;
	}
	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}
	public String getExrDate() {
		return exrDate;
	}
	public void setExrDate(String exrDate) {
		this.exrDate = exrDate;
	}
	
	
	
}
