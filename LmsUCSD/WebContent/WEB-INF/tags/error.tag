<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<head>
    <title>Error page</title>
</head>
<body>
<div class="container">
    <h3><c:out value="${error_human}" /></h3>

    <p><br/><br/></p>

    <div class="panel panel-primary">
        <div class="panel-heading">
            <c:out value="${error_tech}" />
        </div>
        <div class="panel-body">
            <p><c:out value="${exception_message}" /></p>
        </div>
    </div>
</div>
</body>
</html>