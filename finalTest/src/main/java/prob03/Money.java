package prob03;

import java.util.Objects;

public class Money {
	private int amount;

	/* 코드 작성 */
	
	public Money(int amount) {
		this.amount = amount;
	}
	
	public Money add(Money money) {
		int result = amount+money.getAmount();
		Money mon = new Money(result);
		return mon;
	}
	
	
	public Money minus(Money money) {
		int result = amount-money.getAmount();
		Money mon = new Money(result);
		return mon;
	}
	
	public Money multiply(Money money) {
		int result = amount*money.getAmount();
		Money mon = new Money(result);
		return mon;
	}
	
	public Money devide(Money money) {
		int result = amount/money.getAmount();
		Money mon = new Money(result);
		return mon;
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		return amount == other.amount;
	}

	
}
