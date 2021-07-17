
package entities;

import java.io.Serializable;

public class NganHang implements Serializable{
    private int ma;
    private String tenNH;
    private float laiSuat;

    public NganHang() {
    }

    public NganHang(int ma, String tenNH, float laiSuat) {
        this.ma = ma;
        this.tenNH = tenNH;
        this.laiSuat = laiSuat;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTenNH() {
        return tenNH;
    }

    public void setTenNH(String tenNH) {
        this.tenNH = tenNH;
    }

    public float getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(float laiSuat) {
        this.laiSuat = laiSuat;
    }

    
    
    public Object[] toObject() {
        return new Object[]{ma,tenNH,laiSuat
        };
        
    }
    
}
