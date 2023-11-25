package com.example.sd18204.repository;

import com.example.sd18204.entity.SinhVien;
import com.example.sd18204.entity.SinhVienCus;
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


    public ArrayList<SinhVienCus> getListcus() {
        ArrayList<SinhVienCus> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "select new com.example.sd18204.entity.SinhVienCus(s.hoTen,l.tenLop) " +
                    " from com.example.sd18204.entity.SinhVien s" +
                    " join com.example.sd18204.entity.LopHoc l " +
                    " On s.lop.id = l.id";

            Query query = session.createQuery(hql);
            list = (ArrayList<SinhVienCus>) query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        SinhVienRepository sinhVienRepository = new SinhVienRepository();
        ArrayList<SinhVien> list = new ArrayList<>();
        list = sinhVienRepository.getList();
        for (SinhVien sinhVien : list) {
            System.out.println(sinhVien.getHoTen() + " - " + sinhVien.getLop().getTenLop());
        }
        System.out.println("=========");
        ArrayList<SinhVienCus> x = sinhVienRepository.getListcus();
        for (SinhVienCus sinhVienCus: x){
            System.out.println(sinhVienCus.toString());
        }
    }
}
