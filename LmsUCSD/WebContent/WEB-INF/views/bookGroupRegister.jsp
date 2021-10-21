<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Computer University Dawei  | Library</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="<c:url value="resources/admin/plugins/fontawesome-free/css/all.min.css"/>">
  <!-- Ionicons -->
  <link rel="stylesheet" href="<c:url value="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"/>">
  <!-- Tempusdominus Bbootstrap 4 -->
  <link rel="stylesheet" href="<c:url value="resources/admin/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css"/>">
  <!-- iCheck -->
  <link rel="stylesheet" href="<c:url value="resources/admin/plugins/icheck-bootstrap/icheck-bootstrap.min.css"/>">
  <!-- JQVMap -->
  <link rel="stylesheet" href="<c:url value="resources/admin/plugins/jqvmap/jqvmap.min.css"/>">
  <!-- Theme style -->
  <link rel="stylesheet" href="<c:url value="resources/admin/dist/css/adminlte.min.css"/>">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="<c:url value="resources/admin/plugins/overlayScrollbars/css/OverlayScrollbars.min.css"/>">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="<c:url value="resources/admin/plugins/daterangepicker/daterangepicker.css"/>">
  <!-- summernote -->
  <link rel="stylesheet" href="<c:url value="resources/admin/plugins/summernote/summernote-bs4.css"/>">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">

 <%@ include file="/resources/admin/headerAndSlideBar/headerAndSlideBar.jsp" %>
  <div class="content-wrapper">
  <section class="content">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col">
          
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Admin Home</a></li>
              <li class="breadcrumb-item active">Book Group Register</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>
    <!-- Main content -->
      <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-6">
             <div class="card card-success">
              <div class="card-header">
              <h3 class="card-title">Book Group Register</h3>
              </div>
              <!-- /.card-header -->
             <div class="card-body">
             <div class="row">
        	<div class="col-md-6">
        	 <form:form action="bookGroupRegisterSubmitPath" modelAttribute="bookGroupRegisterForm.bookGroupForm" method="POST" enctype="multipart/form-data" >
        	
         	    <div class="form-group">
				Group Name :
                  <div class="input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text"><i class="far fa-calendar-alt"></i></span>
                    </div>
                 <form:input type="text" id="groupName" path="groupName" name="groupName"  class="form-control"  data-mask="data-mask" />
                  </div>
         		 </div>
         		 <div class="form-group">
				Group Code :
                  <div class="input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text"><i class="far fa-calendar-alt"></i></span>
                    </div>
                 <form:input type="text" id="groupCode" path="groupCode" name="groupCode"  class="form-control"  data-mask="data-mask" />
                  </div>
         		 </div>
              <div class="form-group">
	             <div class="input-group">
	             <div class="input-group-prepend">
                 <span></span>
                    </div>
              <input type="submit" name="save"
             class="btn btn-block bg-gradient-primary btn-m" value="Save"/>
             </div>
            </div>
              <div class="form-group">
	             <div class="input-group">
	             <div class="input-group-prepend">
                 <span></span>
                    </div>
              <input type="submit" name="finish"
             class="btn btn-block bg-gradient-primary btn-m" value="Finish"/>
             </div>
            </div>
            </form:form>
          </div>
		  </div>
		  </div> 
            </div>
            </div>
            <div class="col-15">
           <div class="card card-success">
                <div class="card-header">
                <h3 class="card-title">Library Book Groups</h3>
              </div>
            <div class="card-body">
              <table id="example1" class="table table-bordered table-striped">
                <thead>
               <tr>
			<th>No</th>
			<th>Book Group Id</th>
			<th>Book Group Name</th>
			<th>Group Code</th>
		    <th>Delete</th>
			<th>Update</th>
		       </tr>
                </thead>
                <tbody>
            <c:forEach var="at" items="${bookGroupRegisterForm.bookGroups}" varStatus="s">
			<tr>
				<td>${s.index+1}</td>
				<td>ID-${at.bookGroupId}</td>
				<td>${at.groupName}</td>
				<td>${at.groupCode}</td>
			    <td><a href="doctorDeletePath?frmDoctorId=${at.bookGroupId}"class="btn btn-block btn-outline-primary btn-sm">Delete</a></td>
				<td><a href="doctorUpdatePath?frmDoctorId=${at.bookGroupId}"class="btn btn-block btn-outline-primary btn-sm">Update</a></td>
			</tr>		
		    </c:forEach>
                </tbody>
                <tfoot>
             <tr>
			<th>No</th>
			<th>Book Group Id</th>
			<th>Book Group Name</th>
			<th>Group Code</th>
		    <th>Delete</th>
			<th>Update</th>
		       </tr>
                </tfoot>
              </table>
            </div>
            <!-- /.card-body -->
          </div>
          <!-- /.card -->
        </div>
            </div>

            </div>
            </section>
       
      </section>
  </div>
 <!-- /.content-wrapper -->
  <%@ include file="/resources/admin/footer/AdminFooter.jsp" %>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="<c:url value="resources/admin/plugins/jquery/jquery.min.js"/>"></script>
<!-- jQuery UI 1.11.4 -->
<script src="<c:url value="resources/admin/plugins/jquery-ui/jquery-ui.min.js"/>"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 4 -->
<script src="<c:url value="resources/admin/plugins/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
<!-- ChartJS -->
<script src="<c:url value="resources/admin/plugins/chart.js/Chart.min.js"/>"></script>
<!-- Sparkline -->
<script src="<c:url value="resources/admin/plugins/sparklines/sparkline.js"/>"></script>
<!-- JQVMap -->
<script src="<c:url value="resources/admin/plugins/jqvmap/jquery.vmap.min.js"/>"></script>
<script src="<c:url value="resources/admin/plugins/jqvmap/maps/jquery.vmap.usa.js"/>"></script>
<!-- jQuery Knob Chart -->
<script src="<c:url value="resources/admin/plugins/jquery-knob/jquery.knob.min.js"/>"></script>
<!-- daterangepicker -->
<script src="<c:url value="resources/admin/plugins/moment/moment.min.js"/>"></script>
<script src="<c:url value="resources/admin/plugins/daterangepicker/daterangepicker.js"/>"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="<c:url value="resources/admin/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"/>"></script>
<!-- Summernote -->
<script src="<c:url value="resources/admin/plugins/summernote/summernote-bs4.min.js"/>"></script>
<!-- overlayScrollbars -->
<script src="<c:url value="resources/admin/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"/>"></script>
<!-- AdminLTE App -->
<script src="<c:url value="resources/admin/dist/js/adminlte.js"/>"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="<c:url value="resources/admin/dist/js/pages/dashboard.js"/>"></script>
<!-- AdminLTE for demo purposes -->
<script src="<c:url value="resources/admin/dist/js/demo.js"/>"></script>
</body>
</html>
