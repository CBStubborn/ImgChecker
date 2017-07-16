<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../commons/global.jsp" %>
<c:set var="baseUrl" value="${ctx}/img-checker"></c:set>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="../commons/head.jsp" %>
    <style type="text/css">
        .login-form {
            margin: 0 auto;
            width: 340px;
        }

        .login-form-body {
            border-radius: 5px;
            padding: 20px;
            font-size: 14px;
            background-color: #fff;
            border: 1px solid #d8dee2;
        }
        .form-group{
            padding: 5px 0;
        }
        .header {
            background-color: transparent;
            text-align: center;
            border-bottom: 0;
            font-weight: 500;
            padding: 80px 0 100px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="login-form">
        <form  method="post" id="enterForm">
            <div class="login-form-body">
                <div class="form-group">
                    <label for="sequence" style="display:inline-block;width:60px;">序号</label>
                    <input type="text" id="sequence" name="sequence" class="form-control"/>
                </div>
                <button type="button" class="btn btn-custom btn-block" id="startBtn">开始</button>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript">

    $('#startBtn').click(function (e) {
        e.preventDefault();
        var inputValue=$('#sequence').val();
        $('#enterForm').attr('action', '${baseUrl}/checking/?sequence='+inputValue);
        $('#enterForm').submit();
    });

</script>
</body>
</html>