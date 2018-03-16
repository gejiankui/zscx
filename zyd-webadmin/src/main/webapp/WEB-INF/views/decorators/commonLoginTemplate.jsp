<%@ include file="/WEB-INF/views/common/taglibs-include.jsp"%>

<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <title>xx</title>
    <meta http-equiv="Cache-Control" content="max-age=0">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="Pragma" content="no-cache">     
    <link rel="stylesheet" href="<c:url value='/style/login-site.css'/>" type="text/css" />
    <link rel="stylesheet" href="<c:url value='/style/admin-content.css'/>" type="text/css" />
    <link rel="icon" type="image/x-icon" href="<c:url value='/images/logo_s.jpg'/>">
    
    <decorator:head/>
</head>

<body>
    <div id="wrapper">
        <div id="header"></div>
        <div id="content-wrapper">

            <decorator:body />

        </div>
        
        <div id="footer" align="center">
            <p>
            <!-- Keep these links or make a $10 donation  -->
                京 ICP 备 12050586  技术支持：南京一汀网络科技+万事屋
            </p>
        </div>
    </div>
</body>
</html>
