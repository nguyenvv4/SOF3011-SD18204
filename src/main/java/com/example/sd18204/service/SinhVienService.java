package com.example.sd18204.service;

import com.example.sd18204.entity.SinhVien;
import com.example.sd18204.repository.SinhVienRepository;

import java.util.ArrayList;

public class SinhVienService {
    // service => repo
    SinhVienRepository sinhVienRepository= new SinhVienRepository();
    public ArrayList<SinhVien> getAll(){
        return sinhVienRepository.getList();
    }
}
