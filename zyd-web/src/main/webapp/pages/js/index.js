
$(function() {
    $('.input-kw-form').on('submit', function(event){
        event.preventDefault();
    });
});

//初始化推广数据
function initGeneralize() {
	$.ajax({
		url : Fun.myBaseUrl + 'generalize/queryGeneralizes.do?position=1',
		type : 'post',
		dataType : 'json',
		success : function(resp) {
			var getGeneralizehtml = _.template($("#generalizeRlt").html(), {
				list : resp.data
			});
            $('.window').html('');
			$('.window').append(getGeneralizehtml);
            $('.window').show();
			// wx.config({
			//     debug: false,
			//     appId: resp.signPackage.appId,
			//     timestamp: resp.signPackage.timestamp,
			//     nonceStr: resp.signPackage.nonceStr,
			//     signature: resp.signPackage.signature,
			//     jsApiList: [
			//     	'checkJsApi',
			//         'onMenuShareTimeline',
			//         'onMenuShareAppMessage'
			//     ]
			// });
		}
	});
}

function search(){
    var sword = $("#sword").val();
    if (sword == null || sword == "") {
    	return;
	}
	//跳转到查询页展示
    location.href = Fun.myBaseUrl+"pages/professional.html?sword="+sword;
}

function search(){
    var sword = $("#sword").val();
    if (sword == null || sword == "") {
        return;
    }
    //跳转到查询页展示
    location.href = Fun.myBaseUrl+"pages/professional.html?sword="+sword;
}

function todetail(userId) {
    if (userId == null || userId == "") {
        return;
    }
    location.href = Fun.myBaseUrl+"pages/p_detail.html?u="+userId;
}