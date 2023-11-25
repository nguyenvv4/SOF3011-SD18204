package com.example.sd18204.repository;

import com.example.sd18204.entity.SinhVien;
import com.example.sd18204.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class SinhVienRepository {

    public ArrayList<SinhVien> getList() {
        ArrayList<SinhVien> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from SinhVien");
            list = (ArrayList<SinhVien>) query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void addNew(SinhVien sinhVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(sinhVien);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(SinhVien sinhVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(sinhVien);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public SinhVien getById(Integer id) {
        SinhVien sinhVien = new SinhVien();

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from SinhVien where id=:id");
            query.setInteger("id", id);
            sinhVien = (SinhVien) query.getSingleResult();
            return sinhVien;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<SinhVien> searchByName(String hoTen) {
        ArrayList<SinhVien> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from SinhVien where hoTen like :hoTen");
            query.setParameter("hoTen", "%" + hoTen + "%");
            list = (ArrayList<SinhVien>) query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void delete(SinhVien sinhVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(sinhVien);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }
}
