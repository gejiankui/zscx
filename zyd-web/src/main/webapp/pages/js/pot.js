$(function() {
    $('.input-kw-form').on('submit', function(event){
        event.preventDefault();
    });
    initSearch();
    initSwiper();
});

function initSwiper() {
    $.ajax({
        url : Fun.myBaseUrl + 'carousel/queryCarousels.do?figureType=2',
        type : 'post',
        dataType : 'json',
        success : function(resp) {
            if (resp.data != null && resp.data.length > 0) {
                var getSwiperhtml = _.template($("#Swiper").html(), {
                    list: resp.data
                });
                $('#swiper-wrapper').html('');
                $('#swiper-wrapper').append(getSwiperhtml);
                swiperAction();
            } else {
                $('#swiper-wrapper').html('');
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

//查询器型
function initSearch() {
    var sword = $('#sword').val();
    $.ajax({
        url : Fun.myBaseUrl + 'shape/search.do?sp='+sword,
        type : 'post',
        dataType : 'json',
        beforeSend : function() {
            Fun.loader.show("正在搜索....");
        },
        success : function(resp) {
            if(resp.status == "1"){
                alert(resp.msg);
            } else {
                if (resp.data != null) {
                    var getPothtml = _.template($("#PotArea").html(), {
                        mdata : resp.data
                    });
                    $('#potArea').html('');
                    $('#potArea').append(getPothtml);
                } else {
                    $('#potArea').html("<div style='text-align:center;font-size:12px'>未能搜索到相关壶型~</div>");
                }
            }
        },
        complete : function() {
            Fun.loader.hide();
        }
    });
}

function todetail(shapeId) {
    if (shapeId == null || shapeId == "") {
        return;
    }
    location.href = Fun.myBaseUrl+"pages/pot_detail.html?s="+shapeId;
}

function swiperAction() {
    var newSlideSize = function slideSize(){
        var w = Math.ceil($(".swiper-container").width()*(540/1242)/*--调整高度---*/);
        $(".swiper-container,.swiper-wrapper,.swiper-slide").height(w);
    };
    newSlideSize();
    $(window).resize(function(){
        newSlideSize();
    });

    var mySwiper = new Swiper('.swiper-container',{
        pagination: '.pagination',
        loop:false,
        autoplay:3000,
        paginationClickable: false,
        onSlideChangeStart: function(){
            //回调函数
        },
        onTouchEnd: function(a){
            a.startAutoplay();
        }
    });
}
