<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../commons/global.jsp" %>
<c:set var="baseUrl" value="${ctx}/img-checker"></c:set>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="../commons/head.jsp" %>
</head>
<body>
<c:choose>
    <c:when test="${not empty imgCheckerTable}">
        <div class="easyui-layout main-layout">
            <c:set var="imgUrl" value="${imgCheckerTable.imgUrl}"></c:set>
            <form id="img-check-form" method="post" action="${baseUrl}/checked">
                <div>
                    <img src="${imgUrl}" width="1100" height="600"/>
                </div>
                <div class="form-group">
                    <div>
                        <c:set var="imgFileName" value="${split(imrUrl)}"></c:set>
                        <p align="center">${imgFileName}</p>
                    </div>
                    <div class="col-sm-offset-1" style="text-align:center;">
                        <input type="checkbox" value="${imgCheckerTable.id}" name="id" style="display:none">
                        <input type="checkbox" value="${sequence}" name="sequence" style="display:none">
                        <c:forEach var="item" items="${recognizeResults}">
                            <label><input type="checkbox" value="${item}" name="recognizeResults"/> ${item}</label>&nbsp;
                        </c:forEach>
                    </div>
                    <div>
                         <input type="submit" value="提交" class="btn btn-custom btn-sm" id="saveBtn">
                    </div>
                </div>
            </form>
        </div>
    </c:when>
    <c:otherwise>
        <h1 align="center">恭喜您，全部图片审核完毕</h1>
    </c:otherwise>
</c:choose>

<!--
<script type="text/javascript">

    $('#saveBtn').click(function (e) {
        e.preventDefault();
        $('#img-check-form').attr('action', '${baseUrl}/checked?success=true&id=${imgCheckerTable.id}&sequence=${sequence}');
        $('#img-check-form').submit();
    });

    function split(input) {
        var imgFileNameArray="";
        imgFileNameArray=input .split("/");
        imgFileName=imgFileNameArray[4];
        return imgFileName;
    }

</script>
-->
</body>
</html>