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
            <h1>Add Book Author </h1>
            <h1>Your Selected Book Groups::</h1>
            <h3>${bookGroupForm.groupName}</h3>

          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Admin Home</a></li>
              <li class="breadcrumb-item active">Add Book Author</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>
       <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-6">
             <div class="card card-success">
              <div class="card-header">
              <h3 class="card-title">Add New Author</h3>
              </div>
              <!-- /.card-header -->
          <div class="card-body">
          <form:form action="authorRegisterSubmitPath" modelAttribute="authorRegisterForm.authorForm" method="POST" enctype="multipart/form-data" >
         
                <div class="row">
        	    <div class="col-md-6">
        	    
        	     <div class="form-group">
				Author Name :
                  <div class="input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text"><i class="far fa-calendar-alt"></i></span>
                    </div>
                 <form:input type="text" id="authorName" path="authorName" name="authorName"  class="form-control"  data-mask="data-mask"  />
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
              <input type="submit" name="exit"
             class="btn btn-block bg-gradient-primary btn-m" value="Exit"/>
             </div>
            </div>
          </div>
	    </div>
		
            </form:form>
            </div>
            </div>
            </div>
            
            <div class="col-15">
           <div class="card card-success">
                <div class="card-header">
                <h3 class="card-title">Liblary Author</h3>
              </div>
            <div class="card-body">
          
              <table id="example1" class="table table-bordered table-striped">
              <thead>
            <tr>
			<th>No</th>
			<th>Author Id</th>
			<th>Author Name</th>
			<th>Select Author</th>
		    </tr>
               </thead>
               <tbody>
            <c:forEach var="at" items="${authorRegisterForm.authors}" varStatus="s">
			<tr>
				<td>${s.index+1}</td>
				<td>${at.authorId}</td>
				<td>${at.authorName}</td>
				<td><a class="btn btn-block btn-outline-primary btn-sm" href="addBookAuthorSubmitPath?frmAuthorId=${at.authorId}&frmAuthorName=${at.authorName}">Add</a></td>
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
      
        
        
            
             <div class="col-15">
           <div class="card card-success">
                <div class="card-header">
                <h3 class="card-title">Book Author(${bookForm.bookName})</h3>
              </div>
              <div class="card-body">
                <table id="example1" class="table table-bordered table-striped">
                <thead>
            <tr>
			<th>No</th>
			<th>Author Id</th>
			<th>Author Name</th>
			<th>Select Author</th>
		    </tr>
                </thead>
                <tbody>
           <c:forEach var="at" items="${authorForms}" varStatus="s">
			<tr>
				<td>${s.index+1}</td>
				<td>${at.authorId}</td>
				<td>${at.authorName}</td>
				<td><a class="btn btn-block btn-outline-primary btn-sm"  href="deleteBookAuthorSubmitPath?frmAuthorId=${at.authorId}">delete</a></td>
			</tr>		
		   </c:forEach>
              
                </tbody>
                <tfoot>
                </tfoot>
              </table>
            </div>
            
              <div class="card-body">
          <form:form action="goToBookShellPath"  method="POST" enctype="multipart/form-data" >
              <div class="card-body">
                <div class="row">
        	    <div class="col-md-6">
                 <div class="form-group">
	             <div class="input-group">
	             <div class="input-group-prepend">
                 <span></span>
                </div>
              <input type="submit" name="next"
             class="btn btn-block bg-gradient-primary btn-m" value="Next"/>
             </div>
            </div>
              <div class="form-group">
	             <div class="input-group">
	             <div class="input-group-prepend">
                 <span></span>
                    </div>
              <input type="submit" name="exit"
             class="btn btn-block bg-gradient-primary btn-m" value="Exit"/>
             </div>
            </div>
          </div>
	    </div>
		</div> 
            </form:form>
            </div>
           </div>
        </div>
       
          </div>
            </div>
            </section>
  
    <!-- /.content -->
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
