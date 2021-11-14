package QLKS_OBJECT;

public class DichVu {
	
	private String MADV;
	private String TENNVL;
	private double GIADV;
	
	
	// khoi tao mac dinh
	public DichVu(String MADV, String TENNVL, double GIADV) {
		
		this.MADV = MADV;
		this.TENNVL = TENNVL;
		this.GIADV = GIADV;
		
	}
	public DichVu() {}
	
	// getter va setter
	public String getMADV() {
		return MADV;
	}
	public void setMADV(String mADV) {
		MADV = mADV;
	}
	public String getTENNVL() {
		return TENNVL;
	}
	public void setTENNVL(String TENNVL) {
		TENNVL = TENNVL;
	}
	public double getGIADV() {
		return GIADV;
	}
	public void setGIADV(double gIADV) {
		GIADV = gIADV;
	}
	
    @Override
    public String toString() {
        return "DichVu{" + "MADV=" + MADV + ", TENNVL=" + TENNVL + ", GIADV=" + GIADV + '}';
    }
	
	
	
}
