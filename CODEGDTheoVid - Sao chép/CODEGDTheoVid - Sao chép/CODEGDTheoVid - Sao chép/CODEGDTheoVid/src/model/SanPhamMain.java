package model;

public class SanPhamMain {

    private int IDSANPHAM, IDSANPHAMCHITIET;
    private String TENSANPHAM, DOTOHUONG, LUUHUONG, XUATXU, NONGDO, NHOMHUONG;
    private int SOLUONG;
    private double GIA;
    private int TRANGTHAI;

    public SanPhamMain() {
    }

    public SanPhamMain(int IDSANPHAM, int IDSANPHAMCHITIET, String TENSANPHAM, String DOTOHUONG, String LUUHUONG, String XUATXU, String NONGDO, String NHOMHUONG, int SOLUONG, double GIA, int TRANGTHAI) {
        this.IDSANPHAM = IDSANPHAM;
        this.IDSANPHAMCHITIET = IDSANPHAMCHITIET;
        this.TENSANPHAM = TENSANPHAM;
        this.DOTOHUONG = DOTOHUONG;
        this.LUUHUONG = LUUHUONG;
        this.XUATXU = XUATXU;
        this.NONGDO = NONGDO;
        this.NHOMHUONG = NHOMHUONG;
        this.SOLUONG = SOLUONG;
        this.GIA = GIA;
        this.TRANGTHAI = TRANGTHAI;
    }

    public int getIDSANPHAM() {
        return IDSANPHAM;
    }

    public void setIDSANPHAM(int IDSANPHAM) {
        this.IDSANPHAM = IDSANPHAM;
    }

    public int getIDSANPHAMCHITIET() {
        return IDSANPHAMCHITIET;
    }

    public void setIDSANPHAMCHITIET(int IDSANPHAMCHITIET) {
        this.IDSANPHAMCHITIET = IDSANPHAMCHITIET;
    }

    public String getTENSANPHAM() {
        return TENSANPHAM;
    }

    public void setTENSANPHAM(String TENSANPHAM) {
        this.TENSANPHAM = TENSANPHAM;
    }

    public String getDOTOHUONG() {
        return DOTOHUONG;
    }

    public void setDOTOHUONG(String DOTOHUONG) {
        this.DOTOHUONG = DOTOHUONG;
    }

    public String getLUUHUONG() {
        return LUUHUONG;
    }

    public void setLUUHUONG(String LUUHUONG) {
        this.LUUHUONG = LUUHUONG;
    }

    public String getXUATXU() {
        return XUATXU;
    }

    public void setXUATXU(String XUATXU) {
        this.XUATXU = XUATXU;
    }

    public String getNONGDO() {
        return NONGDO;
    }

    public void setNONGDO(String NONGDO) {
        this.NONGDO = NONGDO;
    }

    public String getNHOMHUONG() {
        return NHOMHUONG;
    }

    public void setNHOMHUONG(String NHOMHUONG) {
        this.NHOMHUONG = NHOMHUONG;
    }

    public int getSOLUONG() {
        return SOLUONG;
    }

    public void setSOLUONG(int SOLUONG) {
        this.SOLUONG = SOLUONG;
    }

    public double getGIA() {
        return GIA;
    }

    public void setGIA(double GIA) {
        this.GIA = GIA;
    }

    public int getTRANGTHAI() {
        return TRANGTHAI;
    }

    public void setTRANGTHAI(int TRANGTHAI) {
        this.TRANGTHAI = TRANGTHAI;
    }
    


    public Object[] fillToRow() {
        return new Object[]{TENSANPHAM, DOTOHUONG, LUUHUONG, XUATXU, NONGDO, NHOMHUONG, SOLUONG, GIA};
    }
        
    public Object[] fillToRow2(){
        String tt="";
        if(TRANGTHAI==0){
            tt="Hết hàng";
        }else{
            tt="Còn hàng";
        }
        return new Object[]{TENSANPHAM, DOTOHUONG, LUUHUONG, XUATXU, NONGDO, NHOMHUONG, SOLUONG, GIA,tt};
    }
}

