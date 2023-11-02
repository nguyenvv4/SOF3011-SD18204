package com.example.sd18204.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NhanVien {

    private String id;

    private String maNhanVien;

    private String hoTen;

    private String phongBan;

    private String gioiTinh;

    private String trangThai;

    private Integer namSinh;

    private Long luong;
}
