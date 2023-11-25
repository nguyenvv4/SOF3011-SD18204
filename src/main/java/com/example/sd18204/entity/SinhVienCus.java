package com.example.sd18204.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SinhVienCus {

    private String hoTen;

    private String tenLop;

    @Override
    public String toString() {
        return "SinhVienCus{" +
                "hoTen='" + hoTen + '\'' +
                ", tenLop='" + tenLop + '\'' +
                '}';
    }
}
