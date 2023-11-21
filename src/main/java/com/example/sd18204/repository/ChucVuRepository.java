package com.example.sd18204.repository;

import com.example.sd18204.entity.ChucVu;
import com.example.sd18204.entity.SinhVien;
import com.example.sd18204.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class ChucVuRepository {
    public ArrayList<ChucVu> getList() {
        ArrayList<ChucVu> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            list = (ArrayList<ChucVu>) session.createQuery("from ChucVu").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void addNew(ChucVu chucVu) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(chucVu);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public static void main(String[] args) {
        ChucVu chucVu = new ChucVu();
        chucVu.setTen("Truong Phong");
        chucVu.setMa("TP");
        new ChucVuRepository().addNew(chucVu);
    }
}
