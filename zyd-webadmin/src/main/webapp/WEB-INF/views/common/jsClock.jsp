<script type="text/javascript">
	<%
		long millisecond = new java.util.Date().getTime();
	%>

	var millisecond = <%=millisecond%>;

	function tick() {
		Date.prototype.Format = function(informat) //author: meizz 
		{ 
		var inputStr = ""; 
		var format = this.format; 
		if(informat!=null)format = informat; 
		var o = { 
		"M+" : this.getMonth()+1, 
		"d+" : this.getDate(),   
		"h+" : this.getHours(), 
		"H+" : this.getHours(), 
		"m+" : this.getMinutes(), 
		"s+" : this.getSeconds() 
		} 
		if(/(y+)/.test(format)) format=format.replace(RegExp.$1,(this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
		for(var k in o)if(new RegExp("("+ k +")").test(format)) 
		{ 
		format = format.replace(RegExp.$1,RegExp.$1.length==1 ? o[k]:("00"+ o[k]).substr((""+ o[k]).length)); 
		} 
		return format; 
		} 
	
		millisecond = millisecond + 1000;
		
		var d = new Date(millisecond); 
		var d2 = d.Format('yyyy-MM-dd HH:mm:ss');
		timeString = d2;
		$("#clock").html(timeString);
		window.setTimeout("tick();", 1000);
	}

  jQuery().ready(function (){
	  tick();
  });
</script>