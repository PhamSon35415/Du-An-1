/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author duck1
 */
public class XuatXu {
   private int IDXUATXU;
   private String TENXUATXU;
    private Date NGAYTAO;
    private Date NGAYSUA;
    private int TRANGTHAI;

    public XuatXu() {
    }

    public XuatXu(int IDXUATXU, String TENXUATXU, Date NGAYTAO, Date NGAYSUA, int TRANGTHAI) {
        this.IDXUATXU = IDXUATXU;
        this.TENXUATXU = TENXUATXU;
        this.NGAYTAO = NGAYTAO;
        this.NGAYSUA = NGAYSUA;
        this.TRANGTHAI = TRANGTHAI;
    }

    public int getIDXUATXU() {
        return IDXUATXU;
    }

    public void setIDXUATXU(int IDXUATXU) {
        this.IDXUATXU = IDXUATXU;
    }

    public String getTENXUATXU() {
        return TENXUATXU;
    }

    public void setTENXUATXU(String TENXUATXU) {
        this.TENXUATXU = TENXUATXU;
    }

    public Date getNGAYTAO() {
        return NGAYTAO;
    }

    public void setNGAYTAO(Date NGAYTAO) {
        this.NGAYTAO = NGAYTAO;
    }

    public Date getNGAYSUA() {
        return NGAYSUA;
    }

    public void setNGAYSUA(Date NGAYSUA) {
        this.NGAYSUA = NGAYSUA;
    }

    public int getTRANGTHAI() {
        return TRANGTHAI;
    }

    public void setTRANGTHAI(int TRANGTHAI) {
        this.TRANGTHAI = TRANGTHAI;
    }
   
}
