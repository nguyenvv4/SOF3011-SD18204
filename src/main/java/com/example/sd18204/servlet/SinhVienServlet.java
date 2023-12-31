package com.example.sd18204.servlet;

import com.example.sd18204.entity.LopHoc;
import com.example.sd18204.entity.SinhVien;
import com.example.sd18204.entity.SinhVienViewModel;
import com.example.sd18204.service.LopHocService;
import com.example.sd18204.service.SinhVienService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi", // get
        "/sinh-vien/add",
        "/sinh-vien/update",
        "/sinh-vien/detail", //get
        "/sinh-vien/delete", //get
        "/sinh-vien/search", //post

})
public class SinhVienServlet extends HttpServlet {
    ArrayList<SinhVien> list = new ArrayList<>();

    ArrayList<String> lops = new ArrayList<>();
    // Servlet => Service => Repository
    SinhVienService sinhVienService = new SinhVienService();
    LopHocService lopHocService = new LopHocService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/hien-thi")) {
            this.getList(request, response);
        } else if (uri.contains("/detail")) {
            this.detail(request, response);
        } else if (uri.contains("/delete")) {
            this.delete(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer x = Integer.parseInt(request.getParameter("id"));
        sinhVienService.delete(x);
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        ArrayList<LopHoc> listLopHoc = lopHocService.getList();
        request.setAttribute("lops", listLopHoc);
        SinhVien sinhVienDetail = sinhVienService.detail(id);
        request.setAttribute("sinhVien", sinhVienDetail);
        request.getRequestDispatcher("/detail.jsp").forward(request, response);
    }

    private void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<LopHoc> listLopHoc = lopHocService.getList();
        request.setAttribute("lops", listLopHoc);

        // => thay the bằng service.getList()
        ArrayList<SinhVien> list = sinhVienService.getAll();
        request.setAttribute("listSinhVien", list);
        request.getRequestDispatcher("/hien-thi-sinh-vien.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            this.addNew(request, response);
        } else if (uri.contains("/update")) {
            this.update(request, response);
        } else if (uri.contains("/search")) {
            this.search(request, response);
        }


    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hoTen = request.getParameter("hoTen");
        ArrayList<LopHoc> listLopHoc = lopHocService.getList();
        ArrayList<SinhVien> list = sinhVienService.search(hoTen);
        request.setAttribute("lops", listLopHoc);
        request.setAttribute("listSinhVien", list);
        request.getRequestDispatcher("/hien-thi-sinh-vien.jsp").forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        Integer id = Integer.parseInt(request.getParameter("id"));
//        String ma = request.getParameter("ma");
//        String hoTen = request.getParameter("hoTen");
//        String lop = request.getParameter("lop");
//        String gioiTinh = request.getParameter("gioiTinh");


        // Tạo đối tượng sinh vieen từ thông tin vừa lấy được
        SinhVien sinhVien = new SinhVien();
//        sinhVien.setId(id);
//        sinhVien.setGioiTinh(gioiTinh);
//        sinhVien.setHoTen(hoTen);
//        LopHoc lopHoc = new LopHoc();
//        lopHoc.setId(Integer.parseInt(lop));
//        sinhVien.setLop(lopHoc);
        sinhVienService.update(sinhVien);
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void addNew(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // lấy thông tin trên form xuống
        SinhVienViewModel sinhVienViewModel = new SinhVienViewModel();
        SinhVien sinhVien = new SinhVien();
        try {
            BeanUtils.populate(sinhVienViewModel, request.getParameterMap());
            sinhVien.copyProperties(sinhVienViewModel);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        System.out.println("sinh vien la :" + sinhVien.toString());
        // Tạo đối tượng sinh vieen từ thông tin vừa lấy được

//        sinhVienService.addNew(sinhVien);

        response.sendRedirect("/sinh-vien/hien-thi");
    }
}
