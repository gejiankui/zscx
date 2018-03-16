<%@ include file="/WEB-INF/views/common/js-include.jsp"%>
<%@ include file="/WEB-INF/views/common/css-include.jsp"%>
<%@ include file="/WEB-INF/views/common/validation-header.jsp"%>

<html class="dj_gecko">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<title><spring:message code="project.name" /></title>
<meta http-equiv="Cache-Control" content="max-age=0">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="Pragma" content="no-cache">
<link rel="stylesheet" href="<c:url value='/style/site.css'/>"
	type="text/css" />
<link rel="stylesheet" href="<c:url value='/style/admin-content.css'/>"
	type="text/css" />
<link rel="stylesheet" href="<c:url value='/style/menu.css'/>"
	type="text/css" />
<link rel="stylesheet" href="<c:url value='/style/menu-ex1.css'/>"
	type="text/css" />
<link rel="stylesheet" href="<c:url value='/style/footer.css'/>"
	type="text/css" />
<link rel="stylesheet" href="<c:url value='/style/admin-header.css'/>"
	media="screen" type="text/css" />
<link rel="icon" type="image/x-icon"
	href="<c:url value='/images/logo_s.jpg'/>">

<style media="print">
.noPrint {
	display: none;
}

.PageNext {
	page-break-after: always;
}
</style>
<script type="text/javascript"
	src="<c:url value='/script/common/menu.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/script/common/menuExpandable.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/script/common/menubar.js'/>"></script>
<script type="text/javascript">
var FUN = {};
$.extend($.fn.validatebox.defaults.rules, {
    equals: {
        validator: function(value,param){
            return value == $(param[0]).val();
        }
    },
    regular: {
        validator: function (value, param) {
            this.message = param[1];
            var reg = new RegExp(param[0]);
            return reg.test(value);
        }
    }
});
$(function() {
    if ($('#dg').length > 0)
    {
        $('#dg').datagrid({
            field:'authURL',
            url:'dataGridQuery.do',
            method:'get',
            singleSelect:true,
            height:'auto',
            width:'auto',
            collapsible:true,
            rownumbers:true,
            autoRowHeight:true,
            autoRowWidth:true,
            fitColumns:true,
            pagination:true,
            loadMsg:'<spring:message code="pagination.label.loadMsg" />',
            onLoadSuccess: function(data){
                resizeForm();
            }
        });
        var pager = $('#dg').datagrid('getPager'); // get the pager of datagrid
        $(pager).pagination({
            pageSize : 10,//每页显示的记录条数，默认为10  
            pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表  
            beforePageText : '<spring:message code="pagination.label.beforePageText" />',//页数文本框前显示的汉字  
            afterPageText : '<spring:message code="pagination.label.afterPageText" />',
            displayMsg : '<spring:message code="pagination.label.displayMsg" />'
        });

    }
})

jQuery(document).ready(function() {
    $("#mainForm").validationEngine();
    $.ajaxSetup({complete:ajaxComplete});
    //创建form
    FUN.createForm = function(opts){
    var formObj = {
      url : '',
      method : 'post',
      data  : '',
      debug : false
    };
    var randNum = Math.floor(Math.random()*1000);
    formObj = $.extend(formObj,opts);

    if(FUN.isIE6){
      var target = 'target="_blank"';
    }else{
      var target = '';
    }

    allHtml = '<form id="submit'+randNum+'" '+ target +' action="'+formObj.url+'" method="'+formObj.method+'" ></form>';
    $('body').append(allHtml);

    var i = 0;
    $.each(formObj.data,function(key, value){
      i++;
      $('#submit' + randNum).append("<input type='hidden' id=" + randNum + "_" + i + " />");
      $("#" + randNum + "_" + i).attr({name:key, value:value});
    })
    $('#submit'+randNum).submit(function(){
      return !formObj.debug;
    })
    $('#submit'+randNum).trigger('submit');

  };
});
//ajax完成动作
function ajaxComplete(XMLHttpRequest,textStatus)
{
	sessionTimeOut(XMLHttpRequest,textStatus);
}

//session过期
function sessionTimeOut(XMLHttpRequest,textStatus)
{
	if(XMLHttpRequest.getResponseHeader("sessionTimeout") == "Y")
    {
       $.messager.alert('<spring:message code="message.information.general.title"/>',
               '<spring:message code="message.exception.lost.login"/>',
               'error',
               function(){
                   window.location.href="<spring:url value='/login/access.do'/>";
               });
    }
}


function fixWidth(percent)
{
    return document.body.clientWidth * percent ;
}
function formatBoolean(val, row) {
    if (val)
    {
        return "<spring:message code='boolean.Y' />";
    }
    else 
    {
    	return "<spring:message code='boolean.N' />";
    }
}

function validateIsImage(fileObj)
{
    var filePath = fileObj.value;
    var pathArr = filePath.split(".");
    var fileType = pathArr[pathArr.length-1];
    var type=[];
    type[0] = 'png';
    type[1] = 'jpg';
    type[2] = 'jpeg';
    type[3] = 'gif';
    var is_img = imgType(fileType, type);

    if (is_img == false)
    {
        $.messager.alert(
                "<spring:message code='message.information.general.title'/>",
                "<spring:message code='message.failed.general.upload.notImage'/>");
        fileObj.value = '';
    }
}
function imgType(fileType, type)
{
    var count = type.length;
    fileType = fileType.toLowerCase();
    for (var i = 0; i<count; i++)
    {
        if (type[i] == fileType)
        {
            return true;
        }
    }
    return false;
}
</script>
<decorator:head />
</head>
<body>
	<div id="container">
		<table style="width:100%;" border="0" cellpadding="0" cellspacing="0">
			<tr  width="100%">
				<td colspan="2" >
					<!-- page title -->
					<%@ include file="/WEB-INF/views/decorators/title.jsp"%>
					<!-- end page title -->
				</td>
			</tr>
			<tr>
				<td style="vertical-align:top;" >
					<!-- menu page -->
					<%@ include file="/WEB-INF/views/decorators/menu.jsp"%>
					<!-- end menu page -->
				</td>
				<td style="vertical-align:top;padding-left:8px;">
					<!-- main area -->
					<decorator:body />
					<!-- end main area -->
					<br/>
					<br/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<!-- page bottom -->
					<%@ include file="/WEB-INF/views/decorators/footer.jsp"%>
					<!-- end page bottom -->
				</td>
			</tr>
		</table>
	</div>
	<script type="text/javascript">
		function resizeForm()
		{
			if($(".buttonWrapper").size()>0)
			{
				$(".buttonWrapper").css("padding-right","10");
			}
			
			$('#searchPanel').panel('resize',{
				width: document.body.clientWidth - 190,
				height:'auto'
			});

			$('#mainPanel').panel('resize',{
				width: document.body.clientWidth - 190,
				height:'auto'
			});		
			
			$('#mainPanel1').panel('resize',{
				width: document.body.clientWidth - 190,
				height:'auto'
			});			

			$('#dg').datagrid('resize',{
				width: document.body.clientWidth - 190,
				height:'auto'
			});
		}
		
		$(window).resize(function() {
			resizeForm();
		});
		
		$(function() {
			resizeForm();
		});
    </script>
</body>
</html>