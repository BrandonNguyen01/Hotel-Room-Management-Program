package QLKS_OBJECT;

import java.util.Date;

public class NhanVien {
    private String MANV;
    private String TENNV;
    private String CHUCVU;
    private double LUONGNV;
    private Date NGAYSINH;
    private String GIOITINH;
    private String CHUTHICH;
    
    // khoi tao mac dinh
    public NhanVien(String MANV, String TENNV, String CHUCVU, double LUONGNV, Date NGAYSINH, String GIOITINH, String CHUTHICH) {
        this.MANV = MANV;
        this.TENNV = TENNV;
        this.CHUCVU = CHUCVU;
        this.LUONGNV = LUONGNV;
        this.NGAYSINH = NGAYSINH;
        this.GIOITINH = GIOITINH;
        this.CHUTHICH = CHUTHICH;
    }

    public NhanVien() {
    }

	public String getMANV() {
		return MANV;
	}

	public void setMANV(String mANV) {
		MANV = mANV;
	}

	public String getTENNV() {
		return TENNV;
	}

	public void setTENNV(String tENNV) {
		TENNV = tENNV;
	}

	public String getCHUCVU() {
		return CHUCVU;
	}

	public void setCHUCVU(String cHUCVU) {
		CHUCVU = cHUCVU;
	}

	public double getLUONGNV() {
		return LUONGNV;
	}

	public void setLUONGNV(double lUONGNV) {
		LUONGNV = lUONGNV;
	}

	public Date getNGAYSINH() {
		return NGAYSINH;
	}

	public void setNGAYSINH(Date nGAYSINH) {
		NGAYSINH = nGAYSINH;
	}

	public String getGIOITINH() {
		return GIOITINH;
	}

	public void setGIOITINH(String gIOITINH) {
		GIOITINH = gIOITINH;
	}

	public String getCHUTHICH() {
		return CHUTHICH;
	}

	public void setCHUTHICH(String cHUTHICH) {
		CHUTHICH = cHUTHICH;
	}

	 @Override
	    public String toString() {
	        return "NhanVien{" + "MANV=" + MANV + ", TENNV=" + TENNV + ", CHUCVU=" + CHUCVU + ", LUONGNV=" + LUONGNV + ", NGAYSINH=" + NGAYSINH + ", GIOITINH=" + GIOITINH + ", CHUTHICH=" + CHUTHICH + '}';
	    }
}
