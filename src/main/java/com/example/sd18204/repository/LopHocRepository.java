package com.example.sd18204.repository;

import com.example.sd18204.entity.ChucVu;
import com.example.sd18204.entity.LopHoc;
import com.example.sd18204.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;

public class LopHocRepository {

    public ArrayList<LopHoc> getList() {
        ArrayList<LopHoc> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            list = (ArrayList<LopHoc>) session.createQuery("from LopHoc").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
