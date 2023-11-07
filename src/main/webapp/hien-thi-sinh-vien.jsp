<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 02/11/2023
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<form>
    <div class="mb-3">
        <label class="form-label">ID</label>
        <input type="text" class="form-control">
    </div>
    <div class="mb-3">
        <label class="form-label">Ma</label>
        <input type="text" class="form-control">
    </div>
    <div class="mb-3">
        <label class="form-label">Ho Ten</label>
        <input type="text" class="form-control">
    </div>
    <div class="mb-3">
        <label class="form-label">Lop</label>
        <select class="form-select" aria-label="Default select example">
            <option selected>Open this select menu</option>
            <option value="1">One</option>
            <option value="2">Two</option>
            <option value="3">Three</option>
        </select>
    </div>
    <div class="mb-3">
        <label class="form-label">Giới tính</label>
        <br>
        <input type="radio" id="contactChoice1" name="contact" value="Nam" />
        <label for="contactChoice1">Nam</label>

        <input type="radio" id="contactChoice2" name="contact" value="Nu" />
        <label for="contactChoice2">Nu</label>
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<p>Danh sach sinh vien</p>
<table class="table">
    <thead>
    <tr>
        <td>STT</td>
        <td>ID</td>
        <td>Ma</td>
        <td>Ho ten</td>
        <td>Lop</td>
        <td>Gioi Tinh</td>
        <td>Action</td>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="i" items="${listSinhVien}" varStatus="sinhVien">
        <tr>
            <td>${sinhVien.index}</td>
            <td>${i.id}</td>
            <td>${i.ma}</td>
            <td>${i.hoTen}</td>
            <td>${i.lop}</td>
            <td>${i.gioiTinh}</td>
            <td>
                <a href="#" class="btn btn-primary">Xoa</a>
                <a href="#" class="btn btn-primary">Detail</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
