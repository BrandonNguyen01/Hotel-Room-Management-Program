package QLKS_OBJECT;

public class KhachHang {
	private String MAKH;
	private String TENKH;
	private String CCCD;
	private String QUOCTICH;
	private String GIOITINH;
	private int tuoi;
	private String SDT;
	private String MAPHONG;
	
	// khoi tao mac dinh
	public KhachHang(String MAKH, String TENKH, String CCCD, String QUOCTICH, String GioiTinh, int tuoi, String SDT, String MAPHONG) {
		
        this.MAKH = MAKH;
        this.TENKH = TENKH;
        this.CCCD = CCCD;
        this.QUOCTICH = QUOCTICH;
        this.GIOITINH = GIOITINH;
        this.tuoi = tuoi;
        this.SDT = SDT;
        this.MAPHONG = MAPHONG;
	}
	KhachHang(String string, String string0, String string1, String string2, String string3, int aInt, String string4) {
        throw new UnsupportedOperationException("Chưa được hỗ trợ."); 
    }
	
	// getter va setter
	public String getMAKH() {
		return MAKH;
	}
	public void setMAKH(String mAKH) {
		MAKH = mAKH;
	}
	public String getTENKH() {
		return TENKH;
	}
	public void setTENKH(String tENKH) {
		TENKH = tENKH;
	}
	public String getCCCD() {
		return CCCD;
	}
	public void setCCCD(String cCCD) {
		CCCD = cCCD;
	}
	public String getQUOCTICH() {
		return QUOCTICH;
	}
	public void setQUOCTICH(String qUOCTICH) {
		QUOCTICH = qUOCTICH;
	}
	public String getGIOITINH() {
		return GIOITINH;
	}
	public void setGIOITINH(String gIOITINH) {
		GIOITINH = gIOITINH;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getMAPHONG() {
		return MAPHONG;
	}
	public void setMAPHONG(String mAPHONG) {
		MAPHONG = mAPHONG;
	}
	
	@Override
    public String toString() {
        return "khachHang{" + "MAKH=" + MAKH + ", TENKH=" + TENKH + ", CCCD=" + CCCD + ", QUOCTICH=" + QUOCTICH + ", GIOITINH=" + GIOITINH + ", tuoi=" + tuoi + ", SDT=" + SDT + ", MAPHONG=" + MAPHONG + '}';
    }
}
