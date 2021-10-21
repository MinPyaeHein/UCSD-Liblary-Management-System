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
            <h1>Book Registration Data</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Admin Home</a></li>
              <li class="breadcrumb-item active">Book Detail</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
       	  <div class="col-md-4">
            <!-- Widget: user widget style 2 -->
            <div class="card card-widget widget-user-2">
              <!-- Add the bg color to the header using any of the bg-* classes -->
              <div class="widget-user-header bg-warning">
                <div class="widget-user-image">
                <img class="img-circle elevation-2" src="bgimageUploadPath?frmImageId=${bookForm.bookId}&frmType=book" alt="User Avatar">
                </div>
                <!-- /.widget-user-image -->
                <h3 class="widget-user-username">Book Id::${bookForm.bookId}</h3>
                <h3 class="widget-user-username">Book Name::${bookForm.bookName}</h3>
 
              </div>
              <div class="card-footer p-0">
                <ul class="nav flex-column">
                  <li class="nav-item">
                    <a href="#" class="nav-link">
                   Edition Name :: ${bookForm.editionName}
                     </a>
                  </li>
                    <li class="nav-item">
                    <a href="#" class="nav-link">
                   Publisher Date :: ${bookForm.publisherDate}
                     </a>
                  </li>
                    <li class="nav-item">
                    <a href="#" class="nav-link">
                   Create Date :: ${bookForm.createDate}
                     </a>
                  </li>
                    <li class="nav-item">
                    <a href="#" class="nav-link">
                    ISBN :: ${bookForm.isbn}
                     </a>
                  </li>
                    <li class="nav-item">
                    <a href="#" class="nav-link">
                    Qty :: ${bookForm.qty}
                     </a>
                  </li>
                    <li class="nav-item">
                    <a href="#" class="nav-link">
                    Group Id :: ${bookGroupForm.bookGroupId}
                     </a>
                  </li>
                   <li class="nav-item">
                    <a href="#" class="nav-link">
                    Group Name :: ${bookGroupForm.groupName}
                     </a>
                  </li>
                    <li class="nav-item">
                    <a href="#" class="nav-link">
                    Group Code :: ${bookGroupForm.groupCode}
                     </a>
                  </li>
                 <li class="nav-item">
                 <form:form action="saveBookConfrimSubmitPath">
           
             
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
              <input type="submit" name="cancle"
             class="btn btn-block bg-gradient-primary btn-m" value="Cancel"/>
             </div>
            </div>
 			</form:form> 
                  </li>
                </ul>
              </div>
            </div>
            <!-- /.widget-user -->
           
          </div>

        <section class="content">
      <div class="row">
      <div class="col-15">
        
              <div class="card card-success">
                <div class="card-header">
                <h3 class="card-title">Book Type</h3>
              </div>
              <div class="card-body">
              <table id="example1" class="table table-bordered table-striped">
              <thead>
           <tr>
			<th>No</th>
			<th>Type Id</th>
			<th>Type Name</th>
			<th>Type Code</th>
			<th>Delete Type</th>
		   </tr>
                </thead>
                <tbody>
           <c:forEach var="at" items="${typeForms}" varStatus="s">
			<tr>
				<td>${s.index+1}</td>
				<td>${at.typeId}</td>
				<td>${at.typeName}</td>
				<td>${at.typeCode}</td>
				<td><a href="sbcDeleteBookTypeSubmitPath?frmTypeId=${at.typeId}" class="btn btn-block btn-outline-primary btn-sm">Delete</a></td>
			</tr>		
		</c:forEach>	
                </tbody>
                <tfoot>
                </tfoot>
              </table>
            </div>
            
            <!-- /.card-body -->
          </div>
          <!-- /.card -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
       <section class="content">
      <div class="row">
      <div class="col-15">
        
            <div class="card card-success">
                <div class="card-header">
                <h3 class="card-title">Book Author</h3>
              </div>
            <div class="card-body">
              <table id="example1" class="table table-bordered table-striped">
              <thead>
           <tr>
			<th>No</th>
			<th>Author Id</th>
			<th>Author Name</th>
			<th>Delete Author</th>
		   </tr>
           </thead>
           <tbody>
           <c:forEach var="at" items="${authorForms}" varStatus="s">
			<tr>
				<td>${s.index+1}</td>
				<td>${at.authorId}</td>
				<td>${at.authorName}</td>
				<td><a href="sbcDeleteBookAuthorSubmitPath?frmAuthorId=${at.authorId}" class="btn btn-block btn-outline-primary btn-sm">Delete</a></td>
			</tr>		
		    </c:forEach>	
                </tbody>
                <tfoot>
                </tfoot>
              </table>
            </div>
            <!-- /.card-body -->
          </div>
          <!-- /.card -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
        <section class="content">
      <div class="row">
      <div class="col-15">
        
           <div class="card card-success">
                <div class="card-header">
                <h3 class="card-title">Book Shell</h3>
              </div>
        <div class="card-body">
              <table id="example1" class="table table-bordered table-striped">
              <thead>
           <tr>
			<th>No</th>
			<th>Shell Id</th>
			<th>Shell No</th>
			<th>Delete shell</th>
		   </tr>
                </thead>
                <tbody>
           <c:forEach var="at" items="${shellForms}" varStatus="s">
			<tr>
				<td>${s.index+1}</td>
				<td>${at.shellId}</td>
				<td>${at.shellNo}</td>
				<td><a href="sbcDeleteBookShellSubmitPath?frmShellId=${at.shellId}" class="btn btn-block btn-outline-primary btn-sm">Delete</a></td>
			</tr>		
		    </c:forEach>	
                </tbody>
                <tfoot>
                </tfoot>
              </table>
            </div>
         
          </div>
          <!-- /.card -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    </section>
    <!-- /.content -->
   
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
<script src="<c:url value="resources/admin/plugins/datatables/jquery.dataTables.js"/>"></script>
<script src="<c:url value="resources/admin/plugins/datatables-bs4/js/dataTables.bootstrap4.js"/>"></script>
<script>
  $(function () {
    $("#example1").DataTable();
    $('#example2').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": true,
      "autoWidth": false,
    });
  });
</script>
</body>
</html>
