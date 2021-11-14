package QLKS_OBJECT;

import java.sql.Date;

public class HoaDon {
	private String MAHD;
	private String MANV;
	private String MAPHONG;
	private Date NGAY;
	private double GIAHD;
	
	// khoi tao mac dinh
	public HoaDon(String MAHD, String MANV, String MAPHONG, Date NGAY, double GIAHD) {
		 this.MAHD = MAHD;
	     this.MANV = MANV;
	     this.MAPHONG = MAPHONG;
	     this.NGAY = NGAY;
	     this.GIAHD = GIAHD;
	}
	public HoaDon()
	{
		
	}
	public String getMAHD() {
		return MAHD;
	}
	public void setMAHD(String mAHD) {
		MAHD = mAHD;
	}
	public String getMANV() {
		return MANV;
	}
	public void setMANV(String mANV) {
		MANV = mANV;
	}
	public String getMAPHONG() {
		return MAPHONG;
	}
	public void setMAPHONG(String mAPHONG) {
		MAPHONG = mAPHONG;
	}
	public Date getNGAY() {
		return NGAY;
	}
	public void setNGAY(Date nGAY) {
		NGAY = nGAY;
	}
	public double getGIAHD() {
		return GIAHD;
	}
	public void setGIAHD(double gIAHD) {
		GIAHD = gIAHD;
	}
	
	@Override
    public String toString() {
        return "HoaDon{" + "MAHD=" + MAHD + ", MANV=" + MANV + ", MAPHONG=" + MAPHONG + ", NGAY=" + NGAY + ", GIAHD=" + GIAHD + '}';
    }
    
}
