package com.example.sd18204.service;

import com.example.sd18204.entity.LopHoc;
import com.example.sd18204.repository.LopHocRepository;

import java.util.ArrayList;

public class LopHocService {

    LopHocRepository lopHocRepository = new LopHocRepository();
    public ArrayList<LopHoc> getList(){
        return lopHocRepository.getList();
    }
}
