$(function() {
    $('.input-kw-form').on('submit', function(event){
        event.preventDefault();
    });

    initSword();
});

function initSword() {
    var sword = Fun.reqParams.sword;
    if (sword != null && sword!="") {
		$("#sword").val(sword);
        initSearch();
    } else {
        $('#writeBlock').hide();
    }
}

//初始化作品页面
function initGeneralize() {
    var sword = Fun.reqParams.sword;
    if (sword != null && sword != "") {
        return;
    }
    $.ajax({
        url : Fun.myBaseUrl + 'generalize/queryGeneralizes.do?position=2',
        type : 'post',
        dataType : 'json',
        success : function(resp) {
            var getGeneralizehtml = _.template($("#generalizeRlt").html(), {
                list : resp.data
            });
            $('.window_02').html('');
            $('.window_02').append(getGeneralizehtml);
            $('.line_kb').hide();
            $('.window_02').show();
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
        },
    });
}

function search() {
    var sword = $("#sword").val();
    if (sword == null || sword == "") {
        return;
    }
    location.href = Fun.myBaseUrl+"pages/professional.html?sword="+sword;
}

function todetail(userId) {
    if (userId == null || userId == "") {
        return;
    }
    location.href = Fun.myBaseUrl+"pages/p_detail.html?u="+userId;
}

function initSearch(){
    var sword = $("#sword").val();
	$.ajax({
		url : Fun.myBaseUrl + 'user/search.do?sp='+sword,
		type : 'post',
		dataType : 'json',
		beforeSend : function() {
			Fun.loader.show("正在搜索....");
		},
		success : function(resp) {
			if(resp.status == "1"){
				alert(resp.msg);
			} else {
			    if (resp.data.length > 0) {
                    var getSearchRlthtml = _.template($("#searchRlt").html(), {
                        list : resp.data
                    });
                    $('.list_find').html('');
                    $('.list_find').append(getSearchRlthtml);
                    $('#writeBlock').show();
                } else {
                    $('.list_find').html('<div style="width:100%; height:10rem">  <img class="none" src="images/none.png" /> <p class="c24">该艺人尚未申请录入个人信息</p> </div>');
                    $('#writeBlock').hide();
                }
            }
		},
		complete : function() {
			Fun.loader.hide();
		}
	});
}