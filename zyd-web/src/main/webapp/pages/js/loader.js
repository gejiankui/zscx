
$(function(){
 var loader ='<div id="mask" style="display: none;  position: absolute;  top: 0%;  left: 0%;  width: 100%;  height: 100%;  background-color: black;  z-index:9998;  -moz-opacity: 0.7;  opacity:.70;  filter: alpha(opacity=70);"></div>'
        +'<div  id="loader" class="div" style="visibility:hidden; width: 30%; border:1px solid gray; height:12%;left:27.5%;top:30%;position: fixed; background-color:#ffffff;-moz-border-radius: 10px;-webkit-border-radius: 10px;border-radius:10px;font-size:12px;z-index:9999;filter:alpha(Opacity=100);-moz-opacity:1;opacity: 1;" align="center">'
        +'<div style="width: 16px; height:16px;background: url(images/loader.gif); margin-top: 10px;"></div>'
        +'<div id="title" style="margin-top: 10px;">正在加载</div>'
        +'</div>';
 $(document.body).append(loader);
 function sc1()
 { 
 	var wh = getWH();
 	$("#mask").css({'width':wh.w,'height':wh.h});
    document.getElementById("loader").style.top=(document.documentElement.scrollTop+(document.documentElement.clientHeight-document.getElementById("loader").offsetHeight)/3)+"px"; 
    document.getElementById("loader").style.left=(document.documentElement.scrollLeft+(document.documentElement.clientWidth-document.getElementById("loader").offsetWidth)/2)+"px"; 
 } 
    window.onscroll=sc1; 
    window.onresize=sc1; 
    window.onload=sc1; 
    var getWH = function (){
    var d = document,doc = d[d.compatMode == "CSS1Compat"?'documentElement':'body'];
    return function(f){
    return {
    w:doc[(f?'client':'scroll')+'Width'],
    h:f?doc.clientHeight:Math.max(doc.clientHeight,doc.scrollHeight)
    }
    }
    }();
});
