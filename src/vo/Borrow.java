package vo;

public class Borrow {
	private  int borrowid;
	private String isbn;
	private String readerno;
	private String readername;
	private String borrowdate;
	private String backdate;
	private String renew;
	private String orderdate; 
	private String bookname;
	private String casename;
	private int countnum;
	
	public int getCountnum() {
		return countnum;
	}
	public void setCountnum(int countnum) {
		this.countnum = countnum;
	}
	public String getCasename() {
		return casename;
	}
	public void setCasename(String casename) {
		this.casename = casename;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public int getBorrowid() {
		return borrowid;
	}
	public void setBorrowid(int borrowid) {
		this.borrowid = borrowid;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getReaderno() {
		return readerno;
	}
	public void setReaderno(String readerno) {
		this.readerno = readerno;
	}
	public String getReadername() {
		return readername;
	}
	public void setReadername(String readername) {
		this.readername = readername;
	}
	public String getBorrowdate() {
		return borrowdate;
	}
	public void setBorrowdate(String borrowdate) {
		this.borrowdate = borrowdate;
	}
	public String getBackdate() {
		return backdate;
	}
	public void setBackdate(String backdate) {
		this.backdate = backdate;
	}
	public String getRenew() {
		return renew;
	}
	public void setRenew(String renew) {
		this.renew = renew;
	}
	
}
