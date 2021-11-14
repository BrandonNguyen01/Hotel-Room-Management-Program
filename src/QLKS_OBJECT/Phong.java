package QLKS_OBJECT;

public class Phong {
    private String MAPHONG;
    private String TENPHONG;
    private String LOAIPHONG;
    private double GIAPHONG;
    private String CHUTHICH;
    private String TINHTRANG;
    private String MANV;
    private String MADV;
    
    public Phong(String MAPHONG, String TENPHONG, String LOAIPHONG, double GIAPHONG, String CHUTHICH, String TINHTRANG, String MANV, String MADV) {
        this.MAPHONG = MAPHONG;
        this.TENPHONG = TENPHONG;
        this.LOAIPHONG = LOAIPHONG;
        this.GIAPHONG = GIAPHONG;
        this.CHUTHICH = CHUTHICH;
        this.TINHTRANG = TINHTRANG;
        this.MANV = MANV;
        this.MADV = MADV;
    }

    public Phong() {
    }

	public String getMAPHONG() {
		return MAPHONG;
	}

	public void setMAPHONG(String mAPHONG) {
		MAPHONG = mAPHONG;
	}

	public String getTENPHONG() {
		return TENPHONG;
	}

	public void setTENPHONG(String tENPHONG) {
		TENPHONG = tENPHONG;
	}

	public String getLOAIPHONG() {
		return LOAIPHONG;
	}

	public void setLOAIPHONG(String lOAIPHONG) {
		LOAIPHONG = lOAIPHONG;
	}

	public double getGIAPHONG() {
		return GIAPHONG;
	}

	public void setGIAPHONG(double gIAPHONG) {
		GIAPHONG = gIAPHONG;
	}

	public String getCHUTHICH() {
		return CHUTHICH;
	}

	public void setCHUTHICH(String cHUTHICH) {
		CHUTHICH = cHUTHICH;
	}

	public String getTINHTRANG() {
		return TINHTRANG;
	}

	public void setTINHTRANG(String tINHTRANG) {
		TINHTRANG = tINHTRANG;
	}

	public String getMANV() {
		return MANV;
	}

	public void setMANV(String mANV) {
		MANV = mANV;
	}

	public String getMADV() {
		return MADV;
	}

	public void setMADV(String mADV) {
		MADV = mADV;
	}
    
	@Override
    public String toString() {
        return "Phong{" + "MAPHONG=" + MAPHONG + ", TENPHONG=" + TENPHONG + ", LOAIPHONG=" + LOAIPHONG + ", GIAPHONG=" + GIAPHONG + ", CHUTHICH=" + CHUTHICH + ", TINHTRANG=" + TINHTRANG + ", MANV=" + MANV + ", MADV=" + MADV + '}';
    }
}
