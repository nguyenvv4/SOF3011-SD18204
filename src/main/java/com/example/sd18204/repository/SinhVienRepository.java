package com.example.sd18204.repository;

import com.example.sd18204.entity.SinhVien;
import com.example.sd18204.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;

public class SinhVienRepository {

    public ArrayList<SinhVien> getList() {
        ArrayList<SinhVien> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            list = (ArrayList<SinhVien>) session.createQuery("from SinhVien").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
