package entities;
import java.io.Serializable;


public class KhachHang implements Serializable{
    private int ma;
    private String hoTen,diaChi,loaiKhachHang;

    public KhachHang() {
    }

    public KhachHang(int ma, String hoTen, String diaChi, String loaiKhachHang) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.loaiKhachHang = loaiKhachHang;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getLoaiKhachHang() {
        return loaiKhachHang;
    }

    public void setLoaiKhachHang(String loaiKhachHang) {
        this.loaiKhachHang = loaiKhachHang;
    }

    
    public Object[] toObject() {
        return new Object[]{ma,hoTen,diaChi,loaiKhachHang};
    }
    
}
