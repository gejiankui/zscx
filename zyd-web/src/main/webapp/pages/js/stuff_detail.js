$(function() {
    initStuffInfo();
});

//初始化泥料详情页面
function initStuffInfo() {
    var pId = Fun.reqParams.p;
    if (pId == null || pId == "") {
        return;
    }
    $.ajax({
        url : Fun.myBaseUrl + 'pug/getPug.do?pId='+pId,
        type : 'post',
        dataType : 'json',
        success : function(resp) {
            if (resp.data == null) {
                alert("获取泥料信息失败");
                return;
            }
            document.title = resp.data.pugName;
            $('#pImg').html(resp.data.thumbImg);
            var getStuffhtml = _.template($("#StuffInfo").html(), {
                pug : resp.data
            });

            $('#stuffInfo').append(getStuffhtml);

            if (resp.data.referencesInfoDtos != null) {
                var getRefhtml = _.template($("#RefInfo").html(), {
                    list : resp.data.referencesInfoDtos
                });
                $('#refInfo').append(getRefhtml);
            }
            if (resp.data.specialThanksDtos != null) {
                var getSpechtml = _.template($("#SpecInfo").html(), {
                    list : resp.data.specialThanksDtos
                });
                $('#specInfo').append(getSpechtml);
            }
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

function showOrHideCover(userId){
    if($(".cover").css("display")=="none"){
        if (userId == null || userId == "") {
            alert("无效操作");
            return;
        }
        $.ajax({
            url : Fun.myBaseUrl + 'user/getUser.do?uId='+userId,
            type : 'post',
            dataType : 'json',
            success : function(resp) {
                if (resp.data == null) {
                    alert("获取艺人信息失败");
                    return;
                }
                var getCoverhtml = _.template($("#Cover").html(), {
                    u : resp.data
                });
                $('.cover').append(getCoverhtml);
                $('.cover').show();

                var phoneWidth = document.body.clientWidth;
                phoneWidth = phoneWidth - (phoneWidth*0.06);
                var pic04H = phoneWidth/2*0.94;

                if (resp.data.userImg == null || resp.data.userImg == "") {
                    pic04H = 2;
                }
                var nameTop = (pic04H+32)/16 - 0.1;
                var contentTop = nameTop + 1.4;
                $(".pic_04").css("height", pic04H+"px");
                $(".name_cover").css("top", nameTop+"rem");
                $(".content").css("top", contentTop+"rem");

            },
        });
    }else{
        $(".cover").html("");
        $(".cover").hide();
    }
}
