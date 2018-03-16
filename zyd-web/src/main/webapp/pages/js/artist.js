$(function() {
    initCategory();
});

//初始化页面
function initCategory() {
    $.ajax({
        url : Fun.myBaseUrl + 'user/getUserCategory.do',
        type : 'post',
        dataType : 'json',
        success : function(resp) {
            var getCategoryhtml = _.template($("#categoryRlt").html(), {
                list : resp.data
            });
            $('#sidebar').html('');
            $('#sidebar').append(getCategoryhtml);
            if (resp.data != null && resp.data.length > 0) {
                search(resp.data[0].categoryId,resp.data[0].introduction);
            }
        },
    });
}

function todetail(userId) {
    if (userId == null || userId == "") {
        return;
    }
    location.href = Fun.myBaseUrl+"pages/p_detail.html?u="+userId;
}

function search(cid,introduction){
    $('#categoryDec').html(introduction);
    $('#userArea').html('');
    $('#c_' + cid).addClass('active').siblings('li').removeClass('active');
	$.ajax({
		url : Fun.myBaseUrl + 'user/getUserByCid.do?cId='+cid,
		type : 'post',
		dataType : 'json',
		beforeSend : function() {
			Fun.loader.show("正在搜索....");
		},
		success : function(resp) {
			if(resp.status == "1"){
				alert(resp.msg);
			} else {
			    if (resp.data != null && resp.data.length > 0) {
                    var getSearchRlthtml = _.template($("#userRlt").html(), {
                        list : resp.data
                    });
                    // $('#userArea').html('');
                    $('#userArea').append(getSearchRlthtml);
                } else {
                    $('#userArea').html('<div style="width:100%; height:10rem">  <img class="none" src="images/none.png" /> <p class="c24">该艺人尚未申请录入个人信息</p> </div>');
                }
            }
		},
		complete : function() {
			Fun.loader.hide();
		}
	});
}