package com.example.sd18204.service;

import com.example.sd18204.entity.SinhVien;
import com.example.sd18204.repository.SinhVienRepository;

import java.util.ArrayList;

public class SinhVienService {
    // service => repo
    SinhVienRepository sinhVienRepository = new SinhVienRepository();

    public ArrayList<SinhVien> getAll() {
        return sinhVienRepository.getList();
    }

    public void addNew(SinhVien sinhVien) {
        sinhVienRepository.addNew(sinhVien);
    }

    public void update(SinhVien sinhVien) {
        sinhVienRepository.update(sinhVien);
    }

    public SinhVien detail(Integer id){
        return sinhVienRepository.getById(id);
    }
}
