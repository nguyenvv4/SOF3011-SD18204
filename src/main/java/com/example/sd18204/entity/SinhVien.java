package com.example.sd18204.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Students")
public class SinhVien {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten")
    private String hoTen;

    @ManyToOne
    @JoinColumn(name = "lop")
    private LopHoc lop;

    @Column(name = "gioiTinh")
    private String gioiTinh;

    @Column(name = "diaChi")
    private String diaChi;
    @Column(name = "chieuCao")
    private String chieuCao;
    @Column(name = "canNang")
    private String canNang;

    public void copyProperties(SinhVienViewModel sinhVienViewModel) {
        this.hoTen = sinhVienViewModel.getHoTen();
        this.gioiTinh = sinhVienViewModel.getGioiTinh();
        this.lop = new LopHoc(sinhVienViewModel.getLop(), "");
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "id=" + id +
                ", hoTen='" + hoTen + '\'' +
                ", lop=" + lop +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", chieuCao='" + chieuCao + '\'' +
                ", canNang='" + canNang + '\'' +
                '}';
    }
}
