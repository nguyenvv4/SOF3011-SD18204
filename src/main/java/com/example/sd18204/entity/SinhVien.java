package com.example.sd18204.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SinhVien {

    private String id;

    private String ma;

    private String hoTen;

    private String lop;

    private String gioiTinh;

    private Integer namSinh;

    private String trangThai;

    private String diaChi;
}
