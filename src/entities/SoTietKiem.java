
package entities;


import java.io.Serializable;

public class SoTietKiem implements Serializable{
    private int maKhachHang;
    private int maNganHang;    
    private int soThangGui;
    private String ngayGui;

    public SoTietKiem() {
    }

    public SoTietKiem(int maKhachHang, int maNganHang, int soThangGui, String ngayGui) {
        this.maKhachHang = maKhachHang;
        this.maNganHang = maNganHang;
        this.soThangGui = soThangGui;
        this.ngayGui = ngayGui;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public int getMaNganHang() {
        return maNganHang;
    }

    public void setMaNganHang(int maNganHang) {
        this.maNganHang = maNganHang;
    }

    public int getSoThangGui() {
        return soThangGui;
    }

    public void setSoThangGui(int soThangGui) {
        this.soThangGui = soThangGui;
    }

    public String getNgayGui() {
        return ngayGui;
    }

    public void setNgayGui(String ngayGui) {
        this.ngayGui = ngayGui;
    }

    
    
}
