package com.example.sd18204.entity;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SinhVienViewModel {
    private String hoTen;

    private Integer lop;
    private String gioiTinh;

    @Override
    public String toString() {
        return "SinhVienViewModel{" +
                "hoTen='" + hoTen + '\'' +
                ", lop=" + lop +
                ", gioiTinh='" + gioiTinh + '\'' +
                '}';
    }
}
